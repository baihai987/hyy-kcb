package com.hyy.kcb.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsNumber {
    public static boolean isInteger(String str) {
        try{
            Integer.valueOf(str);
            return true;
        }catch (NumberFormatException e ){
            return false;
        }
    }
    //判断字符串是否为Long
    public static boolean isLong(String str){
        try{
            Long.valueOf(str);
            return true;
        }catch (NumberFormatException e ){
            return false;
        }
    }
    //判断字符串是否为Double
    public static boolean isDouble(String str){
        try{
            Double.valueOf(str);
            return true;
        }catch (NumberFormatException e ){
            return false;
        }
    }
    //判断字符串是否为float
    public static boolean isFloat(String str){
        try{
            Float.valueOf(str);
            return true;
        }catch (NumberFormatException e ){
            return false;
        }
    }
    //判断字符串是否为Byte
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static boolean isByte(String str){
        try{
            Byte.valueOf(str);
            return true;
        }catch (NumberFormatException e ){
            return false;
        }
    }
    public static boolean isNumberYuan(String str){
        Pattern pattern=Pattern.compile("^(([1-9]\\d*)|([0]))(\\.(\\d){0,2})?$"); // 判断小数点后2位的数字的正则表达式
        Matcher match=pattern.matcher(str);
        if(!match.matches()){
            return false;
        }else{
            return true;
        }
    }
}
