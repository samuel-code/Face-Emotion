package com.tan.authroization.resolver;

import com.tan.authroization.annotation.CurrentUser;
import com.tan.authroization.interceptor.TokenInterceptor;
import com.tan.authroization.token.TokenManager;
import com.tan.authroization.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 *  增加方法注入，将含有 CurrentUser 注解的方法注入UserVO对象
 * Created by tanshijun-pc on 2017/8/20.
 */
@Component
public class UserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private TokenManager tokenManager;
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {

        boolean result = false;
        System.out.println(methodParameter.getParameterType());
       if(methodParameter.getParameterType().isAssignableFrom(UserVO.class) && methodParameter.hasParameterAnnotation(CurrentUser.class)){
           result =  true;
       }
        return result;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
       System.out.println("resolver:"+TokenInterceptor.get());
        return TokenInterceptor.get();
    }
}
