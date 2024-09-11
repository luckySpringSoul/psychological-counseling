package com.rys.admin.controller;

import com.rys.annotation.Anonymous;
import com.rys.constants.enums.CommonTypesEnum;
import com.rys.db.entity.Therapist;
import com.rys.entity.Result;
import com.rys.request.IdReq;
import com.rys.request.ReserveQueryReq;
import com.rys.request.SessionQueryReq;
import com.rys.request.UserQueryReq;
import com.rys.request.user.PherapistQueryRequest;
import com.rys.response.PageInfoResponse;
import com.rys.response.ReserveResp;
import com.rys.response.UserResp;
import com.rys.response.common.CommonTypeResp;
import com.rys.response.user.SessionResp;
import com.rys.service.user.AppointmentService;
import com.rys.service.user.SessionService;
import com.rys.service.user.TherapistService;
import com.rys.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wh-yiloutingfengyu
 * @version 1.0.0
 * @ClassName CommonController.java
 * @Description
 * @createTime 2024年09月08日 18:13:00
 */
@Api(tags = "公共模块接口")
@RestController
@RequestMapping("/common")
@Anonymous
public class CommonController {

    @Autowired
    private UserService userService;

    @Autowired
    private TherapistService therapistService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private SessionService sessionService;


    @GetMapping("/allTypes")
    @Anonymous
    public Result<List<CommonTypeResp>> getAllTypes() {
        List<CommonTypeResp> commonTypeRespList = new ArrayList<>();
        for (CommonTypesEnum value : CommonTypesEnum.values()) {
            CommonTypeResp commonTypeResp = new CommonTypeResp();
            commonTypeResp.setCode(value.getCode());
            commonTypeResp.setDesc(value.getDesc());
            commonTypeRespList.add(commonTypeResp);
        }
        return Result.success(commonTypeRespList);
    }

    @GetMapping("/users")
    @ApiOperation("管理员获取所有的用户")
    @Anonymous
    public Result<PageInfoResponse<UserResp>> getUsers(UserQueryReq userQueryReq) {
        userQueryReq.setRoleType(1);
        PageInfoResponse<UserResp> userPageInfoResponse = userService.allUsers(userQueryReq);
        return Result.success(userPageInfoResponse);
    }

    @GetMapping("/therapists")
    @ApiOperation("管理员获取所有的指导师")
    @Anonymous
    public Result<PageInfoResponse<UserResp>> getAllTherapists(UserQueryReq userQueryReq) {
        userQueryReq.setRoleType(2);
        PageInfoResponse<UserResp> therapistPageInfoResponse = userService.allUsers(userQueryReq);
        return Result.success(therapistPageInfoResponse);
    }


    @GetMapping("/reserves")
    @ApiOperation("管理员获取所有的预约记录")
    @Anonymous
    public Result<PageInfoResponse<ReserveResp>> getReserveList(ReserveQueryReq reserveQueryReq) {
        return Result.success(appointmentService.getReserveList(reserveQueryReq, null));
    }


    @GetMapping("/listSession")
    @ApiOperation("管理员获取所有的会话记录")
    @Anonymous
    public Result<PageInfoResponse<SessionResp>> listSession(SessionQueryReq requestPage) {
        return Result.success(sessionService.listSession(requestPage, null));
    }


    @PostMapping("/delUser")
    @ApiOperation("删除用户")
    @Anonymous
    public Result delUser(@RequestBody @Validated IdReq idReq) {
        userService.removeById(idReq.getId());
        return Result.success();
    }

    @PostMapping("/delTherapist")
    @ApiOperation("删除咨询师")
    public Result delTherapist(@RequestBody @Validated IdReq idReq) {
        userService.removeById(idReq.getId());
        return Result.success();
    }

    @PostMapping("/delSession")
    @ApiOperation("删除会话记录")
    public Result delSession(@RequestBody @Validated IdReq idReq) {
        sessionService.removeById(idReq.getId());
        return Result.success();
    }

    @PostMapping("/delReserve")
    @ApiOperation("删除预约记录")
    private Result delReserve(@RequestBody @Validated IdReq idReq) {
        appointmentService.removeById(idReq.getId());
        return Result.success();
    }


}