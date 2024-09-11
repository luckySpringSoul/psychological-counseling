package com.rys.service.user;

import com.rys.db.entity.Therapist;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rys.entity.Result;
import com.rys.request.RequestPage;
import com.rys.request.TherapistQueryReq;
import com.rys.request.admin.AddTherapistRequest;
import com.rys.request.user.PherapistQueryRequest;
import com.rys.response.PageInfoResponse;
import com.rys.response.user.login.AddUserRequest;
import com.rys.response.user.login.LoginRequest;
import com.rys.response.user.login.LoginResponse;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
public interface TherapistService extends IService<Therapist> {

    PageInfoResponse<Therapist> getMatchPherapist(PherapistQueryRequest pherapistQueryRequest);

    Result<LoginResponse> login(LoginRequest loginRequest);

    void addTherapist(AddTherapistRequest addTherapistRequest);

    void editTherapist(AddTherapistRequest addUserRequest);

    PageInfoResponse<Therapist> allTherapists(PherapistQueryRequest pherapistQueryRequest);
}
