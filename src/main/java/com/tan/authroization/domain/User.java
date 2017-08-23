package com.tan.authroization.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tanshijun-pc on 2017/8/20.
 */
@Entity
@Table(name="t_jj_user")
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_username")
    private String name;

    @Column(name = "user_password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
