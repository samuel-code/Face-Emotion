package com.tan.authroization;

import redis.clients.jedis.Jedis;

/**
 * Created by tanshijun-pc on 2017/8/23.
 */
public class JedisTest {

    public static void main(String[] args){
        Jedis jedis = new Jedis("172.22.51.2",6379);
        System.out.println(jedis.info());
    }
}
