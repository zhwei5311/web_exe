package top.zhwei.service.impl;

import top.zhwei.dao.UserDao;
import top.zhwei.dao.impl.UserDaoImpl;
import top.zhwei.domain.PageBean;
import top.zhwei.domain.User;
import top.zhwei.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * Ticket: UserServiceImpl
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/2/13 22:56
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User login(User user) {
        return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delSelectedUser(String[] uids) {
        if(null != uids && uids.length > 0) {
            //遍历数组
            for (String uid : uids) {
                userDao.delete(Integer.parseInt(uid));
            }
        }
    }

    @Override
    public PageBean<User> finUserByPage(String currentPages, String rowss, Map<String, String[]> parameterMap) {
        int currentPage = Integer.parseInt(currentPages);
        int rows = Integer.parseInt(rowss);
        if(currentPage <= 0) {
            currentPage = 1;
        }
        //1、创建空的PageBean对象
        PageBean<User> pageBean = new PageBean<>();
        //2、设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //3、调用dao查询总记录数
        int totalCount = userDao.finTotalCount(parameterMap);
        pageBean.setTotalCount(totalCount);
        //4、调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = userDao.findByPage(start,rows,parameterMap);
        pageBean.setList(list);
        //5、计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }
}
