package org.webler.zsolt.repository;

import org.webler.zsolt.model.Book;
import org.webler.zsolt.model.Patron;

import java.util.List;
import java.util.Optional;

public class PatronRepository implements IPatronRepository {

    private final List<Patron> patronDataSource;

    public PatronRepository(List<Patron> dataSource) {
        this.patronDataSource = dataSource;
    }


    @Override
    public Optional<Patron> findPatronByLibraryCardNumber(long libraryCardNumber) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Patron> findPatronByName(String name) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Patron> findPatronByEmail(String email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Patron> findPatronByBorrowedBook(Book book) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Patron patron) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Patron patron) {
        throw new UnsupportedOperationException();
    }
}
