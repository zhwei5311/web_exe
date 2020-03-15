package com.itheima.dao;

import com.itheima.domain.User;

/**
 * Ticket: UserDao
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/14 21:05
 */
public interface UserDao {
    User findByUsernameAndPassword(String username, String password);
}
