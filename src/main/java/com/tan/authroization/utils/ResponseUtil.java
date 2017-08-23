package com.tan.authroization.utils;

import com.tan.authroization.config.AuthroizationEnum;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by tanshijun-pc on 2017/8/20.
 */
public class ResponseUtil {
    public static void response(HttpServletResponse response, AuthroizationEnum authroizationEnum){
        response.addHeader("uc_code",authroizationEnum.getCode());
        response.addHeader("uc_msg",authroizationEnum.getMsg());
    }
}
