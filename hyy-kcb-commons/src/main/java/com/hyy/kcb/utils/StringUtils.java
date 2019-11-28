package com.hyy.kcb.utils;

import java.util.Random;

public class StringUtils {
	
	protected static final int DEFALUT_RANDOM_LEN = 6;
	 //生成随机数字和字母,  
    public static String getRandomChar() {  
        String val = "";  
        Random random = new Random();        
        //length为几位密码 
        for(int i = 0; i < DEFALUT_RANDOM_LEN; i++) {          
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";  
            //输出字母还是数字  
            if( "char".equalsIgnoreCase(charOrNum) ) {  
                //输出是大写字母还是小写字母  
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;  
                val += (char)(random.nextInt(26) + temp);  
            } else if( "num".equalsIgnoreCase(charOrNum) ) {  
                val += String.valueOf(random.nextInt(10));  
            }  
        }  
        return val;  
    }  
    
    public static boolean isEmpty(String str) {
    	return (str == null || "".equals(str) || str.length() ==0 ||str.trim().length() == 0 );
    }
}
