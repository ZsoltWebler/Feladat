package org.webler.zsolt.service;

import org.webler.zsolt.exceptions.NotFound;
import org.webler.zsolt.model.Book;
import org.webler.zsolt.model.Patron;
import org.webler.zsolt.repository.BookRepository;
import org.webler.zsolt.repository.PatronRepository;

public class LibrarianService implements ILibrarianService {

    private final PatronRepository patronRepository;
    private final BookRepository bookRepository;


    public LibrarianService(PatronRepository patronRepository, BookRepository bookRepository) {
        this.patronRepository = patronRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean addBook() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeBook() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addPatron() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removePatron() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void printBookInformation(Book book) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void printPatronInformation(Patron patron) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void borrowBook(Patron patron, Book bookToBorrow) throws NotFound {
        throw new UnsupportedOperationException();
    }

    @Override
    public void returnBook(Patron patron, Book bookToBorrow) throws NotFound {
        throw new UnsupportedOperationException();
    }


}
