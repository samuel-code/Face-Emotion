package com.tan.authroization.repository;

import com.tan.authroization.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tanshijun-pc on 2017/8/20.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    /**
     * 通过用户名和密码
     * @param name
     * @param password
     * @return
     */
    User findByNameAndPassword(String name, String password);
}
