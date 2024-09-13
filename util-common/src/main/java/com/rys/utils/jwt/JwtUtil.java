package com.rys.utils.jwt;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description
 * @Author lhy
 * @Date 2020/12/3
 * @Version 1.0.0
 */
@Slf4j
@AllArgsConstructor
@Component
public class JwtUtil {

    private JwtProperties jwtProperties;

    /**
     * 生成加密后的token
     *
     * @return 加密后的token
     */
    public String genToken(JSONObject jsonObject) {
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + 30L * 24L * 60L * 60L * 1000L);
            JWTCreator.Builder auth0 = JWT.create().withIssuer("auth0");
            for (String key : jsonObject.keySet()) {
                Object o = jsonObject.get(key);
                auth0.withClaim(key,o.toString());
            }
            token = auth0.withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    // mysecret是用来加密数字签名的密钥。
                    .sign(Algorithm.HMAC256(jwtProperties.getSecret()));
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return token;
    }

    /**
     * jwt解析token
     *
     * @param token
     * @return
     */
    public DecodedJWT deToken(String token) {
        DecodedJWT jwt;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(jwtProperties.getSecret().trim())).build();
            jwt = verifier.verify(token);
        } catch (JWTVerificationException e) {
            log.error("解析异常{}", e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            log.error("非法参数");
            return null;
        }
        return jwt;
    }

}
