package com.my.sa.core.exception.handle;

import java.io.Serializable;

public class ExceptionData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 异常编码
     */
    private Integer code;

    /**
     * 后台异常描述，正常不应该把后台异常描述反馈给前台用户
     */
    private String message;

    public ExceptionData() {
    }

    public ExceptionData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
