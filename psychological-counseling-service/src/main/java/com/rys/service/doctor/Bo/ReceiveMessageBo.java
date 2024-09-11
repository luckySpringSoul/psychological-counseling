package com.rys.service.doctor.Bo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tmo
 * @version 1.0.0
 * @ClassName ReceiveMessageBo.java
 * @Description 接受消息实体
 * @createTime 2024年09月07日 11:25:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReceiveMessageBo implements Serializable {

    private String formUserId;

    private String toUserId;

    private String msg;

}
