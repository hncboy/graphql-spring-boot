package com.hncboy.graphql.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hncboy.graphql.entity.Author;
import com.hncboy.graphql.entity.Book;
import com.hncboy.graphql.entity.dto.AuthorInputDTO;
import com.hncboy.graphql.entity.dto.BookDTO;
import com.hncboy.graphql.entity.dto.BookInputDTO;
import com.hncboy.graphql.repository.AuthorRepository;
import com.hncboy.graphql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/16
 * Time: 10:48
 */
@Component
@AllArgsConstructor
public class AuthorMutationResolver implements GraphQLMutationResolver {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final DozerBeanMapper dozerBeanMapper;

    public Author saveAuthor(AuthorInputDTO authorInputDTO) {
        authorInputDTO.setId(null);
        return authorRepository.save(dozerBeanMapper.map(authorInputDTO, Author.class));

    }

    public Author updateAuthor(AuthorInputDTO authorInputDTO) {
        return authorRepository.save(dozerBeanMapper.map(authorInputDTO, Author.class));
    }

    public boolean deleteAuthor(Integer authorId) {
        if (!authorRepository.existsById(authorId)) {
            return false;
        }
        authorRepository.deleteById(authorId);
        // 删除书籍中的作者id字段数据
        List<Book> books = bookRepository.findBooksByAuthorId(authorId);
        for (Book book : books) {
            book.setAuthorId(null);
            bookRepository.save(book);
        }
        return true;
    }
}
