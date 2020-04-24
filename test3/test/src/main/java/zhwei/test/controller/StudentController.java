package zhwei.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import zhwei.test.domain.Grade;
import zhwei.test.domain.Student;
import zhwei.test.service.GradeService;
import zhwei.test.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private GradeService gradeService;

    //查询所有学生信息列表
    @RequestMapping("/findAll.*/{gradeid}")
    public ModelAndView findAll(@PathVariable("gradeid") Integer gradeid) {

        Map<String,Object> params = new HashMap<>();
        if(-1 != gradeid) {
            params.put("gradeid",gradeid);
        }
        List<Student> studentList = studentService.findAll(params);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("student/student-list");
        return modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView = new ModelAndView();
        List<Grade> gradeList = gradeService.list();
        modelAndView.addObject("gradeList",gradeList);
        modelAndView.setViewName("student/student-save");
        return modelAndView;
    }

    //保存学生信息
    @RequestMapping("/save")
    public String save(Student student) {
        studentService.save(student);
        return "redirect:/student/findAll.action";
    }

    @GetMapping("/edit/{studentno}")
    public String edit(@PathVariable("studentno") Integer studentno, Model model) {
        Student student = studentService.get(studentno);
        model.addAttribute("student",student);
        List<Grade> gradeList = gradeService.list();
        model.addAttribute("gradeList",gradeList);
        return "student/student-edit";
    }

    //更新学生信息
    @RequestMapping("/update")
    public String update(Student student) {
        studentService.update(student);
        return "redirect:/student/findAll.action";
    }

    //删除学生
    @RequestMapping("/remove.*/{studentno}")
    public String remove(@PathVariable("studentno")Integer studentno) {
        studentService.remove(studentno);
        return "redirect:/student/findAll.action";
    }

    /**
     * 根據學生姓名進行查詢
     * @return
     */
    @RequestMapping("/findByUsername.*")
    public ModelAndView findByUsername(String username) {
        Map<String,Object> params = new HashMap<>();
        params.put("name",username);
        List<Student> studentList = studentService.findAll(params);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("student/student-list");
        return modelAndView;
    }
}
