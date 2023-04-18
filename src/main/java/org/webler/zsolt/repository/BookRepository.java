package org.webler.zsolt.repository;

import org.webler.zsolt.model.Book;

import java.util.List;
import java.util.Optional;

public class BookRepository implements IBookRepository {

    private final List<Book> bookDataSource;

    public BookRepository(List<Book> dataSource) {
        this.bookDataSource = dataSource;
    }


    @Override
    public Optional<Book> findBookByIsbn(String isbn) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Book> findBookByAuthor(String author) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Book> findBookByGenre(String genre) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Book> findBookByTittlePrefixMatch(String prefix) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Book> findAllAvailableBooks() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Book> findAllUnAvailableBooks() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Book book) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Book book) {
        throw new UnsupportedOperationException();
    }
}
