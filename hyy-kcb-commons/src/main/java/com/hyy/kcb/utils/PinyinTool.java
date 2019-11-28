package com.hyy.kcb.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @Description:
 * @Auther: young
 * @Date: 2018/10/11 10:36
 */
public class PinyinTool {

    static final HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
    static {
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    }

    public enum Type {
        UPPERCASE, LOWERCASE, FIRSTUPPER
    }

    public static String toPinYinUpperCase(String str) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, "", Type.UPPERCASE);
    }

    public static String toPinYinLowerCase(String str) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, "", Type.LOWERCASE);
    }
    public static String toPinYinFirstUpper(String str) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, "", Type.FIRSTUPPER);
    }

    public static String toPinYinUpperCase(String str, String spera) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, spera, Type.UPPERCASE);
    }
    public static String toPinYinLowerCase(String str, String spera) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, spera, Type.LOWERCASE);
    }

    /**
     * 将str转换成拼音，如果不是汉字或者没有对应的拼音，则不作转换
     * 如： 明天 转换成 MINGTIAN
     * @param str：要转化的汉字
     * @param spera：转化结果的分割符
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public static String toPinYin(String str, String spera, Type type) throws BadHanyuPinyinOutputFormatCombination {
        if (str == null || str.trim().length() == 0) return "";
        if (type == Type.UPPERCASE) format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        else format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        String py = "";
        String temp = "";
        String[] t;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((int) c <= 128) py += c;
            else {
                t = PinyinHelper.toHanyuPinyinStringArray(c, format);
                if (t == null) py += c;
                else {
                    temp = t[0];
                    if (type == Type.FIRSTUPPER) temp = t[0].toUpperCase().charAt(0) + temp.substring(1);
                    py += temp + (i == str.length() - 1 ? "" : spera);
                }
            }
        }
        return py.trim();
    }
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
    	String s = toPinYinUpperCase("青白江-家珍公园");
    	System.out.println(s);
    	 s = toPinYinLowerCase("青白江-家珍公园");
    	System.out.println(s);
    	 s = toPinYinFirstUpper("青白江-家珍公园");
    	System.out.println(s);
    	 s = toPinYinUpperCase("青白江-家珍公园");
    	System.out.println(s);
    	 s = toPinYinLowerCase("青白江-家珍公园");
     	System.out.println(s);
	}

}
