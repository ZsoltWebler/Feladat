package org.webler.zsolt.repository;

import org.webler.zsolt.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookRepository implements IBookRepository {

    private final List<Book> bookDataSource;

    public BookRepository(List<Book> dataSource) {
        this.bookDataSource = dataSource;
    }

    @Override
    public boolean add(Book book) {
        if (!bookDataSource.stream().map(Book::getIsbn).collect(Collectors.toList()).contains(book.getIsbn())) {
            return bookDataSource.add(book);
        }
        return false;
    }

    @Override
    public boolean remove(Book book) {
        return bookDataSource.remove(book);
    }

    @Override
    public Optional<Book> findBookByIsbn(String isbn) {
        return bookDataSource.stream().filter(book -> book.getIsbn().equals(isbn)).findFirst();
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        return bookDataSource.stream().filter(book -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        return bookDataSource.stream().filter(book -> book.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<Book> findBookByGenre(String genre) {
        return bookDataSource.stream().filter(book -> book.getGenre().equals(genre)).collect(Collectors.toList());
    }

    @Override
    public List<Book> findBookByTittlePrefixMatch(String prefix) {
        return bookDataSource.stream().filter(book -> book.getTitle().startsWith(prefix)).collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllAvailableBooks() {
        return bookDataSource.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllUnAvailableBooks() {
        return bookDataSource.stream().filter(book -> !book.isAvailable()).collect(Collectors.toList());
    }


}
