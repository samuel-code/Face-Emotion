package com.tan.authroization.controller;

import com.tan.authroization.annotation.Authroization;
import com.tan.authroization.domain.User;
import com.tan.authroization.form.LoginForm;
import com.tan.authroization.repository.UserRepository;
import com.tan.authroization.token.TokenManager;
import com.tan.authroization.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tanshijun-pc on 2017/8/20.
 */
@RestController
public class AuthroizationController {

    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public ResponseVO login(LoginForm loginForm, HttpServletResponse response){
        System.out.println("loginController : "+loginForm);
        User user = userRepository.findByNameAndPassword(loginForm.getUserName(),loginForm.getPassword());
        if(user == null){
            return ResponseVO.error("000001","用户名或者密码错误");
        }
        //登录成功 创建token;
        String brcpSessionTicket = tokenManager.createToken(user);
        Cookie cookie = new Cookie("brcpSessionTicket",brcpSessionTicket);
        response.addCookie(cookie);
        return ResponseVO.success(user);
    }
}
