package zhwei.test.service;

import zhwei.test.domain.Grade;

import java.util.List;

/**
 * Ticket: GradeService
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/4/22 22:50
 */
public interface GradeService {
    List<Grade> list();

    int count();

    void save(Grade grade);

    void update(Grade grade);

    Grade get(int gradeid);

    void remove(int gradeid);
}
