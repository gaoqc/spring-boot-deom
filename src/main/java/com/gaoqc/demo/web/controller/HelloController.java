package com.gaoqc.demo.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController {


    /**
     *
     * @param name
     * @param hello
     * @return
     */
    @GetMapping("hello/index.do")
    public Object index(@RequestParam(value = "name",required = false)String name,@RequestParam(value = " hello",required = false,defaultValue = "10")Integer  hello){
        return "hello:"+name+String.valueOf(  hello);

    }
}
