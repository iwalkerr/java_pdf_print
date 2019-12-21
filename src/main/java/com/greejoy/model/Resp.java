package com.greejoy.model;

public class Resp {
    public int code;
    public String msg;
    public Object data;

    public Resp(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Resp(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Resp() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
