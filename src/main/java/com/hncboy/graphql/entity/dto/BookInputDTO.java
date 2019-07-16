package com.hncboy.graphql.entity.dto;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/16
 * Time: 11:04
 */
@Data
public class BookInputDTO {

    private Integer id;
    private String bookTitle;
    private String publishedDate;
    private String publishingHouseName;
    private Integer authorId;
}
