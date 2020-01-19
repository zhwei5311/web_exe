package top.zhwei.test;

import org.junit.Test;
import top.zhwei.dao.UserDao;
import top.zhwei.domain.User;

public class UserDaoTest {
    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("白笑嫣");
        user.setPassword("111111");

        UserDao userDao = new UserDao();
        User loginUser = userDao.login(user);
        System.out.println(loginUser);
    }
}
