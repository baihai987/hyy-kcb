package com.hyy.kcb.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsPhoneNumUtil {
    public static boolean  isPhoneNum(String phoneNum){
        boolean flag = false;
        Matcher m = null;
        // 验证手机号
        Pattern p;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
        m = p.matcher(phoneNum.trim());
        flag = m.matches();
        return flag;
    }
}
