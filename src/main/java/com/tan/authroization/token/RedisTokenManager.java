package com.tan.authroization.token;

import com.tan.authroization.domain.User;
import com.tan.authroization.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by tanshijun-pc on 2017/8/20.
 */
@Component
public class RedisTokenManager implements TokenManager {

    @Autowired
    private RedisTemplate<String,UserVO> redisTemplate;

    @Override
    public String createToken(User user) {
        String token = UUID.randomUUID().toString().replaceAll("-","");
        //将user存储进redis
        UserVO userVo = new UserVO();
        userVo.setAge((short) 20);
        userVo.setSex((byte)0);
        userVo.setName(user.getName());
        System.out.println(userVo);
        //设置10分钟过期
        redisTemplate.boundValueOps(token).set(userVo,10, TimeUnit.MINUTES);
        String brcpSessionTicket = user.getId()+"#"+token;
        return encrypt(brcpSessionTicket);//返回加密后的数据
    }

    @Override
    public UserVO checkToken(String brcpSessionTicket) {
        if(StringUtils.isEmpty(brcpSessionTicket)){
            return null;
        }

        brcpSessionTicket = decrypt(brcpSessionTicket);//解密后的数据
        if(!brcpSessionTicket.contains("#")){
            return null;
        }

        String[] params = brcpSessionTicket.split("#");
        if(params.length != 2){
            return null;
        }
        String userId = params[0];
        String token = params[1];

        UserVO userVO = redisTemplate.boundValueOps(token).get();
        System.out.println("checkToken:"+userVO);
        redisTemplate.boundValueOps(token).expire(10,TimeUnit.MINUTES);//重新设置过期时间
        return userVO;
    }

    @Override
    public UserVO getUserVOByToken(String token) {
        return redisTemplate.boundValueOps(token).get();
    }

    /**
     * 解密
     * @param value
     * @return
     */
    private String decrypt(String value){
        return value;
    }

    /**
     * 加密
     * @param value
     * @return
     */
    private String encrypt(String value){
        return value;
    }
}
