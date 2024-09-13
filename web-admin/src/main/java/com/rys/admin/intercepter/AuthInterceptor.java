package com.rys.admin.intercepter;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.rys.annotation.Anonymous;
import com.rys.utils.exception.BusinessException;
import com.rys.utils.exception.CommentExceptionEnum;
import com.rys.utils.jwt.AuthLocal;
import com.rys.utils.jwt.JwtUtil;
import com.rys.utils.jwt.UserLocal;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Description 权限校验器
 * @Author lhy
 * @Date 2020/12/3
 * @Version 1.0.0
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 鉴权
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String reqURL = request.getRequestURL().toString();
        log.info("请求 URL：{}", reqURL);

        if (request.getMethod().toUpperCase().equals("OPTIONS")) {
            return true;
        }

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        //添加 @Anoymous 注解的接口不需要鉴权
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (isAnoymous(handlerMethod)) {
            return true;
        }
        String token;
        try {
            token = request.getHeader("Authorization");
        } catch (Exception e) {
            throw new BusinessException(CommentExceptionEnum.NOT_TOKEN_ERROR.getMessage());
        }
        if (StringUtils.isEmpty(token)) {
            throw new BusinessException(CommentExceptionEnum.NOT_AUTH_ERROR.getMessage());
        }

        //解析token
        DecodedJWT jwt = jwtUtil.deToken(token);
        if (jwt == null) {
            throw new BusinessException(CommentExceptionEnum.AUTH_ERROR.getMessage());
        }
        String id = jwt.getClaim("id").asString();
        String name = jwt.getClaim("name").asString();
        String phone = jwt.getClaim("phone").asString();
        String type = jwt.getClaim("roleType").asString();

        //设置用户信息
        AuthLocal.setUser(new UserLocal().setId(id)
            .setPhone(phone)
            .setName(name)
            .setType(type));

        Date expiresAt = jwt.getExpiresAt();
        //token过期
        if (expiresAt != null) {
            if (new Date().after(expiresAt)) {
                throw new BusinessException(CommentExceptionEnum.EXPIRE_ERROR.getMessage());
            }
        }
        return true;
    }

    private boolean isAnoymous(HandlerMethod handlerMethod) {
        Object bean = handlerMethod.getBean();
        //类
        Class clazz = bean.getClass();
        if (clazz.getAnnotation(Anonymous.class) != null) {
            return true;
        }
        //接口
        Method method = handlerMethod.getMethod();
        return method.getAnnotation(Anonymous.class) != null;
    }
}
