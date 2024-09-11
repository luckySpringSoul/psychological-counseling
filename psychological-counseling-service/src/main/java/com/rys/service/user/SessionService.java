package com.rys.service.user;

import com.rys.db.entity.Session;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rys.request.RequestPage;
import com.rys.request.SessionQueryReq;
import com.rys.response.PageInfoResponse;
import com.rys.response.user.SessionResp;
import com.rys.response.user.user.AddSessionRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author YourName
 * @since 2024-09-09
 */
public interface SessionService extends IService<Session> {

    /**
     * 保存会话记录
     */
    void addSession(AddSessionRequest addSessionRequest);

    /**
     * 获取会话记录
     */
    PageInfoResponse<SessionResp> listSession(SessionQueryReq requestPage, Integer roleType);
}
