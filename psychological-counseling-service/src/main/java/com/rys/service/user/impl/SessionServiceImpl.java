package com.rys.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rys.db.entity.Session;
import com.rys.db.entity.Therapist;
import com.rys.db.entity.User;
import com.rys.db.mapper.SessionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rys.request.RequestPage;
import com.rys.request.SessionQueryReq;
import com.rys.response.PageInfoResponse;
import com.rys.response.user.SessionResp;
import com.rys.response.user.user.AddSessionRequest;
import com.rys.service.user.SessionService;
import com.rys.service.user.TherapistService;
import com.rys.service.user.UserService;
import com.rys.utils.DateTimeUtils;
import com.rys.utils.jwt.AuthLocal;
import java.time.ZoneOffset;
import java.util.Date;
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
 * @since 2024-09-09
 */
@Service
public class SessionServiceImpl extends ServiceImpl<SessionMapper, Session> implements SessionService {

    @Autowired
    private UserService userService;
    @Autowired
    private TherapistService therapistService;

    @Override
    public void addSession(AddSessionRequest addSessionRequest) {
        Session session = new Session();
        session.setUserId(Long.valueOf(AuthLocal.getUser().getId()));
        session.setTherapistId(addSessionRequest.getTherapistId());
        this.save(session);
    }

    @Override
    public PageInfoResponse<SessionResp> listSession(SessionQueryReq sessionQueryReq, Integer roleType) {
        IPage<Session> page = new Page<>();
        page.setSize(sessionQueryReq.getPageSize());
        page.setCurrent(sessionQueryReq.getPageCurrent());

        if (roleType == 1) {
            sessionQueryReq.setUserId(Long.valueOf(AuthLocal.getUser().getId()));
        } else if (roleType == 2) {
            sessionQueryReq.setTherapistId(Long.valueOf(AuthLocal.getUser().getId()));
        }
        IPage<Session> resultPage = this.page(page, buildQueryWrapper(sessionQueryReq));
        List<Session> records = resultPage.getRecords();
        if (CollectionUtils.isEmpty(records)) {
            return new PageInfoResponse<>();
        }

        List<Long> userIds = records.stream().map(Session::getUserId).collect(Collectors.toList());
        List<Long> therapiIds = records.stream().map(Session::getTherapistId).collect(Collectors.toList());

        Map<Long, User> userMap = userService.listByIds(userIds).stream()
            .collect(Collectors.toMap(User::getId, Function.identity()));

        Map<Long, User> therapistMap = userService.listByIds(therapiIds).stream()
            .collect(Collectors.toMap(User::getId, Function.identity()));
        List<SessionResp> resps = records.stream().map(e -> {
            SessionResp sessionResp = new SessionResp();
            sessionResp.setSessionTime(
                DateTimeUtils.getDateTimeToString(
                    Date.from(e.getCreateTime().atZone(ZoneOffset.ofHours(8)).toInstant()),
                    DateTimeUtils.DATE_FORMAT_YYYY_MM_DD));
            sessionResp.setUserId(e.getUserId());
            sessionResp.setTherapistId(e.getTherapistId());
            sessionResp.setUserName(
                Objects.nonNull(userMap.get(e.getUserId())) ? userMap.get(e.getUserId()).getName() : "");
            sessionResp.setTherapistName(
                Objects.nonNull(therapistMap.get(e.getTherapistId())) ? therapistMap.get(e.getTherapistId()).getName()
                    : "");
            sessionResp.setPhone(
                Objects.nonNull(userMap.get(e.getUserId())) ? userMap.get(e.getUserId()).getPhone() : "");
            return sessionResp;
        }).collect(Collectors.toList());

        PageInfoResponse<SessionResp> resp = new PageInfoResponse<>();
        resp.setRecords(resps);
        resp.setTotal(resultPage.getTotal());
        resp.setPages(resultPage.getPages());
        resp.setCurrent(resultPage.getCurrent());
        return resp;
    }


    private LambdaQueryWrapper<Session> buildQueryWrapper(SessionQueryReq sessionQueryReq) {
        LambdaQueryWrapper<Session> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Objects.nonNull(sessionQueryReq.getTherapistId()), Session::getTherapistId,
            sessionQueryReq.getTherapistId());
        queryWrapper.eq(Objects.nonNull(sessionQueryReq.getUserId()), Session::getUserId, sessionQueryReq.getUserId());

        queryWrapper.orderByDesc(Session::getId);
        return queryWrapper;
    }
}
