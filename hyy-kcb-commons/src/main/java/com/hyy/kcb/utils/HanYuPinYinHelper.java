package com.hyy.kcb.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.Serializable;

public class HanYuPinYinHelper implements Serializable {
    public static String ToPinyin(String chinese){
        StringBuilder pinyinStr = new StringBuilder();
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char c : newChar) {
            if (c > 128) {
                try {
                    pinyinStr.append(PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat)[0]);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinStr.append(c);
            }
        }
        return pinyinStr.toString();
    }
    public static void main(String[] args) {
//    	String s = getFirstSpell("青白江-家珍公园");
//    	s = ToPinyin(s);
//    	System.out.println(s);
//    	 s = "青白江-家珍公园";
//    	System.out.println(s.indexOf("-")+1);
////    	s = s.substring(s.indexOf("\\-"));
//    	System.out.println(s.substring(s.indexOf("-")+1));
	}
    
    
}
