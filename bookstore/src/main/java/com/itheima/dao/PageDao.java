package com.itheima.dao;

import com.itheima.domain.Books;

import java.util.List;
import java.util.Map;

/**
 * Ticket: PageDao
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/12 22:20
 */
public interface PageDao {
    public List<Books> findAll();

    int findTotalCount(Map<String, String[]> parameterMap);

    List<Books> findByPage(int start, int rows, Map<String, String[]> parameterMap);

    void add(Books books);

    void delete(int id);

    Books findBooksById(Integer id);

    void update(Books books);
}
