package org.webler.zsolt.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.webler.zsolt.exceptions.NotFound;
import org.webler.zsolt.model.Book;
import org.webler.zsolt.model.Patron;
import org.webler.zsolt.repository.BookRepository;
import org.webler.zsolt.repository.PatronRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibrarianServiceTest {

    LibrarianService librarianService;
    List<Patron> patrons;
    List<Book> books;

    @BeforeEach
    void init() {

        List<Book> testBooks = Arrays.asList(
                new Book("testIsbn", "testTitle", "testAuthor", "testGenre", true),
                new Book("testIsbn2", "testTitle2", "testAuthor2", "testGenre2", false),
                new Book("testIsbn3", "testTitle3", "testAuthor3", "testGenre3", true),
                new Book("testIsbn4", "testTitle4", "testAuthor4", "testGenre4", false)
        );
        books = new ArrayList<>(testBooks);


        Book book = new Book("testIsbn", "testTitle", "testAuthor", "testGenre", true);
        Book otherBook = new Book("testIsbn2", "testTitle2", "testAuthor2", "testGenre2", false);

        List<Patron> testPatrons = Arrays.asList(

                new Patron("Patron_1", "patron_1@lib.com", 11L, new ArrayList<>(Arrays.asList(book))),
                new Patron("Patron_2", "patron_2@lib.com", 12L, new ArrayList<>(Arrays.asList(book, otherBook))),
                new Patron("Patron_3", "patron_3@lib.com", 13L, new ArrayList<>()),
                new Patron("Patron_4", "patron_4@lib.com", 14L, new ArrayList<>(Arrays.asList(otherBook)))
        );
        patrons = new ArrayList<>(testPatrons);


        librarianService = new LibrarianService(
                new PatronRepository(patrons),
                new BookRepository(books)
        );
    }

    @Test
    void addBookTest() {
        Book testUniqueBook = new Book("testIsbn5", "testTitle5", "testAuthor5", "testGenre5", false);
        Book testNotUniqueBook = new Book("testIsbn5", "testTitle5", "testAuthor5", "testGenre5", false);
        boolean uniqueBookWasAdded = librarianService.addBook(testUniqueBook);
        boolean notUniqueBookWasAdded = librarianService.addBook(testNotUniqueBook);

        assertTrue(uniqueBookWasAdded);
        assertFalse(notUniqueBookWasAdded);

        assertTrue(books.contains(testUniqueBook));
    }

    @Test
    void removeBookTest() {
        Book testBookContained = new Book("testIsbn4", "testTitle4", "testAuthor4", "testGenre4", false);
        Book testBookNotContained = new Book("testIsbn5", "testTitle5", "testAuthor5", "testGenre5", false);

        assertTrue(books.contains(testBookContained));

        boolean containedBookWasRemoved = librarianService.removeBook(testBookContained);
        boolean notContainedBookWasRemoved = librarianService.removeBook(testBookNotContained);


        assertTrue(containedBookWasRemoved);
        assertFalse(notContainedBookWasRemoved);

        assertFalse(books.contains(testBookContained));


    }

    @Test
    void addPatronTest() {
        Patron testUniquePatron = new Patron("Patron_3", "patron_3@lib.com", 15L, new ArrayList<>());
        Patron testNotUniquePatron = new Patron("Patron_4", "patron_4@lib.com", 14L, new ArrayList<>(Arrays.asList()));
        boolean uniquePatronWasAdded = librarianService.addPatron(testUniquePatron);
        boolean notUniquePatronWasAdded = librarianService.addPatron(testNotUniquePatron);

        assertTrue(uniquePatronWasAdded);
        assertFalse(notUniquePatronWasAdded);

        assertTrue(patrons.contains(testUniquePatron));

    }

    @Test
    void removePatronTest() {
        Patron testContainedPatron = new Patron("Patron_3", "patron_3@lib.com", 13L, new ArrayList<>());
        Patron testNotContainedPatron = new Patron("Patron_5", "patron_5@lib.com", 15L, new ArrayList<>(Arrays.asList()));

        assertTrue(patrons.contains(testContainedPatron));

        boolean containedPatronWasRemoved = librarianService.removePatron(testContainedPatron);
        boolean notContainedPatronWasRemoved = librarianService.removePatron(testNotContainedPatron);

        assertTrue(containedPatronWasRemoved);
        assertFalse(notContainedPatronWasRemoved);

        assertFalse(patrons.contains(testContainedPatron));

    }

    @Test
    void printBookInformationTest() {

    }

    @Test
    void printPatronInformationTest() {
    }

    @Test
    void borrowBookTest() {
        Book book = new Book("testIsbn123", "testTitle", "testAuthor", "testGenre", true);
        Book otherBook = new Book("testIsbn321", "testTitle", "testAuthor", "testGenre", true);
        Book unavailableBook = new Book("testIsbn321", "testTitle", "testAuthor", "testGenre", false);
        Patron patron = new Patron("Patron_1", "patron_1@lib.com", 11L, new ArrayList<>(Arrays.asList(book)));

        try {
            assertTrue(patron.getBorrowedBooks().size() == 1);
            librarianService.borrowBook(patron,otherBook);
            assertTrue(patron.getBorrowedBooks().size() == 2);

            librarianService.borrowBook(patron,unavailableBook);
            fail();
        } catch (NotFound e) {
            assertTrue(true);
        }

    }

    @Test
    void returnBookTest() {
        Book book = new Book("testIsbn123", "testTitle", "testAuthor", "testGenre", true);
        Book otherBook = new Book("testIsbn321", "testTitle", "testAuthor", "testGenre", true);
        Book unavailableBook = new Book("testIsbn321", "testTitle", "testAuthor", "testGenre", false);
        Patron patron = new Patron("Patron_1", "patron_1@lib.com", 11L, new ArrayList<>(Arrays.asList(book, otherBook)));

        try {
            assertTrue(patron.getBorrowedBooks().size() == 2);
            librarianService.returnBook(patron,otherBook);
            assertTrue(patron.getBorrowedBooks().size() == 1);

            librarianService.returnBook(patron,unavailableBook);
            fail();
        } catch (NotFound e) {
            assertTrue(true);
        }
    }


}
