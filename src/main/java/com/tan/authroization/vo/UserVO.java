package com.tan.authroization.vo;

import java.io.Serializable;

/**
 * Created by tanshijun-pc on 2017/8/20.
 */
public class UserVO implements Serializable {

    private String name;

    private short age;

    private byte sex;

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

}
