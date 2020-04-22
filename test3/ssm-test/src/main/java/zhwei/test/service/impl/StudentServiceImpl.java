package zhwei.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhwei.test.domain.Grade;
import zhwei.test.domain.Student;
import zhwei.test.mapper.GradeMapper;
import zhwei.test.mapper.StudentMapper;
import zhwei.test.service.StudentService;

import java.util.List;
import java.util.Map;

/**
 * Ticket: StudentServiceImpl
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/4/13 23:32
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public Student get(int studentno) {
        return studentMapper.get(studentno);
    }

    @Override
    public List<Student> findAll(Map<String, Object> map) {
        List<Student> studentList = studentMapper.list(map);
        for (Student student : studentList) {
            Grade grade = gradeMapper.get(student.getGradeid());
            student.setGrade(grade);
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void remove(int studentno) {
        studentMapper.remove(studentno);
    }
}
