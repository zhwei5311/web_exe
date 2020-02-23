package top.zhwei.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.zhwei.domain.User;
import top.zhwei.utils.JDBCUtils;

import java.util.List;

/**
 * Ticket: UserServiceImpl
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/23 21:35
 */
public class UserServiceImpl implements UserService {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findListByName(String name) {
        String sql = "select * from t_user where name like ?";
        List<User> userList = template.query(sql, new BeanPropertyRowMapper<>(User.class), "%" + name + "%");
        return userList;
    }
}
