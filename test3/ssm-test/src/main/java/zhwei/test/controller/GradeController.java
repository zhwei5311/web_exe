package zhwei.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zhwei.test.domain.Grade;
import zhwei.test.domain.Student;
import zhwei.test.service.GradeService;
import zhwei.test.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Ticket: GradeController
 *
 * @author zhwei
 * @email zhaowei@boranet.com.cn
 * @Date: 2020/4/22 22:56
 */
@RequestMapping("/grade")
@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/findAll.*")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Grade> gradeList = gradeService.list();
        //设置模型
        modelAndView.addObject("gradeList", gradeList);
        //设置视图
        modelAndView.setViewName("grade/grade-list");
        System.err.println(gradeList);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Grade grade) {
        gradeService.save(grade);
        return "redirect:/grade/findAll.action";
    }

    //更新学生信息
    @RequestMapping("/update")
    @ResponseBody
    public void update(Grade grade) {
        gradeService.update(grade);
    }

    //删除学生
    @RequestMapping("/delete.*/{gradeid}")
    public String remove(@PathVariable("gradeid") Integer gradeid) {
        Map<String, Object> params = new HashMap<>();
        params.put("gradeid", gradeid);
        List<Student> studentList = studentService.findAll(params);
        if (0 == studentList.size()) {
            gradeService.remove(gradeid);
        }
        return "redirect:/grade/findAll.action";
    }
}
