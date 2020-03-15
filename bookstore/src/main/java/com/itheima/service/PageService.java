package com.itheima.service;

import com.itheima.domain.Books;
import com.itheima.domain.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Ticket: PageService
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/12 22:34
 */
public interface PageService {

    List<Books> findAll();

    PageBean<Books> findBooksByPage(String currentPages, String rowss, Map<String, String[]> parameterMap);

    void add(Books books);

    void delete(String id);

    void update(Books books);

    Books findBookById(String id);

    void delSelectedBook(String[] ids);
}
