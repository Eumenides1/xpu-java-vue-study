package com.rookie.stack.mybatis.entity;

import java.util.Date;

/**
 * @author eumenides
 * @description
 * @date 2024/6/17
 */
public class Student {

    private String id;

    private String name;

    private Integer age;

    private Date birthday;

    private Major major;

    // getter setter equals hashcode toString


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", major=" + major +
                '}';
    }
}