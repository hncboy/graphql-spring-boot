package com.hncboy.graphql.entity.dto;

import com.hncboy.graphql.entity.Author;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/16
 * Time: 8:43
 */
@Data
public class BookDTO {

    private Integer id;
    private String bookTitle;
    private String publishedDate;
    private String publishingHouseName;
    private Author author;
}
