package com.rys.service.user.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rys.db.entity.Therapist;
import com.rys.db.entity.User;
import com.rys.db.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rys.entity.Result;
import com.rys.request.RequestPage;
import com.rys.request.UserQueryReq;
import com.rys.response.PageInfoResponse;
import com.rys.response.UserResp;
import com.rys.response.user.login.AddUserRequest;
import com.rys.response.user.login.LoginRequest;
import com.rys.response.user.login.LoginResponse;
import com.rys.service.user.UserService;
import com.rys.utils.jwt.AuthLocal;
import com.rys.utils.jwt.JwtUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public Result<LoginResponse> getUserByPhone(LoginRequest loginRequest) {
        if (!StrUtil.isAllNotBlank(loginRequest.getPhone(), loginRequest.getPassword())) {
            return Result.fail("登录账号或密码不能为空");
        }
        User user = lambdaQuery().eq(User::getPhone, loginRequest.getPhone()).last("limit 1").one();
        if (Objects.equals(user, null)) {
            return Result.fail("账号不存在,请输入正确的账号");
        }
        if (!Objects.equals(DigestUtils.md5Hex(loginRequest.getPassword()), user.getPassword())) {
            return Result.fail("账号或者密码错误");
        }
        Map<String, Object> tokenMap = new HashMap<>(16);
        tokenMap.put("id", user.getId().toString());
        tokenMap.put("userName", user.getName());
        tokenMap.put("phone", user.getPhone());
        tokenMap.put("status", user.getStatus());
        tokenMap.put("roleType", user.getRoleType());

        JSONObject riderObject = JSONObject.parseObject(JSON.toJSONString(tokenMap));
        String token = jwtUtil.genToken(riderObject);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMobilePhone(user.getPhone());
        loginResponse.setToken(token);
        loginResponse.setHaveRegistered(true);
        return Result.success("登录成功", loginResponse);
    }

    @Override
    public void addUser(AddUserRequest addUserRequest) {

        User exist = lambdaQuery().eq(User::getPhone, addUserRequest.getPhone())
            .eq(User::getRoleType, addUserRequest.getRoleType()).last("limit 1").one();
        if (Objects.nonNull(exist)) {
            throw new RuntimeException("当前手机号信息已经存在");
        }

        User user = new User();
        user.setEmail(addUserRequest.getEmail());
        user.setName(addUserRequest.getName());
        user.setPhone(addUserRequest.getPhone());
        user.setPassword(DigestUtils.md5Hex(addUserRequest.getPassword()));
        user.setGender(addUserRequest.getGender());
        user.setSpecialization(addUserRequest.getSpecialization());
        user.setAppointmentStartTime(addUserRequest.getAppointmentStartTime());
        user.setAppointmentEndTime(addUserRequest.getAppointmentEndTime());
        this.save(user);
    }

    @Override
    public void editUser(AddUserRequest addUserRequest) {
        User exist = lambdaQuery().eq(User::getPhone, addUserRequest.getPhone())
            .eq(User::getRoleType, addUserRequest.getRoleType()).last("limit 1").one();
        if (Objects.nonNull(exist)) {
            throw new RuntimeException("当前手机号用户已经存在");
        }

        User user = new User();
        user.setEmail(addUserRequest.getEmail());
        user.setName(addUserRequest.getName());
        user.setPhone(addUserRequest.getPhone());
        if (StringUtils.isNotBlank(addUserRequest.getPassword())) {
            user.setPassword(DigestUtils.md5Hex(addUserRequest.getPassword()));
        }
        user.setGender(addUserRequest.getGender());
        user.setSpecialization(addUserRequest.getSpecialization());
        user.setAppointmentStartTime(addUserRequest.getAppointmentStartTime());
        user.setAppointmentEndTime(addUserRequest.getAppointmentEndTime());
        this.updateById(user);
    }

    @Override
    public PageInfoResponse<UserResp> allUsers(UserQueryReq userQueryReq) {
        IPage<User> page = new Page<>();
        page.setSize(userQueryReq.getPageSize());
        page.setCurrent(userQueryReq.getPageCurrent());
        IPage<User> resp = this.page(page, buildQueryWrapper(userQueryReq));
        PageInfoResponse<UserResp> pageInfoResponse = new PageInfoResponse<>();

        List<UserResp> userResps = resp.getRecords().stream().map(User::buildResp).collect(Collectors.toList());
        pageInfoResponse.setRecords(userResps);
        pageInfoResponse.setTotal(resp.getTotal());
        pageInfoResponse.setPages(resp.getPages());
        pageInfoResponse.setCurrent(resp.getCurrent());
        return pageInfoResponse;
    }

    private LambdaQueryWrapper<User> buildQueryWrapper(UserQueryReq userQueryReq) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Objects.nonNull(userQueryReq.getId()), User::getId, userQueryReq.getId());
        queryWrapper.likeLeft(StrUtil.isNotBlank(userQueryReq.getName()), User::getName, userQueryReq.getName());
        queryWrapper.eq(StringUtils.isNotBlank(userQueryReq.getPhone()), User::getPhone, userQueryReq.getPhone());
        queryWrapper.eq(StringUtils.isNotBlank(userQueryReq.getCategory()), User::getSpecialization,
            userQueryReq.getCategory());
        queryWrapper.ge(StringUtils.isNotBlank(userQueryReq.getReserveTime()),
            User::getAppointmentStartTime, userQueryReq.getReserveTime() + " 00:00:00");
        queryWrapper.le(StringUtils.isNotBlank(userQueryReq.getReserveTime()),
            User::getAppointmentEndTime, userQueryReq.getReserveTime() + " 23:59:00");
        return queryWrapper;
    }

}
