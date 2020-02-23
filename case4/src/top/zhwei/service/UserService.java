package top.zhwei.service;

import top.zhwei.domain.User;

import java.util.List;

/**
 * Ticket: UserService
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/23 21:34
 */
public interface UserService {
    List<User> findListByName(String name);
}
