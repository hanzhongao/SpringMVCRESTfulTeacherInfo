package com.hza.dao;

import com.hza.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by hza
 * 2019-10-09 17:50
 */
@Repository
public class TeacherDao {

    private Map<Integer, Teacher> teachers = new HashMap<>() ;

    /**
     * 添加老师
     * @param teacher
     */
    public void add(Teacher teacher) {
        this.teachers.put(teacher.getId(), teacher) ;
    }

    /**
     * 查询全部教师信息
     * @return
     */
    public Collection<Teacher> getAll() {
        return this.teachers.values() ;
    }

    /**
     * 根据ID查询教师信息
     * @param id
     * @return
     */
    public Teacher getById(Integer id) {
        return this.teachers.get(id) ;
    }

    /**
     * 编辑教师信息
     * @param teacher
     */
    public void update(Teacher teacher) {
        this.teachers.put(teacher.getId(), teacher) ;
    }

    /**
     * 删除教师信息
     * @param id
     */
    public void delete(Integer id) {
        this.teachers.remove(id) ;
    }
}
