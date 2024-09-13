package com.rys.utils.jwt;


/**
 * @Description
 * @Author lhy
 * @Date 2020/12/9
 * @Version 1.0.0
 */
public class AuthLocal {

    private static ThreadLocal<UserLocal> local =  new ThreadLocal<>();

    /**
     * 添加用户信息
     * @param userLocal
     */
    public static void setUser(UserLocal userLocal) {
        local.set(userLocal);
    }

    /**
     * 获取用户信息
     * @return
     */
    public static UserLocal getUser() {
        return local.get();
    }
}
