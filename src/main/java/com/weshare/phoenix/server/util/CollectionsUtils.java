package com.weshare.phoenix.server.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Collections去重工具类
 */
public class CollectionsUtils {

    public static String toSetString(Set<String> set){
        StringBuffer stringBuffer = new StringBuffer();
        for (String s:set){
            stringBuffer.append(s+",");
        }
        return stringBuffer.toString();
    }

    /**
     * List去重
     *
     * @param list list数组
     * @return list
     */
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }


    /**
     * int 数组求和
     *
     * @param arrays int数组
     * @return 数组和
     */
    public static int arraySum(int[] arrays) {
        int total = 0;
        for (int item : arrays) {
            total = total + item;
        }
        return total;
    }

}
