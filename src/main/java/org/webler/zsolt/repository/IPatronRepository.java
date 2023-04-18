package org.webler.zsolt.repository;

import org.webler.zsolt.model.Book;
import org.webler.zsolt.model.Patron;

import java.util.List;
import java.util.Optional;

public interface IPatronRepository extends IRepository<Patron>{

    Optional<Patron> findPatronByLibraryCardNumber(long libraryCardNumber);
    List<Patron> findPatronByName(String name);
    List<Patron> findPatronByEmail(String email);
    List<Patron> findPatronByBorrowedBook(Book book);

}
