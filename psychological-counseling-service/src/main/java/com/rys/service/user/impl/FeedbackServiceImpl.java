package com.rys.service.user.impl;

import com.rys.db.entity.Feedback;
import com.rys.db.mapper.FeedbackMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rys.response.user.AddFeedBackRequest;
import com.rys.service.user.FeedbackService;
import com.rys.utils.jwt.AuthLocal;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    @Override
    public void feedBack(AddFeedBackRequest addFeedBackRequest) {
        Feedback feedback = new Feedback();
        feedback.setUserId(Long.valueOf(AuthLocal.getUser().getId()));
        feedback.setTherapistId(addFeedBackRequest.getTherapistId());
        feedback.setAppointmentId(addFeedBackRequest.getAppointmentId());
        this.save(feedback);
    }
}
