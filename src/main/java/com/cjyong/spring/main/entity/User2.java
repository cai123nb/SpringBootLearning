package com.cjyong.spring.main.entity;

public class User2 {
    private String name;

    private Integer age;

    public User2(String name, Integer age) {
        this.name = name;
        this.age = age;
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


    @Override
    public String toString() {
        return String.format("User[name='%s', age='%d' ]", name, age);
    }
}
