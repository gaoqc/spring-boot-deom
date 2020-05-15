package com.gaoqc.demo.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gaoqc.demo.config.AppConfig;
import com.gaoqc.demo.model.UserModel;
import com.gaoqc.demo.mybatis.mapper.UserMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
@Slf4j
public class UserController {
    @Resource
    UserMapper userMapper;
    @Resource
    AppConfig appConfig;

    private  interface  UserGetView extends UserModel.UserNameAgeView, AppConfig.AppConfigView{}
    @GetMapping("/{id}")
    @JsonView({UserGetView.class})
    public Object get(@Positive(message = "must be positive") @PathVariable("id")Integer id){

        log.debug("id:{}",id);
        UserModel user= userMapper.selectById(id );
        if(null!=user){
            log.info("user:{}",user);
        }
//        Map<String,Object> map=new HashMap<String,Object>();
        Map<String,Object> map=new HashMap<>();
        map.put("user",user);
        map.put("appInfo",appConfig);
        return map;
//        throw  new RuntimeException("aaaa");
    }
    @PostMapping("/add")
    public Object addUser(UserModel user){
        float  i= 1/0;
        if(null!=user){
            userMapper.insertUser(user);
        }
        return "SUCCESS";
    }
    @DeleteMapping("/{id}")
    public Object delUser(@PathVariable("id") Integer id){
        userMapper.delUser(id);
        return  "success";
    }
    @PutMapping("/update")
    @JsonView(UserModel.UserView.class)
    public Object updateUSer(UserModel userModel){
        userMapper.updateUser(userModel);

        return UserModel.builder().age(100).name("gaoqc").sex("F").build();
    }




}
