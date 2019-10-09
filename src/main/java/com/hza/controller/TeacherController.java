package com.hza.controller;

import com.hza.dao.TeacherDao;
import com.hza.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Create by hza
 * 2019-10-09 17:55
 */
@Controller
public class TeacherController {

    @Autowired
    private TeacherDao teacherDao ;

    /**
     * 跳转到添加页面
     * @param teacher
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd(Teacher teacher) {
        return "add" ;
    }

    /**
     * 添加教师
     * @param teacher
     * @return
     */
    @PostMapping(value = "/add")
    public String add(Teacher teacher) {
        this.teacherDao.add(teacher);
        return "redirect:/getAll" ;
    }

    /**
     * 查找全部教师信息
     * @return
     */
    @GetMapping(value = "/getAll")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.addObject("teachers", this.teacherDao.getAll()) ;
        modelAndView.setViewName("show");
        return modelAndView ;
    }

    /**
     * 根据id查找要修改的教师
     * @param id
     * @return
     */
    @GetMapping(value = "/toEdit/{id}")
    public ModelAndView toEdit(@PathVariable(value = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView() ;
        modelAndView.addObject("teacher",this.teacherDao.getById(id)) ;
        modelAndView.setViewName("edit");
        return modelAndView ;
    }

    /**
     * 编辑教师信息
     * @param teacher
     * @return
     */
    @PutMapping(value = "/edit")
    public String edit(Teacher teacher) {
        this.teacherDao.update(teacher);
        return "redirect:/getAll" ;
    }

    /**
     * 删除教师信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        this.teacherDao.delete(id);
        return "redirect:/getAll" ;
    }
}
