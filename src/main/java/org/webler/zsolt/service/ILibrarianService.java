package org.webler.zsolt.service;

import org.webler.zsolt.exceptions.NotFound;
import org.webler.zsolt.model.Book;
import org.webler.zsolt.model.Patron;

public interface ILibrarianService {

    boolean addBook();

    boolean removeBook();

    boolean addPatron();

    boolean removePatron();

    void printBookInformation(Book book);

    void printPatronInformation(Patron patron);

    void borrowBook(Patron patron, Book bookToBorrow) throws NotFound;

    void returnBook(Patron patron, Book bookToBorrow) throws NotFound;

}
