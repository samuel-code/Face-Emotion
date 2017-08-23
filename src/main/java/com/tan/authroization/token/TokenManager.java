package com.tan.authroization.token;

import com.tan.authroization.domain.User;
import com.tan.authroization.vo.UserVO;

/**
 * Created by tanshijun-pc on 2017/8/20.
 */
public interface TokenManager {

    /**
     * 创建token
     * @param user
     * @return 返回创建的token
     */
    String createToken(User user);

    /**
     * 校验token是否有效
     * @param brcpSessionTicket
     * @return
     */
    UserVO checkToken(String brcpSessionTicket);

    /**
     * 根据Token获取User信息
     * @param token
     * @return
     */
    UserVO getUserVOByToken(String token);

}
