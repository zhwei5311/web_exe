package zhwei.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zhwei.test.domain.Student;
import zhwei.test.service.StudentService;

import java.util.List;

/**
 * Ticket: StudentController
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/4/13 23:35
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAll.*")
    public ModelAndView findAll() {
        List<Student> studentList = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("student-list");
        return modelAndView;
    }

    //保存
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Student student) {
        studentService.save(student);
        return "保存成功";
    }

    @RequestMapping("/update")
    @ResponseBody
    public void update(Student student) {
        studentService.update(student);
    }

    @RequestMapping("/remove.action/{studentno}")
    public String remove(@PathVariable("studentno")int studentno) {
        studentService.remove(studentno);
        return "redirect:/student/student-list";
    }

    /**
     * 查询学生姓名
     * @return
     */
    @RequestMapping("/findByUsername.action")
    public List<Student> findByUsername() {
        return null;
    }
}
