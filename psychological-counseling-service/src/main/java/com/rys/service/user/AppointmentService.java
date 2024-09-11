package com.rys.service.user;

import com.rys.db.entity.Appointment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rys.request.RequestPage;
import com.rys.request.ReserveQueryReq;
import com.rys.response.PageInfoResponse;
import com.rys.response.ReserveResp;
import com.rys.response.user.ReserveTherapistRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
public interface AppointmentService extends IService<Appointment> {

    /**
     * 预约指导师
     */
    void reserveTherapist(ReserveTherapistRequest request);

    /**
     *
     */
    List<ReserveResp> getReserveListByUserId(String id);

    /**
     * 获取用户预约记录
     */
    PageInfoResponse<ReserveResp> getReserveList(ReserveQueryReq reserveQueryReq, Integer roleType);
}
