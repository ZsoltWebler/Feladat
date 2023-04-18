package org.webler.zsolt.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.webler.zsolt.repository.BookRepository;
import org.webler.zsolt.repository.PatronRepository;

import java.util.Collections;

public class LibrarianServiceTest {

    LibrarianService librarianService;

    @BeforeEach
    void init() {
        librarianService = new LibrarianService(
                new PatronRepository(Collections.emptyList()),
                new BookRepository(Collections.emptyList())
        );
    }

    @Test
    void addBookTest() {
    }

    @Test
    void removeBookTest() {
    }

    @Test
    void addPatronTest() {
    }

    @Test
    void removePatronTest() {
    }

    @Test
    void printBookInformationTest() {
    }

    @Test
    void printPatronInformationTest() {
    }

    @Test
    void borrowBookTest() {
    }

    @Test
    void returnBookTest() {
    }


}
