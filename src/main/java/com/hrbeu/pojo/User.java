package com.hrbeu.pojo;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/3/9 10:43
 * @Created by nxt
 */
public class User implements Serializable{
    private String name;
    private Integer age;

    public User() {
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

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
