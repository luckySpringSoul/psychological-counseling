package com.rys.service.user;

import com.rys.db.entity.Feedback;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rys.response.user.AddFeedBackRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author YourName
 * @since 2024-09-08
 */
public interface FeedbackService extends IService<Feedback> {

    /**
     * 提交反馈
     */
    void feedBack(AddFeedBackRequest addFeedBackRequest);
}
