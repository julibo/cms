package com.julibo.pig.cms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author carson
 * @date 2019-11-28
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "分页实体")
public class Pagination<T> {

    @ApiParam(name = "每页多少条")
    private int pageSize;

    @ApiParam(name = "当前页")
    private int pageNo;

    @ApiParam(name = "总数")
    private long total;

    @ApiParam(name = "数据实体")
    private List<T> elements;
}
