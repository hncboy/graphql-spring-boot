package com.hncboy.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hncboy.graphql.entity.Book;
import com.hncboy.graphql.entity.dto.BookDTO;
import com.hncboy.graphql.repository.AuthorRepository;
import com.hncboy.graphql.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/7/15
 * Time: 15:44
 */
@Component
@AllArgsConstructor
public class BookQueryResolver implements GraphQLQueryResolver {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final DozerBeanMapper dozerBeanMapper;

    public List<BookDTO> findAllBooks() {
        return booksToBookDTOs(bookRepository.findAll());
    }

    public BookDTO getBookByBookId(Integer bookId) {
        return bookToBookDTO(bookRepository.findBookById(bookId));
    }

    public List<BookDTO> findBooksByAuthorId(Integer authorId) {
        return booksToBookDTOs(bookRepository.findBooksByAuthorId(authorId));
    }

    /**
     * Book类型转BookDTO
     * @param book
     * @return
     */
    private BookDTO bookToBookDTO(Book book) {
        BookDTO bookDTO = dozerBeanMapper.map(bookRepository.save(book), BookDTO.class);
        bookDTO.setAuthor(authorRepository.findAuthorById(book.getAuthorId()));
        return bookDTO;
    }

    /**
     * Book类型集合转BookDTO类型结合
     * @param books
     * @return
     */
    private List<BookDTO> booksToBookDTOs(List<Book> books) {
        List<BookDTO> bookDTOS = new ArrayList<>();
        for (Book book : books) {
            bookDTOS.add(bookToBookDTO(book));
        }
        return bookDTOS;
    }
}
