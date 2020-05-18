package com.gaoqc.demo.mybatis.mapper;

import com.gaoqc.demo.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends  BaseMapper{
    UserModel selectById(Integer id);
    void insertUser(UserModel user);
    void updateUser(UserModel user);
    void delUser(Integer id);
    @Select("select * from t_user t where t.name=#{name}")
    UserModel  selectByName(@Param("name") String name);


}
