package org.webler.zsolt.repository;

import org.webler.zsolt.model.Book;
import org.webler.zsolt.model.Patron;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PatronRepository implements IPatronRepository {

    private final List<Patron> patronDataSource;

    public PatronRepository(List<Patron> dataSource) {
        this.patronDataSource = dataSource;
    }

    @Override
    public boolean add(Patron patron) {

        if (!patronDataSource.stream().map(Patron::getLibraryCardNumber).collect(Collectors.toList()).contains(patron.getLibraryCardNumber())) {
            return patronDataSource.add(patron);
        }
        return false;
    }

    @Override
    public boolean remove(Patron patron) {
        return patronDataSource.remove(patron);
    }

    @Override
    public Optional<Patron> findPatronByLibraryCardNumber(long libraryCardNumber) {
        return patronDataSource.stream().filter(patron -> patron.getLibraryCardNumber() == libraryCardNumber).findFirst();
    }

    @Override
    public List<Patron> findPatronByName(String name) {
        return patronDataSource.stream().filter(patron -> patron.getName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Patron> findPatronByEmail(String email) {

        return patronDataSource.stream().filter(patron -> patron.getEmail().equals(email)).collect(Collectors.toList());
    }

    @Override
    public List<Patron> findPatronByBorrowedBook(Book book) {
        return patronDataSource.stream().filter(patron -> patron.getBorrowedBooks().contains(book)).collect(Collectors.toList());
    }


}
