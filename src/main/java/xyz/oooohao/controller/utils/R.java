package xyz.oooohao.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;

    public R() {}

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    //封装出现异常时的错误信息
    public R(String msg) {
        this.flag = false;
        this.msg = msg;
    }
}
