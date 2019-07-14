package com.ncu.task1.bean;

import org.springframework.util.DigestUtils;

/**
 * MD5验证
 * @author 周佳玲
 * @date 2019-07-13 23:02
 */

public class MD5 {
    public static String md5(String key,String text){
        String encodeStr = DigestUtils.md5DigestAsHex((key+text).getBytes());
        return encodeStr;
    }

    public static boolean vertify(String text,String key,String md5){
        String md5Test = md5(key,text);
        if (md5Test.equalsIgnoreCase(md5)){
            System.out.println("验证通过");
            return true;
        }
        else{
            return false;
        }
    }

}
