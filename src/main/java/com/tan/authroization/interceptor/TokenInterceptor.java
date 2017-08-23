package com.tan.authroization.interceptor;

import com.tan.authroization.annotation.Authroization;
import com.tan.authroization.config.AuthroizationEnum;
import com.tan.authroization.token.TokenManager;
import com.tan.authroization.utils.ResponseUtil;
import com.tan.authroization.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by tanshijun-pc on 2017/8/20.
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

    private final static ThreadLocal<UserVO> userThreadLocal = new ThreadLocal<UserVO>();

    @Autowired
    private TokenManager tokenManager;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        Object controller = handlerMethod.getBean();
        System.out.println("==================TokenInterceptor"+ controller.getClass()+"====================");
        Class clazz = controller.getClass();
        if(clazz.getAnnotation(Authroization.class) == null){//不存在需要认证的注解，直接返回
            return true;
        }

        String brcpSessionTicket = null;
        //先从Cooike中获取
        Cookie[] cookieArray = request.getCookies();
        if(cookieArray != null){
            for(int i=0; i<cookieArray.length; i++){
                if("brcpSessionTicket".equals(cookieArray[i].getName())){
                    brcpSessionTicket = cookieArray[i].getValue();
                }
            }
        }

        if(StringUtils.isEmpty(brcpSessionTicket)){
            //从header中取出token
            brcpSessionTicket = request.getHeader("brcpSessionTicket");
        }

        if(StringUtils.isEmpty(brcpSessionTicket)){
            ResponseUtil.response(response, AuthroizationEnum.NOT_FIND_TOKEN);
            return false;
        }
        //校验token;
        UserVO userVO = tokenManager.checkToken(brcpSessionTicket);
        if(userVO == null){
            ResponseUtil.response(response,AuthroizationEnum.TIEM_OUT);
            return false;
        }
        userThreadLocal.set(userVO);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("===================afterCompletion==================");
        userThreadLocal.remove();
    }

    public static UserVO get(){
        return userThreadLocal.get();
    }
}
