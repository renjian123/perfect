package com.demo.dao;

import com.demo.common.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao
{
    List<Student> queryStudentList();

    Student queryStudentById(Integer id);
}
