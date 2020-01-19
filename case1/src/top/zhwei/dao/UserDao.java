package top.zhwei.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.zhwei.domain.User;
import top.zhwei.util.JDBCUtils;

/**
 * 操作数据表中User表的类
 */
public class UserDao {
    //声明JdbcTemplate对象共用
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录
     *
     * @param:user用户名和密码
     * @return:user 没有查询到，返回null
     */
    public User login(User user) {
        try {
            String sql = "select * from t_user where username = ? and password = ?";
            User user1 = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),
                    user.getUsername(), user.getPassword());
            return user1;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
