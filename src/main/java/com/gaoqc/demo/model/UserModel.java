package com.gaoqc.demo.model;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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


    @Override
    public String toString() {
      return JSONObject.toJSONString(this);
    }
}

