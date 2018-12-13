package com.ifenqu.webapi.consumer.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
public class User {
    private Integer userId;

    @NotNull
    @Size(min = 3, max = 12)
    private String name;

    @Pattern(regexp = "^.+@.+\\.\\w+$")
    private String email;

    @Pattern(regexp = "\\d{11}")
    private String mobile;

}
