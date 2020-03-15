package com.itheima.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Ticket: Books
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/12 22:15
 */
public class Books implements Serializable {

    private String id;

    private String name;

    private Double price;

    private Integer pnum;

    private String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pnum=" + pnum +
                ", category='" + category + '\'' +
                '}';
    }
}
