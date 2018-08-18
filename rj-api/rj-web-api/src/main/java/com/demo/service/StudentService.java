package com.demo.service;

import com.demo.common.bean.Student;
import com.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentDao studentDao;

    public List<Student> queryStudentList()
    {
        return studentDao.queryStudentList();
    }
}
