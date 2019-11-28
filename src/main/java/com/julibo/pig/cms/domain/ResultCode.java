package com.julibo.pig.cms.domain;

import java.util.Arrays;

/**
 * 返回码
 * @author carson
 * @date 2019-11-28
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 系统错误
     */
    ERROR(110, "系统错误"),

    /**
     * 缺少必要的参数
     */
    MISS_PARAM(111, "缺少必要的参数"),

    /**
     * 参数校验有误
     */
    VALID_ERROR(112, "参数校验有误");

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;


    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public static String getMsgByCode(int code) {
        return Arrays.stream(ResultCode.values())
                .filter(ResultCode -> ResultCode.getCode() == code)
                .map(ResultCode -> ResultCode.getMsg())
                .findFirst()
                .get();

    }
}
