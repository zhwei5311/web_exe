package top.zhwei.domain;

import java.io.Serializable;

/**
 * Ticket: Category
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/10 22:10
 */
public class Category implements Serializable {
    private int cid;
    private String cname;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
