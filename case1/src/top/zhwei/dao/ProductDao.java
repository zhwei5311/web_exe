package top.zhwei.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import top.zhwei.domain.Category;
import top.zhwei.util.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

/**
 * Ticket: ProductDao
 *Data Access Object
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/10 23:04
 */
public class ProductDao {
    public List<Category> finAllCategory() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from category";
        return queryRunner.query(sql,new BeanListHandler<>(Category.class));
    }
}
