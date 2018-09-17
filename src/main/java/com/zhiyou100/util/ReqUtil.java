package com.zhiyou100.util;


import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;

public class ReqUtil {

    public static <T> T reqUtil(HttpServletRequest req, Class<T> clazz) throws
            IllegalAccessException, InstantiationException {
        Field[] fields = clazz.getDeclaredFields();
        T t = clazz.newInstance();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            if (StringUtils.isBlank(req.getParameter(fields[i].getName()))) {
                continue;
            } else {
                Object convertedValue = ConvertUtils.convert(req.getParameter(fields[i].getName()), fields[i].getType());
                fields[i].set(t, convertedValue);
            }
        }
        return t;
    }
}
