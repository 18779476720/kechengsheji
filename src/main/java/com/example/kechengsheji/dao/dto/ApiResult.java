package com.example.kechengsheji.dao.dto;

import com.example.kechengsheji.dao.enums.XKHResponseCodeEnum;
import com.example.kechengsheji.dao.exceptions.BusinessException;

import java.io.Serializable;

/**
* @Description:    统一封装返回接口值
* @Author:          longhua.wang
* @CreateDate:     2019/4/5 23:37
* @UpdateUser:     longhua.wang
* @UpdateDate:     2019/4/5 23:37
*/
public class ApiResult<T> implements Serializable {

    /**
     * 返回code
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T datas;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public static <T> ApiResult<T> build(String code, String msg) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(code);
        apiResult.setMessage(msg);
        return apiResult;
    }

    public static <T> ApiResult<T> build(String code, String msg, T datas) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(code);
        apiResult.setMessage(msg);
        apiResult.setDatas(datas);
        return apiResult;
    }

    public static <T> ApiResult<T> build(XKHResponseCodeEnum xkhResponseCodeEnum) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(xkhResponseCodeEnum.getCode());
        apiResult.setMessage(xkhResponseCodeEnum.getChineseMessage());
        return apiResult;
    }

    public static <T> ApiResult<T> buildSuccess(T datas) {
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setCode(XKHResponseCodeEnum.SUCCESS.getCode());
        apiResult.setMessage(XKHResponseCodeEnum.SUCCESS.getChineseMessage());
        apiResult.setDatas(datas);
        return apiResult;
    }

    public ApiResult(String code, String message, T datas) {
        this.code = code;
        this.message = message;
        this.datas = datas;
    }

    public static <T> T successDatas(ApiResult<T> apiResult) {
        if (apiResult == null) {
            throw new BusinessException(XKHResponseCodeEnum.PARAM_IS_NULL);
        }
        if (XKHResponseCodeEnum.SUCCESS.getCode().equals(apiResult.getCode())) {
            return apiResult.getDatas();
        }
        throw new BusinessException(apiResult.getCode(), apiResult.getMessage());
    }
    public ApiResult() {
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", datas=" + datas +
                '}';
    }
}
