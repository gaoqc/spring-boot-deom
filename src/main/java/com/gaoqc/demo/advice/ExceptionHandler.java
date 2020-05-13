package com.gaoqc.demo.advice;

import com.gaoqc.demo.web.controller.vo.ResponseVO;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseVO  runtimeEx(HttpServletRequest req, RuntimeException ex){
        ResponseVO ret= new ResponseVO();
        ret.setCode("10001");
        ret.setMsg("runtime ex");
        return ret;
    }
}
