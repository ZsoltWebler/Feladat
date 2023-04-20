package org.webler.zsolt.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.webler.zsolt.model.Book;
import org.webler.zsolt.model.Patron;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PatronRepositoryTest {

    PatronRepository patronRepository;
    List<Patron> patrons;

    @BeforeEach
    void init() {

        Book book = new Book("testIsbn", "testTitle", "testAuthor", "testGenre", true);
        Book otherBook = new Book("testIsbn2", "testTitle2", "testAuthor2", "testGenre2", false);

        List<Patron> testPatrons = Arrays.asList(

                new Patron("Patron_1", "patron_1@lib.com", 11L, new ArrayList<>(Arrays.asList(book))),
                new Patron("Patron_2", "patron_2@lib.com", 12L, new ArrayList<>(Arrays.asList(book, otherBook))),
                new Patron("Patron_3", "patron_3@lib.com", 13L, new ArrayList<>()),
                new Patron("Patron_4", "patron_4@lib.com", 14L, new ArrayList<>(Arrays.asList(otherBook)))
        );
        patrons = new ArrayList<>(testPatrons);
        patronRepository = new PatronRepository(patrons);
    }

    @Test
    void addTest() {
        Patron testUniquePatron = new Patron("Patron_3", "patron_3@lib.com", 15L, new ArrayList<>());
        Patron testNotUniquePatron = new Patron("Patron_4", "patron_4@lib.com", 14L, new ArrayList<>(Arrays.asList()));
        boolean uniquePatronWasAdded = patronRepository.add(testUniquePatron);
        boolean notUniquePatronWasAdded = patronRepository.add(testNotUniquePatron);

        assertTrue(uniquePatronWasAdded);
        assertFalse(notUniquePatronWasAdded);

        assertTrue(patrons.contains(testUniquePatron));
    }

    @Test
    void removeTest() {
        Patron testContainedPatron = new Patron("Patron_3", "patron_3@lib.com", 13L, new ArrayList<>());
        Patron testNotContainedPatron = new Patron("Patron_5", "patron_5@lib.com", 15L, new ArrayList<>(Arrays.asList()));

        assertTrue(patrons.contains(testContainedPatron));

        boolean containedPatronWasRemoved = patronRepository.remove(testContainedPatron);
        boolean notContainedPatronWasRemoved = patronRepository.remove(testNotContainedPatron);

        assertTrue(containedPatronWasRemoved);
        assertFalse(notContainedPatronWasRemoved);

        assertFalse(patrons.contains(testContainedPatron));
    }

    @Test
    void findPatronByLibraryCardNumber() {

        Patron testContainedPatron = new Patron("Patron_3", "patron_3@lib.com", 13L, new ArrayList<>());
        Patron testNotContainedPatron = new Patron("Patron_5", "patron_5@lib.com", 15L, new ArrayList<>(Arrays.asList()));

        assertEquals(testContainedPatron,patronRepository.findPatronByLibraryCardNumber(testContainedPatron.getLibraryCardNumber()).get());
        assertFalse(patronRepository.findPatronByLibraryCardNumber(testNotContainedPatron.getLibraryCardNumber()).isPresent());


    }

    @Test
    void findPatronByName() {
        Patron testContainedPatron = new Patron("Patron_3", "patron_3@lib.com", 16L, new ArrayList<>());
        List<Patron> testPatrons = patronRepository.findPatronByName(testContainedPatron.getName());
        assertTrue(testPatrons.size() == 1);

        patrons.add(testContainedPatron);
        assertTrue(patronRepository.findPatronByName("Patron_3").size() == 2);
    }

    @Test
    void findPatronByEmail() {
        Patron testContainedPatron = new Patron("Patron_3", "patron_3@lib.com", 16L, new ArrayList<>());
        List<Patron> testPatrons = patronRepository.findPatronByEmail(testContainedPatron.getEmail());
        assertTrue(testPatrons.size() == 1);

        patrons.add(testContainedPatron);
        assertTrue(patronRepository.findPatronByEmail("patron_3@lib.com").size() == 2);
    }

    @Test
    void findPatronByBorrowedBook() {
        Book book = new Book("testIsbn", "testTitle", "testAuthor", "testGenre", true);
        Patron testContainedPatron = new Patron("Patron_1", "patron_1@lib.com", 18L, new ArrayList<>(Arrays.asList(book)));
        List<Patron> testPatrons = patronRepository.findPatronByBorrowedBook(book);
        assertTrue(testPatrons.size() == 2);

        patrons.add(testContainedPatron);
        assertTrue(patronRepository.findPatronByBorrowedBook(book).size() == 3);
    }

}
