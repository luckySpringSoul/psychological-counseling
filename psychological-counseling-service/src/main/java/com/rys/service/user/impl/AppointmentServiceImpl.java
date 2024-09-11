package com.rys.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rys.db.entity.Appointment;
import com.rys.db.entity.Therapist;
import com.rys.db.entity.User;
import com.rys.db.mapper.AppointmentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rys.request.RequestPage;
import com.rys.request.ReserveQueryReq;
import com.rys.response.PageInfoResponse;
import com.rys.response.ReserveResp;
import com.rys.response.user.ReserveTherapistRequest;
import com.rys.service.user.AppointmentService;
import com.rys.service.user.TherapistService;
import com.rys.service.user.UserService;
import com.rys.utils.DateTimeUtils;
import com.rys.utils.jwt.AuthLocal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {

    @Autowired
    private UserService userService;

    @Override
    public void reserveTherapist(ReserveTherapistRequest request) {
        Appointment appointment = new Appointment();
        appointment.setTherapistId(request.getTherapistId());
        appointment.setUserId(Long.valueOf(AuthLocal.getUser().getId()));
        appointment.setReserveTime(request.getReserveTime());
        this.save(appointment);
    }

    @Override
    public List<ReserveResp> getReserveListByUserId(String userId) {
        List<Appointment> list = lambdaQuery().eq(Appointment::getUserId, userId).orderByDesc(Appointment::getId)
            .list();
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        List<Long> therapistIds = list.stream().map(Appointment::getTherapistId).collect(Collectors.toList());
        Map<Long, User> therapistMap = userService.listByIds(therapistIds).stream()
            .collect(Collectors.toMap(User::getId,
                Function.identity()));
        List<ReserveResp> reserveResps = new ArrayList<>();
        for (Appointment appointment : list) {
            ReserveResp reserveResp = new ReserveResp();
            reserveResp.setReserveId(appointment.getTherapistId());
            reserveResp.setReserveTime(appointment.getReserveTime());
            reserveResp.setUserId(appointment.getUserId().toString());
            reserveResp.setTherapistName(therapistMap.get(appointment.getTherapistId()).getName());
            reserveResps.add(reserveResp);

        }
        return reserveResps;
    }

    @Override
    public PageInfoResponse<ReserveResp> getReserveList(ReserveQueryReq reserveQueryReq, Integer roleType) {
        IPage<Appointment> page = new Page<>();
        page.setCurrent(reserveQueryReq.getPageCurrent());
        page.setSize(reserveQueryReq.getPageSize());
        if (roleType == 1) {
            reserveQueryReq.setUserId(Long.valueOf(AuthLocal.getUser().getId()));
        } else if (roleType == 2) {
            reserveQueryReq.setTherapistId(Long.valueOf(AuthLocal.getUser().getId()));
        }
        IPage<Appointment> therapistIPage = this.page(page,
            buildQueryWrapper(reserveQueryReq));

        List<Appointment> records = therapistIPage.getRecords();
        return buildResp(records, therapistIPage);
    }

    private PageInfoResponse<ReserveResp> buildResp(List<Appointment> records, IPage<Appointment> therapistIPage) {
        if (CollectionUtils.isEmpty(records)) {
            return new PageInfoResponse<>();
        }

        List<Long> therapistIds = records.stream().map(Appointment::getTherapistId).collect(Collectors.toList());
        Map<Long, User> therapistMap = userService.listByIds(therapistIds).stream()
            .collect(Collectors.toMap(User::getId,
                Function.identity()));
        List<ReserveResp> reserveResps = new ArrayList<>();
        for (
            Appointment appointment : records) {
            ReserveResp reserveResp = new ReserveResp();
            reserveResp.setReserveId(appointment.getTherapistId());
            reserveResp.setReserveTime(appointment.getReserveTime());
            reserveResp.setUserId(appointment.getUserId().toString());
            reserveResp.setTherapistName(
                Objects.nonNull(therapistMap.get(appointment.getTherapistId())) ? therapistMap.get(
                    appointment.getTherapistId()).getName() : "");
            reserveResps.add(reserveResp);
        }
        PageInfoResponse pageInfoResponse = new PageInfoResponse();
        pageInfoResponse.setCurrent(therapistIPage.getCurrent());
        pageInfoResponse.setRecords(reserveResps);
        pageInfoResponse.setTotal(therapistIPage.getTotal());
        pageInfoResponse.setPages(therapistIPage.getPages());
        return pageInfoResponse;
    }

    private LambdaQueryWrapper<Appointment> buildQueryWrapper(ReserveQueryReq reserveQueryReq) {
        LambdaQueryWrapper<Appointment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Objects.nonNull(reserveQueryReq.getTherapistId()), Appointment::getTherapistId,
            reserveQueryReq.getTherapistId());
        queryWrapper.eq(StringUtils.isNotBlank(reserveQueryReq.getReserveTime()), Appointment::getReserveTime,
            reserveQueryReq.getReserveTime());
        queryWrapper.orderByDesc(Appointment::getId);
        return queryWrapper;

    }

}
