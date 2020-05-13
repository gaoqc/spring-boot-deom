package com.gaoqc.demo.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.gaoqc.demo.model.UserModel;
import com.gaoqc.demo.mybatis.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    UserMapper userMapper;
    @GetMapping("/{id}")
    @JsonView(UserModel.UserNameAgeView.class)
    public Object get(@Positive(message = "must be positive") @PathVariable("id")Integer id){

        logger.debug("id:{}",id);
        UserModel user= userMapper.selectById(id );
        if(null!=user){
            logger.info("user:{}",user);
        }
        return user;
    }
    @PostMapping("")
    public Object addUser(UserModel user){
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
    @PutMapping("/")
    public Object updateUSer(UserModel userModel){
        userMapper.updateUser(userModel);
        return "success";
    }




}
