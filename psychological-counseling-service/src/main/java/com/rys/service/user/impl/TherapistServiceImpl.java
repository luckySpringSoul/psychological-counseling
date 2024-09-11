package com.rys.service.user.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rys.db.entity.Therapist;
import com.rys.db.entity.User;
import com.rys.db.mapper.TherapistMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rys.entity.Result;
import com.rys.request.RequestPage;
import com.rys.request.admin.AddTherapistRequest;
import com.rys.request.user.PherapistQueryRequest;
import com.rys.response.PageInfoResponse;
import com.rys.response.user.login.AddUserRequest;
import com.rys.response.user.login.LoginRequest;
import com.rys.response.user.login.LoginResponse;
import com.rys.service.user.TherapistService;
import com.rys.utils.DateTimeUtils;
import com.rys.utils.jwt.AuthLocal;
import com.rys.utils.jwt.JwtUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
@Service
public class TherapistServiceImpl extends ServiceImpl<TherapistMapper, Therapist> implements TherapistService {

    public static final String MATCH = "yyyy-MM-dd HH:mm:ss";
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public PageInfoResponse<Therapist> getMatchPherapist(PherapistQueryRequest pherapistQueryRequest) {
        IPage<Therapist> therapistIPage = new Page<>();
        therapistIPage.setCurrent(pherapistQueryRequest.getPageCurrent());
        therapistIPage.setSize(pherapistQueryRequest.getPageSize());
        IPage<Therapist> page = this.page(therapistIPage, buildQueryWrapper(pherapistQueryRequest));
        PageInfoResponse<Therapist> pageInfoResponse = new PageInfoResponse<>();
        pageInfoResponse.setTotal(page.getTotal());
        pageInfoResponse.setPages(page.getPages());
        pageInfoResponse.setRecords(page.getRecords());
        pageInfoResponse.setCurrent(page.getCurrent());
        return pageInfoResponse;
    }

    @Override
    public Result<LoginResponse> login(LoginRequest loginRequest) {
        if (!StrUtil.isAllNotBlank(loginRequest.getPhone(), loginRequest.getPassword())) {
            return Result.fail("登录账号或密码不能为空");
        }
        Therapist user = this.lambdaQuery().eq(Therapist::getPhone, loginRequest.getPhone()).last("limit 1").one();
        if (Objects.equals(user, null)) {
            return Result.fail("账号不存在,请输入正确的账号");
        }
        if (!Objects.equals(DigestUtils.md5Hex(loginRequest.getPassword()), user.getPassword())) {
            return Result.fail("账号或者密码错误");
        }
        Map<String, Object> tokenMap = new HashMap<>(16);
        tokenMap.put("id", user.getId().toString());
        tokenMap.put("therapistName", user.getName());
        tokenMap.put("phone", user.getPhone());
        tokenMap.put("status", user.getStatus());

        JSONObject riderObject = JSONObject.parseObject(JSON.toJSONString(tokenMap));
        String token = jwtUtil.genToken(riderObject);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMobilePhone(user.getPhone());
        loginResponse.setToken(token);
        loginResponse.setHaveRegistered(true);
        return Result.success("登录成功", loginResponse);
    }

    @Override
    public void addTherapist(AddTherapistRequest addTherapistRequest) {
        Therapist exist = lambdaQuery().eq(Therapist::getPhone, addTherapistRequest.getPhone()).last("limit 1").one();
        if (Objects.nonNull(exist)) {
            throw new RuntimeException("当前手机号用户已经存在");
        }

        Therapist user = new Therapist();
        user.setAppointmentStartTime(addTherapistRequest.getAppointmentStartTime());
        user.setAppointmentEndTime(addTherapistRequest.getAppointmentEndTime());
        user.setSpecialization(addTherapistRequest.getSpecialization());
        user.setPhone(addTherapistRequest.getPhone());
        user.setName(addTherapistRequest.getName());
        user.setGender(addTherapistRequest.getGender());
        user.setPassword(DigestUtils.md5Hex(addTherapistRequest.getPassword()));
        this.save(user);
    }

    @Override
    public void editTherapist(AddTherapistRequest addUserRequest) {
        Therapist exist = lambdaQuery().eq(Therapist::getPhone, addUserRequest.getPhone()).last("limit 1").one();
        if (Objects.nonNull(exist)) {
            throw new RuntimeException("当前手机咨询师已经存在");
        }

        Therapist user = new Therapist();
        user.setId(Long.valueOf(AuthLocal.getUser().getId()));
        user.setName(addUserRequest.getName());
        user.setPhone(addUserRequest.getPhone());
        user.setPassword(DigestUtils.md5Hex(addUserRequest.getPassword()));
        user.setGender(addUserRequest.getGender());
        user.setSpecialization(addUserRequest.getSpecialization());
        user.setAppointmentStartTime(addUserRequest.getAppointmentStartTime());
        user.setAppointmentEndTime(addUserRequest.getAppointmentEndTime());
        this.updateById(user);
    }

    @Override
    public PageInfoResponse<Therapist> allTherapists(PherapistQueryRequest pherapistQueryRequest) {
        IPage<Therapist> page = new Page<>();
        page.setSize(pherapistQueryRequest.getPageSize());
        page.setCurrent(pherapistQueryRequest.getPageCurrent());
        IPage<Therapist> resp = this.page(page, buildQueryWrapper(pherapistQueryRequest));
        PageInfoResponse<Therapist> pageInfoResponse = new PageInfoResponse<>();
        pageInfoResponse.setRecords(resp.getRecords());
        pageInfoResponse.setTotal(resp.getTotal());
        pageInfoResponse.setPages(resp.getPages());
        pageInfoResponse.setCurrent(resp.getCurrent());
        return pageInfoResponse;
    }

    private LambdaQueryWrapper<Therapist> buildQueryWrapper(PherapistQueryRequest pherapistQueryRequest) {
        LambdaQueryWrapper<Therapist> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(pherapistQueryRequest.getPhone()), Therapist::getPhone,
            pherapistQueryRequest.getPhone());
        queryWrapper.eq(StringUtils.isNotBlank(pherapistQueryRequest.getCategory()), Therapist::getSpecialization,
            pherapistQueryRequest.getCategory());
        queryWrapper.likeLeft(StringUtils.isNotBlank(pherapistQueryRequest.getName()), Therapist::getName,
            pherapistQueryRequest.getName());
        queryWrapper.ge(StringUtils.isNotBlank(pherapistQueryRequest.getReserveTime()),
            Therapist::getAppointmentStartTime, pherapistQueryRequest.getReserveTime() + " 00:00:00");
        queryWrapper.le(StringUtils.isNotBlank(pherapistQueryRequest.getReserveTime()),
            Therapist::getAppointmentEndTime, pherapistQueryRequest.getReserveTime() + " 23:59:00");
        return queryWrapper;

    }
}
