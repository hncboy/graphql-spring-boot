package com.hncboy.graphql.entity;

import lombok.*;

import javax.persistence.Entity;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/15
 * Time: 16:26
 * 作者
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity {

    private String authorName;
    private Integer authorAge;
    private Integer authorSex;
}
