package com.itheima.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.dao.PageDao;
import com.itheima.dao.impl.PageDaoImpl;
import com.itheima.domain.Books;
import com.itheima.domain.PageBean;
import com.itheima.service.PageService;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Ticket: PageServiceImpl
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/12 22:35
 */
public class PageServiceImpl implements PageService {
    private PageDao pageDao = new PageDaoImpl();

    @Override
    public List<Books> findAll() {
        List<Books> booksList = pageDao.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String bookJson = null;
        try {
            bookJson = objectMapper.writeValueAsString(booksList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return pageDao.findAll();
    }

    @Override
    public PageBean<Books> findBooksByPage(String currentPages, String rowss, Map<String, String[]> parameterMap) {
        int currentPage = Integer.parseInt(currentPages);
        int rows = Integer.parseInt(rowss);
        if(currentPage <= 0) {
            currentPage = 1;
        }
        //创建空的PageBean对象
        PageBean<Books> pageBean = new PageBean<>();
        //设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //调用dao查询数据总记录数
        int totalCount = pageDao.findTotalCount(parameterMap);
        pageBean.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<Books> list = pageDao.findByPage(start,rows,parameterMap);
        pageBean.setList(list);
        //计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public void add(Books books) {
        pageDao.add(books);
    }

    @Override
    public void delete(String id) {
        pageDao.delete(Integer.parseInt(id));
    }

    @Override
    public void update(Books books) {
        pageDao.update(books);
    }

    @Override
    public Books findBookById(String id) {
        return pageDao.findBooksById(Integer.parseInt(id));
    }

    @Override
    public void delSelectedBook(String[] ids) {
        if(null != ids && ids.length > 0) {
            for (String id : ids) {
                pageDao.delete(Integer.parseInt(id));
            }
        }
    }
}
