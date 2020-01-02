package com.demo.common.bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class Student implements Serializable
{
    /** */
    private static final long serialVersionUID = 7430924314186022123L;

    private int id ;

    private String name;

    private int age;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

//    @Override
//    public String toString()
//    {
//        return JSON.toJSONString(this);
//    }
}
