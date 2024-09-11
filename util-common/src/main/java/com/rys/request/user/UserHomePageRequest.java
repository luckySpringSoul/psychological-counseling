package com.rys.request.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserHomePageRequest implements Serializable {

    private Long userId;
}
