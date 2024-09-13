package com.rys.constants.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Arrays;
import java.util.Objects;
import lombok.Getter;

/**
 * 最小核销单位枚举
 *
 * @author tianchao@tinman.cn
 * @date 2023/01/28
 **/
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CommonTypesEnum {
    /**
     * 阅读
     */
    HEALTH("HEALTH", "健康"),
    HEART("HEART", "心理"),
    BOREDOM("BOREDOM", "烦闷");

    private final String code;
    private final String desc;

    CommonTypesEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static CommonTypesEnum getEnumByCode(Integer code) {
        return Arrays.stream(CommonTypesEnum.values()).filter(p -> Objects.equals(p.getCode(), code)).findFirst()
            .orElse(null);
    }

}
