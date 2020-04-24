package zhwei.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhwei.test.domain.Grade;
import zhwei.test.domain.Student;
import zhwei.test.mapper.GradeMapper;
import zhwei.test.mapper.StudentMapper;
import zhwei.test.service.GradeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ticket: GradeServiceImpl
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/4/22 22:52
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Grade> list() {
        List<Grade> gradeList = gradeMapper.list();
        for (Grade grade : gradeList) {
            Integer gradeid = grade.getGradeid();
            Map<String, Object> params = new HashMap<>();
            params.put("gradeid", gradeid);
            List<Student> studentList = studentMapper.list(params);
            grade.setStudentList(studentList);
        }
        return gradeList;
    }

    @Override
    public int count() {
        return gradeMapper.count();
    }

    @Override
    public void save(Grade grade) {
        gradeMapper.save(grade);
    }

    @Override
    public void update(Grade grade) {
        gradeMapper.update(grade);
    }

    @Override
    public Grade get(int gradeid) {
        return gradeMapper.get(gradeid);
    }

    @Override
    public void remove(int gradeid) {
        gradeMapper.remove(gradeid);
    }
}
