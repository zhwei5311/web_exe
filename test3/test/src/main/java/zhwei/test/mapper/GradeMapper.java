package zhwei.test.mapper;

import zhwei.test.domain.Grade;

import java.util.List;

/**
 * Ticket:
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/4/14 23:13
 */
public interface GradeMapper {

    List<Grade> list();

    int count();

    void save(Grade grade);

    void update(Grade grade);

    Grade get(int gradeid);

    void remove(int gradeid);
}
