package com.hyy.kcb.utils;

import java.io.Serializable;
import java.util.Map;

public class PageUtil implements Serializable {
    public PageUtil() {
    }

    //判断当前页和每页数是否为空,如果为空，都设置为默认值
    private static Map<String, Object> checkPageAndPerPageNum(Map<String, Object> str) {
        String pageNum = (String) str.get("pageNum");
        String numPerPage = (String) str.get("numPerPage");
        if (pageNum == null || pageNum.toString().trim().equals("")) {
            pageNum = "1";
        }
        //判断当前页是否是正整数
        if (!IsNumber.isInteger(pageNum.toString().trim())) {
            pageNum = "1";
        }
        if(Integer.valueOf(pageNum)<1){
            pageNum = "1";
        }
        if (numPerPage == null || numPerPage.toString().trim().equals("")) {
            numPerPage = "20";
        }
        //判断每页数是否是正整数
        if (!IsNumber.isInteger(numPerPage.toString().trim())) {
            numPerPage = "20";
        }
        if(Integer.valueOf(numPerPage)<1){
            numPerPage = "20";
        }
        str.put("pageNum",Integer.valueOf(pageNum));
        str.put("numPerPage",Integer.valueOf(numPerPage));
        return str;
    }

    //获取前端的当前页和每页数
    public static Map<String, Object> setPageAndPerPageNum(Map<String, Object> str) {
        Map<String, Object> stringStringMap = checkPageAndPerPageNum(str);
        Integer pageNum = (Integer) stringStringMap.get("pageNum");
        Integer numPerPage = (Integer) stringStringMap.get("numPerPage");
        pageNum = ((pageNum-1) * numPerPage);
        str.put("pageNum", pageNum);
        str.put("numPerPage", numPerPage);
        return str;
    }
}
