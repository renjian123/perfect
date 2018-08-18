package com.demo.controller;

import com.demo.common.bean.Student;
import com.demo.common.param.Result;
import com.demo.common.param.ResultBuilder;
import com.demo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api( value = "StudentController", tags = "学生管理")
@RestController
@RequestMapping("student")
public class StudentController
{
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "查询学生")
    @GetMapping("queryStudentList")
    public Result<List<Student>> queryStudentList()
    {
        List<Student> studentList = studentService.queryStudentList();
        logger.debug("this is a good day");
        return ResultBuilder.aResult()
                .withData(studentList)
                .build();
    }
}
