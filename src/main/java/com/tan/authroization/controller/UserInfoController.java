package com.tan.authroization.controller;

import com.tan.authroization.annotation.Authroization;
import com.tan.authroization.annotation.CurrentUser;
import com.tan.authroization.vo.ResponseVO;
import com.tan.authroization.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanshijun-pc on 2017/8/23.
 */
@RestController
@Authroization
@RequestMapping("/user")
public class UserInfoController {

    @GetMapping("/get")
    public ResponseVO userInfo(@CurrentUser UserVO userVO){

        System.out.println("userInfoController:"+userVO);
        return ResponseVO.success(userVO);
    }
}
