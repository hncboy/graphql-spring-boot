package com.hncboy.graphql.entity;

import lombok.*;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/15
 * Time: 15:43
 * 书籍
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {

    private String bookTitle;
    private Integer authorId;
    private String publishedDate;
    private String publishingHouseName;
}
