package top.zhwei.dao;

import top.zhwei.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Ticket: 用户操作的Dao
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/13 22:58
 */
public interface UserDao {
    List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int id);

    User findUserById(Integer id);

    void update(User user);

    int finTotalCount(Map<String, String[]> parameterMap);

    List<User> findByPage(int start, int rows, Map<String, String[]> parameterMap);
}
