package com.hncboy.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hncboy.graphql.entity.Author;
import com.hncboy.graphql.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/16
 * Time: 8:30
 */
@Component
@AllArgsConstructor
public class AuthorQueryResolver implements GraphQLQueryResolver {

    private final AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorByAuthorId(int authorId) {
        return authorRepository.findById(authorId).orElse(null);
    }
}
