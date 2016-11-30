package com.my.sa.core.exception;

import java.io.Serializable;

public class ExceptionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 异常编码
     */
    private Integer code;

    /**
     * 异常描述占位符替代内容列表
     */
    private Object[] args;

    /**
     * 后台异常描述，正常不应该把后台异常描述反馈给前台用户
     */
    private String message;

    /**
     * 异常堆栈信息
     */
    private String detail;

    public ExceptionInfo() {

    }

    public ExceptionInfo(Integer code, Object[] args) {
        this.code = code;
        this.args = args;
    }

    
    public ExceptionInfo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public ExceptionInfo(Integer code, Object[] args, String message) {
        this.code = code;
        this.args = args;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 异常信息配置文件中异常描述中占位符的替代数据
     */
    public Object[] getArgs() {
        return args;
    }

    /**
     * 异常信息配置文件中异常描述中占位符的替代数据
     */
    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
