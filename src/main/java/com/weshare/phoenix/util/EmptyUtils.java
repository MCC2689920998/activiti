package com.weshare.phoenix.util;

import java.util.Collection;

/**
 * 判空工具类
 */
public class EmptyUtils {

    private EmptyUtils() {
    }

    /**
     * 判断字符串是否为空，长度为0被认为是空字符串.
     *
     * @param str 字符串
     * @return bool标识
     */
    public static boolean isEmpty(String str) {
        if (null != str) {
            return str.trim().length() == 0;
        } else {
            return true;
        }
    }

    /**
     * 判断字符串是否为空，字符串前后空白被截断，截断后长度为0被认为是空字符串
     *
     * @param str      字符串
     * @param isTrimed 是否去掉前后空格
     * @return bool标识
     */
    public static boolean isEmpty(String str, boolean isTrimed) {
        if (isTrimed) {
            return null == str || str.trim().length() == 0;
        } else {
            return null == str || str.length() == 0;
        }
    }

    /**
     * 判断列表是否为空，列表没有元素也被认为是空
     *
     * @param
     * @return bool标识
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * 判断数组是否为空
     *
     * @param array 数组
     * @return bool标识
     */
    public static boolean isEmpty(Object[] array) {
        return null == array || array.length == 0;
    }

    /**
     * 判断对象是否为空
     *
     * @param obj 对象
     * @return bool标识
     */
    public static boolean isEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }

}