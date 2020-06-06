package com.randal.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.utils
 * @data 2020/6/6 16:52
 */
public class WebUtils {
    public static <T>T copyParamToBean(Map map, T bean) {
        try {
            BeanUtils.populate(bean, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }


}
