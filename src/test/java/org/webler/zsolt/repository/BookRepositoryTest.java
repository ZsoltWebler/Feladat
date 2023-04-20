package org.webler.zsolt.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.webler.zsolt.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookRepositoryTest {

    BookRepository bookRepository;
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
        bookRepository = new BookRepository(books);
    }

    @Test
    void addTest() {
        Book testUniqueBook = new Book("testIsbn5", "testTitle5", "testAuthor5", "testGenre5", false);
        Book testNotUniqueBook = new Book("testIsbn5", "testTitle5", "testAuthor5", "testGenre5", false);
        boolean uniqueBookWasAdded = bookRepository.add(testUniqueBook);
        boolean notUniqueBookWasAdded = bookRepository.add(testNotUniqueBook);

        assertTrue(uniqueBookWasAdded);
        assertFalse(notUniqueBookWasAdded);

        assertTrue(books.contains(testUniqueBook));

    }

    @Test
    void removeTest() {

        Book testBookContained = new Book("testIsbn4", "testTitle4", "testAuthor4", "testGenre4", false);
        Book testBookNotContained = new Book("testIsbn5", "testTitle5", "testAuthor5", "testGenre5", false);

        assertTrue(books.contains(testBookContained));

        boolean containedBookWasRemoved = bookRepository.remove(testBookContained);
        boolean notContainedBookWasRemoved = bookRepository.remove(testBookNotContained);


        assertTrue(containedBookWasRemoved);
        assertFalse(notContainedBookWasRemoved);

        assertFalse(books.contains(testBookContained));
    }

    @Test
    void findBookByIsbnTest() {
        Book testBookContained = new Book("testIsbn4", "testTitle4", "testAuthor4", "testGenre4", false);
        Book testBookNotContained = new Book("testIsbn5", "testTitle5", "testAuthor5", "testGenre5", false);

        assertEquals(testBookContained,bookRepository.findBookByIsbn(testBookContained.getIsbn()).get());
        assertFalse(bookRepository.findBookByIsbn(testBookNotContained.getIsbn()).isPresent());

    }

    @Test
    void findBookByAuthorTest() {
        Book testBookContained = new Book("testIsbn5", "testTitle4", "testAuthor4", "testGenre4", false);
        List<Book> testAuthor4 = bookRepository.findBookByAuthor("testAuthor4");
        assertTrue(testAuthor4.size() == 1);

        books.add(testBookContained);
        assertTrue(bookRepository.findBookByAuthor("testAuthor4").size() == 2);
    }

    @Test
    void findBookByTitleTest() {
        Book testBookContained = new Book("testIsbn5", "testTitle4", "testAuthor4", "testGenre4", false);
        List<Book> testAuthor4 = bookRepository.findBookByTitle("testTitle4");
        assertTrue(testAuthor4.size() == 1);

        books.add(testBookContained);
        assertTrue(bookRepository.findBookByTitle("testTitle4").size() == 2);
    }

    @Test
    void findBookByGenreTest() {
        Book testBookContained = new Book("testIsbn5", "testTitle4", "testAuthor4", "testGenre4", false);
        List<Book> testAuthor4 = bookRepository.findBookByGenre("testGenre4");
        assertTrue(testAuthor4.size() == 1);

        books.add(testBookContained);
        assertTrue(bookRepository.findBookByGenre("testGenre4").size() == 2);
    }

    @Test
    void findBookByTittlePrefixMatchTest() {
        Book testBookContained = new Book("testIsbn5", "testTitle4", "testAuthor4", "testGenre4", false);
        List<Book> testAuthor4 = bookRepository.findBookByTittlePrefixMatch("testTitle");
        assertTrue(testAuthor4.size() == books.size());

        books.add(testBookContained);
        assertTrue(bookRepository.findBookByTittlePrefixMatch("testTitle").size() == books.size());
    }

    @Test
    void findAllAvailableBooksTest() {
        Book testBookContained = new Book("testIsbn5", "testTitle4", "testAuthor4", "testGenre4", true);
        List<Book> testAuthor4 = bookRepository.findAllAvailableBooks();
        assertTrue(testAuthor4.size() == 2);

        books.add(testBookContained);
        assertTrue(bookRepository.findAllAvailableBooks().size() == 3);


    }

    @Test
    void findAllUnAvailableBooksTest() {
        Book testBookContained = new Book("testIsbn5", "testTitle4", "testAuthor4", "testGenre4", false);
        List<Book> testAuthor4 = bookRepository.findAllUnAvailableBooks();
        assertTrue(testAuthor4.size() == 2);

        books.add(testBookContained);
        assertTrue(bookRepository.findAllUnAvailableBooks().size() == 3);
    }
}
