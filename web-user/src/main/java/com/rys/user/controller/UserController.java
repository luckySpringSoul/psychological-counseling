package com.rys.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rys.annotation.Anonymous;
import com.rys.db.entity.Therapist;
import com.rys.db.entity.User;
import com.rys.entity.Result;
import com.rys.request.RequestPage;
import com.rys.request.ReserveQueryReq;
import com.rys.request.SessionQueryReq;
import com.rys.request.user.PherapistQueryRequest;
import com.rys.response.PageInfoResponse;
import com.rys.response.ReserveResp;
import com.rys.response.UserResp;
import com.rys.response.user.AddFeedBackRequest;
import com.rys.response.user.ReserveTherapistRequest;
import com.rys.response.user.SessionResp;
import com.rys.response.user.login.AddUserRequest;
import com.rys.response.user.login.LoginRequest;
import com.rys.response.user.login.LoginResponse;
import com.rys.response.user.user.AddSessionRequest;
import com.rys.service.user.AppointmentService;
import com.rys.service.user.FeedbackService;
import com.rys.service.user.SessionService;
import com.rys.service.user.TherapistService;
import com.rys.service.user.UserService;
import com.rys.utils.exception.BusinessException;
import com.rys.utils.jwt.AuthLocal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
@RestController
@Api(tags = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TherapistService therapistService;

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private SessionService sessionService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登陆")
    @Anonymous
    public Result<LoginResponse> login(@Validated @RequestBody LoginRequest loginRequest) {
        if (StringUtils.isBlank(loginRequest.getPassword()) || StringUtils.isBlank(loginRequest.getPhone())) {
            Result.fail("登陆信息参数不能为空");
        }
        return userService.getUserByPhone(loginRequest);
    }

    @PostMapping("/register")
    @Anonymous
    @ApiOperation("用户注册")
    public Result register(@Validated @RequestBody AddUserRequest addUserRequest) {
        try {
            userService.addUser(addUserRequest);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        return Result.success();
    }

    @PostMapping("/edit")
    @ApiOperation("编辑用户信息")
    public Result editUser(@Validated @RequestBody AddUserRequest addUserRequest) {
        try {
            userService.editUser(addUserRequest);
        } catch (Exception e) {
            return Result.fail(e.getMessage());
        }
        return Result.success();
    }

    @GetMapping("/info")
    @ApiOperation("获取用户、咨询师个人信息")
    public Result<UserResp> getUserInfo() {
        User user = userService.getById(AuthLocal.getUser().getId());
        UserResp userResp = user.buildResp();
        return Result.success(userResp);
    }

    @GetMapping("/match-pherapist")
    @ApiOperation("获取对应的咨询师")
    public Result<PageInfoResponse<Therapist>> getMatchPherapist(PherapistQueryRequest pherapistQueryRequest) {

        return Result.success(therapistService.getMatchPherapist(pherapistQueryRequest));
    }

    @PostMapping("/reserve")
    @ApiOperation("预约指导师")
    public Result reseverTherapist(@RequestBody @Validated ReserveTherapistRequest request) {
        appointmentService.reserveTherapist(request);
        return Result.success();
    }

    @GetMapping("/myReserve")
    @ApiOperation("查看我的预约记录")
    public Result<PageInfoResponse<ReserveResp>> getReserveList(ReserveQueryReq requestPage) {
        return Result.success(appointmentService.getReserveList(requestPage, 1));
    }

    @PostMapping("/feedBack")
    @ApiOperation("针对预约进行反馈")
    public Result feedBack(@RequestBody AddFeedBackRequest addFeedBackRequest) {
        feedbackService.feedBack(addFeedBackRequest);
        return Result.success();
    }

    @PostMapping("/add/session")
    @ApiOperation("保存会话记录")
    public Result addSession(@RequestBody AddSessionRequest addSessionRequest) {
        sessionService.addSession(addSessionRequest);
        return Result.success();
    }

    @GetMapping("/listSession")
    @ApiOperation("查询用户会话记录")
    public Result<PageInfoResponse<SessionResp>> listSession(SessionQueryReq requestPage) {
        return Result.success(sessionService.listSession(requestPage, 1));
    }
}
