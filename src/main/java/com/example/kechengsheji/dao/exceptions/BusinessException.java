package com.example.kechengsheji.dao.exceptions;
import com.example.kechengsheji.dao.enums.XKHResponseCodeEnum;

/**
* @Description:    后台异常类
* @Author:          longhua.wang
* @CreateDate:     2019/4/6 1:21
* @UpdateUser:     longhua.wang
* @UpdateDate:     2019/4/6 1:21
*/
public class BusinessException extends RuntimeException{
    private String code;

    private String msg;

    public BusinessException(XKHResponseCodeEnum xKHResponseCodeEnum) {
        super(xKHResponseCodeEnum.getChineseMessage());
        this.msg = xKHResponseCodeEnum.getMsg();
        this.code = xKHResponseCodeEnum.getCode();
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
