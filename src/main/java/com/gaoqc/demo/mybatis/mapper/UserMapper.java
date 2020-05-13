package com.gaoqc.demo.mybatis.mapper;

import com.gaoqc.demo.model.UserModel;

public interface UserMapper extends  BaseMapper{
    UserModel selectById(Integer id);
    void insertUser(UserModel user);
    void updateUser(UserModel user);
    void delUser(Integer id);


}
