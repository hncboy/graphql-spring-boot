package com.hncboy.graphql.repository;

import com.hncboy.graphql.entity.Book;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/15
 * Time: 16:31
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

    @NotNull
    List<Book> findAll();

    Book findBookById(Integer id);

    List<Book> findBooksByAuthorId(Integer authorId);
}
