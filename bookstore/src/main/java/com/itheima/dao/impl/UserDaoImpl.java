package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Ticket: UserDaoImpl
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/14 21:05
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    User user = null;
    @Override
    public User findByUsernameAndPassword(String username, String password) {
        try {
            //1.定义sql
            String sql = "select * from user where username = ? and password = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
        } catch (Exception e) {

        }

        return user;
    }
}
