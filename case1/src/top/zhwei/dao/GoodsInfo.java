package top.zhwei.dao;

import top.zhwei.domain.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Ticket: GoodsInfo
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/10 20:22
 */
public class GoodsInfo {
    private static Map<String, Product> map = new HashMap<>();

    static {
        Product p1=new Product("p001","雷柏机械键盘","雷柏的机械键盘是目前市面上性价比最好的键盘,好用",199);
        Product p2=new Product("p002","联想笔记本电脑","雷柏的机械键盘是目前市面上性价比最好的键盘,好用",7999);
        Product p3=new Product("p003","小米6手机","雷柏的机械键盘是目前市面上性价比最好的键盘,好用",1999);
        Product p4=new Product("p004","华为荣耀8手机","雷柏的机械键盘是目前市面上性价比最好的键盘,好用",2001);
        Product p5=new Product("p005","小米手环","雷柏的机械键盘是目前市面上性价比最好的键盘,好用",149);
        map.put("p001", p1);
        map.put("p002", p2);
        map.put("p003", p3);
        map.put("p004", p4);
        map.put("p005", p5);
    }

    public static Product getProductById(String pid) {
        return map.get(pid);
    }
}
