package xyz.oooohao.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为SpringMVC的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //这个方法会拦截Controller抛出的所有异常
    @ExceptionHandler
    public R doException(Exception e) {
        e.printStackTrace();
        return new R("服务器出现异常，请稍后再试");
    }
}
