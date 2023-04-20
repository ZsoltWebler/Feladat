package org.webler.zsolt.service;

import org.webler.zsolt.exceptions.BookNotFoundException;
import org.webler.zsolt.exceptions.NotFound;
import org.webler.zsolt.model.Book;
import org.webler.zsolt.model.Patron;
import org.webler.zsolt.repository.BookRepository;
import org.webler.zsolt.repository.PatronRepository;

import java.util.ArrayList;
import java.util.List;

public class LibrarianService implements ILibrarianService {

    private final PatronRepository patronRepository;
    private final BookRepository bookRepository;


    public LibrarianService(PatronRepository patronRepository, BookRepository bookRepository) {
        this.patronRepository = patronRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public boolean addBook(Book book) {
        return bookRepository.add(book);
    }

    @Override
    public boolean removeBook(Book book) {
        return bookRepository.remove(book);
    }

    @Override
    public boolean addPatron(Patron patron) {
        return patronRepository.add(patron);
    }

    @Override
    public boolean removePatron(Patron patron) {
        return patronRepository.remove(patron);
    }

    @Override
    public void printBookInformation(Book book) {

        System.out.println(book.toString());
    }

    @Override
    public void printPatronInformation(Patron patron) {

        System.out.println(patron.toString());
    }

    @Override
    public void borrowBook(Patron patron, Book bookToBorrow) throws NotFound {

        if (!bookToBorrow.isAvailable()) {
            throw new BookNotFoundException();
        }

        List<Book> patronsBooks = new ArrayList<>(patron.getBorrowedBooks());
        patronsBooks.add(bookToBorrow);
        patron.setBorrowedBooks(patronsBooks);


    }

    @Override
    public void returnBook(Patron patron, Book bookToBorrow) throws NotFound {
        boolean remove = patron.getBorrowedBooks().remove(bookToBorrow);
        if (!remove) {
            throw new BookNotFoundException();
        }
    }


}
