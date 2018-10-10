package org.anson.mis.util.datatype;

/**
 * String 工具类
 */
public class StringUtil {

    /**
     * 判断字符串是否为空串/空值, 是 则返回 true, 否 则返回 fase
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str == null || str.trim().equals("")){
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为空串/空值, 是则返回 false, 否则返回 true
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !StringUtil.isEmpty(str);
    }
}
