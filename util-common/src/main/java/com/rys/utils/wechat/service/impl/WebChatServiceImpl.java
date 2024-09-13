package com.rys.utils.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rys.config.WebChatConfig;
import com.rys.entity.user.wechat.*;
import com.rys.request.user.login.wechat.LoginByWcAppletRequest;
import com.rys.utils.WxUtils;
import com.rys.utils.exception.BusinessException;
import com.rys.utils.wechat.service.WebChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.util.Base64;
import java.util.Objects;

@Service
@Slf4j
public class WebChatServiceImpl implements WebChatService {
    @Autowired
    private WebChatConfig webChatConfig;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public void binding(String code) {

    }

    @Override
    public UserWCInfo authorize(LoginByWcAppletRequest loginByWcAppletRequest) {
        try {
            WChatAppletResDto wChatAppletResDto = swapSessionKey( loginByWcAppletRequest.getCode() );
            log.info( "开始解析手机号" );
            String data = WxUtils.wxDecrypt(loginByWcAppletRequest.getData(), wChatAppletResDto.getSession_key(), loginByWcAppletRequest.getVi());
/*
            String data = decryptedData( loginByWcAppletRequest, wChatAppletResDto.getSession_key() );
*/
            log.info( "结束解析手机号,解析后的数据为{}", data );
            JSONObject jsonObject = JSON.parseObject( data );
            Object phoneNumberObj = jsonObject.get( "phoneNumber" );
            if (Objects.isNull( phoneNumberObj )) {
                throw new BusinessException( "请使用手机账号登录方式!" );
            }
            UserWCInfo userWcInfo = new UserWCInfo();
            String openid = wChatAppletResDto.getOpenid();
            userWcInfo.setMobilePhone( phoneNumberObj.toString() );
            userWcInfo.setUnionid( wChatAppletResDto.getUnionid() );
            userWcInfo.setToken( wChatAppletResDto.getSession_key() );
            userWcInfo.setOpenid( openid );
            return userWcInfo;
        } catch (Exception e) {
            log.info( "小程序登录失败", e );
            throw new BusinessException( "请使用手机号登录" );
        }
    }

    @Override
    public WChatAppletResDto swapSessionKey(String code) {
        WChatAppletReqDto wChatAppletReqDto = new WChatAppletReqDto();
        wChatAppletReqDto.setAppid( webChatConfig.getAppId() );
        wChatAppletReqDto.setSecret( webChatConfig.getSecret() );
        wChatAppletReqDto.setJs_code( code );
        String url = webChatConfig.getSessionKeyUrl() + "?" + String.join(
                "&",
                "appid=" + wChatAppletReqDto.getAppid(),
                "secret=" + wChatAppletReqDto.getSecret(),
                "js_code=" + wChatAppletReqDto.getJs_code(),
                "grant_type=" + wChatAppletReqDto.getGrant_type()
        );
        ResponseEntity<WChatAppletResDto> wChatResDtoResponseEntity = restTemplate.getForEntity( url, WChatAppletResDto.class, wChatAppletReqDto );
        log.info( "微信授权信息" + wChatResDtoResponseEntity );
        WChatAppletResDto wChatAppletResDto = wChatResDtoResponseEntity.getBody();
        if (Objects.isNull( wChatAppletResDto )) {
            throw new BusinessException( "请选择手机登录方式" );
        }
        if (0 != wChatAppletResDto.getErrcode()) {
            throw new BusinessException( "服务器繁忙，请稍再试" );
        }
        return wChatAppletResDto;
    }

    public static String decryptedData(LoginByWcAppletRequest addUserByWxDto, String sessionKey) throws Exception {
        byte[] encryptedDataBy = Base64.getDecoder().decode( addUserByWxDto.getData() );
        byte[] viBy = Base64.getDecoder().decode( addUserByWxDto.getVi() );
        byte[] sessionKeyBy = Base64.getDecoder().decode( sessionKey );
        Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS7Padding" );
        Key sKeySpec = new SecretKeySpec( sessionKeyBy, "AES" );
        cipher.init( Cipher.DECRYPT_MODE, sKeySpec, generateIV( viBy ) );
        byte[] result = cipher.doFinal( encryptedDataBy );
        return new String( result );
    }

    private static AlgorithmParameters generateIV(byte[] iv) throws Exception {
        AlgorithmParameters params = AlgorithmParameters.getInstance( "AES" );
        params.init( new IvParameterSpec( iv ) );
        return params;
    }
}
