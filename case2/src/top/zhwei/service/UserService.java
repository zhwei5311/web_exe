package top.zhwei.service;

import top.zhwei.domain.PageBean;
import top.zhwei.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Ticket: 用户管理的业务接口
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/13 22:53
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();

    User login(User user);

    void add(User user);

    void delete(String id);

    User findUserById(String id);

    void update(User user);

    void delSelectedUser(String[] uids);

    PageBean<User> finUserByPage(String currentPage, String rows, Map<String, String[]> parameterMap);
}
