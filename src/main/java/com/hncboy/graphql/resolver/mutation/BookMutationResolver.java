package com.hncboy.graphql.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hncboy.graphql.entity.Book;
import com.hncboy.graphql.entity.dto.BookDTO;
import com.hncboy.graphql.entity.dto.BookInputDTO;
import com.hncboy.graphql.repository.AuthorRepository;
import com.hncboy.graphql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/16
 * Time: 10:47
 */
@Component
@AllArgsConstructor
public class BookMutationResolver implements GraphQLMutationResolver {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final DozerBeanMapper dozerBeanMapper;

    public BookDTO saveBook(BookInputDTO bookInputDTO) {
        bookInputDTO.setId(null);
        return bookInputDTOToBookDTO(bookInputDTO);
    }

    public BookDTO updateBook(BookInputDTO bookInputDTO) {
        return bookInputDTOToBookDTO(bookInputDTO);
    }

    public boolean deleteBook(Integer bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }

    /**
     * BookInputDTO类型转BookDTO
     * @param bookInputDTO
     * @return
     */
    private BookDTO bookInputDTOToBookDTO(BookInputDTO bookInputDTO) {
        Book book = bookRepository.save(dozerBeanMapper.map(bookInputDTO, Book.class));
        BookDTO bookDTO = dozerBeanMapper.map(book, BookDTO.class);
        bookDTO.setAuthor(authorRepository.findAuthorById(book.getAuthorId()));
        return bookDTO;
    }
}
