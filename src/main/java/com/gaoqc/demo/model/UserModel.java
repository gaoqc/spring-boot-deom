package com.gaoqc.demo.model;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.ToString;

public class UserModel {
    private Integer id;
    @JsonView({UserView.class,UserNameAgeView.class})
    private String name;
    @JsonView({UserView.class,UserNameAgeView.class})
    private Integer age;
    public interface  UserView{};
    public  interface  UserNameAgeView{};


    @JsonView({UserView.class})
    private String sex;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



    @Override
    public String toString() {
      return JSONObject.toJSONString(this);
    }
}

