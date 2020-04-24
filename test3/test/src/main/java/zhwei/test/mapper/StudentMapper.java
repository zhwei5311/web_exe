package zhwei.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zhwei.test.domain.Student;

import java.util.List;
import java.util.Map;

/**
 * Ticket: StudentMapper
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/4/13 23:23
 */
@Repository
@Mapper
public interface StudentMapper {

    List<Student> list(Map<String, Object> map);

    int count();

    void save(Student student);

    void update(Student student);

    Student get(int studentno);

    void remove(int studentno);
}
