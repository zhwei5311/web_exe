package top.zhwei.domain;

/**
 * Ticket: Product
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/10 20:17
 */
public class Product {
    private String pid;//商品编号
    private String pname;//商品名称
    private String pdesc; //商品描述
    private double price; //价格
    private int num;//商品数量

    public Product() {
    }

    public Product(String pid, String pname, String pdesc, double price, int num) {
        this.pid = pid;
        this.pname = pname;
        this.pdesc = pdesc;
        this.price = price;
        this.num = num;
    }

    public Product(String pid, String pname, String pdesc, double price) {
        this.pid = pid;
        this.pname = pname;
        this.pdesc = pdesc;
        this.price = price;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
