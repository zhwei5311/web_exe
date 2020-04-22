package zhwei.test.service;

import zhwei.test.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * Ticket: StudentService
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/4/13 23:30
 */
public interface StudentService {

    Student get(int studentno);

    List<Student> findAll(Map<String, Object> map);

    void save(Student student);

    void update(Student student);

    void remove(int studentno);
}
