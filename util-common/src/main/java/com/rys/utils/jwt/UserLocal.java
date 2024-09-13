package com.rys.utils.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserLocal {

    /**
     * id
     */
    private String id;

    /**
     * phone
     */
    private String phone;


    /**
     * 名称
     */
    private String name;

    /**
     * type:1:用户 2:咨询师
     */
    private String type;

}


