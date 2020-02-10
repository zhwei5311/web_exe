package top.zhwei.service;

import top.zhwei.dao.ProductDao;
import top.zhwei.domain.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Ticket: ProductService
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/10 23:04
 */
public class ProductService {
    public List<Category> finAllCategory() throws SQLException {
        ProductDao productDao = new ProductDao();
        return productDao.finAllCategory();
    }
}
