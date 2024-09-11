package com.rys.utils.wechat.service;


import com.rys.entity.user.wechat.UserWCInfo;
import com.rys.entity.user.wechat.WChatAppletResDto;
import com.rys.request.user.login.wechat.LoginByWcAppletRequest;

public interface WebChatService {

    void binding(String code);

    UserWCInfo authorize(LoginByWcAppletRequest loginByWcAppletRequest);

    WChatAppletResDto swapSessionKey(String code);
}
