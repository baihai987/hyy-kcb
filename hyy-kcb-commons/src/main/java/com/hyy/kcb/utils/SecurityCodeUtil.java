package com.hyy.kcb.utils;

import java.io.Serializable;
import java.util.Random;

public class SecurityCodeUtil implements Serializable {

    public static String getSecurityCode(){
        return String.valueOf(new Random().nextInt(899999) + 100000);
    }
}
