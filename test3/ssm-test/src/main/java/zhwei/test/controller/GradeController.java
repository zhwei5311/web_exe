package zhwei.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zhwei.test.domain.Grade;
import zhwei.test.service.GradeService;

import java.util.List;

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

    @RequestMapping("/findAll.*")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Grade> gradeList = gradeService.list();
        //设置模型
        modelAndView.addObject("gradeList", gradeList);
        //设置视图
        modelAndView.setViewName("grade-list");
        System.err.println(gradeList);
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Grade grade){
        gradeService.save(grade);
        return "redirect:/grade/list";
    }
}
