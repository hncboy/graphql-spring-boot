package com.hncboy.graphql.entity.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/16
 * Time: 11:05
 */
@Data
public class AuthorInputDTO {

    private Integer id;
    private String authorName;
    private Integer authorAge;
    private Integer authorSex;
}
