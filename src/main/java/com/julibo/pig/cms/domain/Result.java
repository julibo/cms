package com.julibo.pig.cms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author carson
 * @date 2019-11-28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "返回实体")
public class Result<T> {

    @ApiParam(name = "响应码")
    private Integer code;

    @ApiParam(name = "消息内容")
    private String msg;

    @ApiParam(name = "消息实体")
    private T data;


}
