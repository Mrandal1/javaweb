package com.randal.utils;

/**
 * @author Randal1
 * @version V1.0
 * @Package com.randal.utils
 * @data 2020/6/7 20:44
 */
public class MyFactory {
    private MyFactory() {
    }

    /**
     * 获取接口实例化
     *
     * @param classname 接口的子类
     * @param clazz     接口类型
     * @param <T>       指定接口类型
     * @return 如果子类存在，返回指定接口实例化对象
     */
    public static <T> T getInstance(String classname, Class<T> clazz) {
        T instance = null;
        try {
            instance = (T) Class.forName(classname).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }
}
