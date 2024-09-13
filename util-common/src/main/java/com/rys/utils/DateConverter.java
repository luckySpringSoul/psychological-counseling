package com.rys.utils;


import java.text.ParseException;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 日期格式转换
 * @author tianchao
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (StringUtils.isNumeric(source)) {
            return new Date(Long.valueOf(source));
        }
        try {
            return DateUtils.parseDate(source, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            throw new IllegalArgumentException("日期格式错误,正确格式【yyyy-MM-dd HH:mm:ss】");
        }
    }
}
