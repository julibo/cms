package com.julibo.pig.cms.controller;

import com.julibo.pig.cms.domain.Result;
import com.julibo.pig.cms.domain.ResultCode;
import lombok.extern.log4j.Log4j2;

/**
 * @author carson
 * @date 2019-11-28
 */
@Log4j2
public abstract class BaseController {

    protected Result ok(int code, String msg, Object data) {
        Result vo = new Result();
        vo.setCode(code);
        vo.setData(data);
        vo.setMsg(msg);
        return vo;
    }

    protected Result ok() {
        return ok(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), null);
    }

    protected Result ok(Object obj) {
        return ok(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), obj);
    }

    protected Result fail(ResultCode rc) {
        return ok(rc.getCode(), rc.getMsg(), null);
    }

    protected Result fail(String msg) {
        return ok(ResultCode.ERROR.getCode(), msg, null);
    }
}
