package com.ifenqu.webapi.consumer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 图书
 */
@ApiModel("图书信息")
@Data
@Accessors(chain = true)
public class Book {
    /**
     * 书名
     */
    @ApiModelProperty("图书名")
    @NotNull
    private String name;

    /**
     * ISBN号
     */
    @NotNull
    @Size(min = 5, max = 10)
    private String isbn;

    /**
     * 出版日期
     */
    private Date publishDate;

    public String getName() {
        return name;
    }


}
