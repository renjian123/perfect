package com.demo.controller;

import com.demo.common.bean.Student;
import com.demo.common.param.Result;
import com.demo.common.param.ResultBuilder;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("xxx")
public class TestController
{
    @ApiOperation(value = "查询学生")
    @GetMapping("student/queryStudentList")
    public Result<List<Student>> queryStudentList()
    {
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
        list.add("cccc");
        return ResultBuilder.aResult()
                .withData(list)
                .build();
    }
}
