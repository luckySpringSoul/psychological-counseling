package com.rys.service.user;

import com.rys.db.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rys.entity.Result;
import com.rys.request.RequestPage;
import com.rys.request.UserQueryReq;
import com.rys.response.PageInfoResponse;
import com.rys.response.UserResp;
import com.rys.response.user.login.AddUserRequest;
import com.rys.response.user.login.LoginRequest;
import com.rys.response.user.login.LoginResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
public interface UserService extends IService<User> {

    /**
     * 查询用户信息
     */
    Result<LoginResponse> getUserByPhone(LoginRequest loginRequest);

    /**
     * 新增用户
     */
    void addUser(AddUserRequest addUserRequest);

    /**
     * 编辑用户
     */
    void editUser(AddUserRequest addUserRequest);

    PageInfoResponse<UserResp> allUsers(UserQueryReq userQueryReq);
}
