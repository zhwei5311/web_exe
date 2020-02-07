package top.zhwei.util;

import javax.servlet.http.Cookie;

/**
 * Ticket: CookieUtils
 *
 * @author zhwei
 * @email zhwei1228@qq.com
 * @Date: 2020/2/7 22:18
 */
public class CookieUtils {
    public static Cookie getCookieByName(String name,Cookie[] cookies) {
        if(null == cookies || cookies.length == 0) {
            return null;
        } else {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
