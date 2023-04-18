package org.webler.zsolt.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class BookRepositoryTest {

    BookRepository bookRepository;

    @BeforeEach
    void init() {
        bookRepository = new BookRepository(Collections.emptyList());
    }

    @Test
    void addTest() {
    }

    @Test
    void removeTest() {
    }

    @Test
    void findBookByIsbnTest() {
    }

    @Test
    void findBookByAuthorTest() {
    }

    @Test
    void findBookByTitleTest() {
    }

    @Test
    void findBookByGenreTest() {
    }

    @Test
    void findBookByTittlePrefixMatchTest() {
    }

    @Test
    void findAllAvailableBooksTest() {
    }

    @Test
    void findAllUnAvailableBooksTest() {
    }
}
