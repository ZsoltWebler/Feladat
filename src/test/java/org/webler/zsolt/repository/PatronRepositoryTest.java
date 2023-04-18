package org.webler.zsolt.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class PatronRepositoryTest {

    PatronRepository patronRepository;

    @BeforeEach
    void init() {
        patronRepository = new PatronRepository(Collections.emptyList());
    }

    @Test
    void addTest() {
    }

    @Test
    void removeTest() {
    }

    @Test
    void findPatronByLibraryCardNumber() {
    }

    @Test
    void findPatronByName() {
    }

    @Test
    void findPatronByEmail() {
    }

    @Test
    void findPatronByBorrowedBook() {
    }

}
