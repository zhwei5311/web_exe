package com.itheima.dao.impl;

import com.itheima.dao.PageDao;
import com.itheima.domain.Books;
import com.itheima.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Ticket: PageDaoImpl
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/3/12 22:22
 */
public class PageDaoImpl implements PageDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Books> findAll() {
        String sql = "select * from books";
        return template.query(sql,new BeanPropertyRowMapper<Books>(Books.class));
    }

    @Override
    public int findTotalCount(Map<String, String[]> parameterMap) {
        //1.定义模板初始化sql
        String sql = "select count(*) from books where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = parameterMap.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = parameterMap.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Books> findByPage(int start, int rows, Map<String, String[]> parameterMap) {
        String sql = "select * from books where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = parameterMap.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }

            //获取value
            String value = parameterMap.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }

        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params);

        return template.query(sql,new BeanPropertyRowMapper<>(Books.class),params.toArray());
    }

    @Override
    public Books findBooksById(Integer id) {
        String sql = "select * from books where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Books.class), id);
    }

    @Override
    public void add(Books books) {
        //1.定义sql
        String sql = "insert into books values(?,?,?,?,?)";
        //2.执行sql
        template.update(sql, books.getId(), books.getName(), books.getPrice(), books.getPnum(), books.getCategory());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from books where id = ?";
        template.update(sql,id);
    }

    @Override
    public void update(Books books) {
        String sql = "update books set id = ?,name = ? ,price = ? , pnum = ? , category = ? where id = ?";
        template.update(sql, books.getId(), books.getName(), books.getPrice(), books.getPnum(), books.getCategory(),books.getId());
    }
}
