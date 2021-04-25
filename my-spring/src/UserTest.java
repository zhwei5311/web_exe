import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zhwei.UserService;

/**
 * @author zhaowei33346
 * @description TODO
 * @date 2021/4/25 21:34
 */
public class UserTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.save();
    }
}
