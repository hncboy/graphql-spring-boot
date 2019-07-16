package com.hncboy.graphql.repository;

import com.hncboy.graphql.entity.Author;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/15
 * Time: 16:31
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @NotNull
    List<Author> findAll();

    Author findAuthorById(Integer id);
}
