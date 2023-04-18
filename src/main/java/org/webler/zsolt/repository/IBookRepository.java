package org.webler.zsolt.repository;

import org.webler.zsolt.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookRepository extends IRepository<Book>{

    Optional<Book> findBookByIsbn(String isbn);

    List<Book> findBookByAuthor(String author);

    List<Book> findBookByTitle(String title);

    List<Book> findBookByGenre(String genre);

    List<Book> findBookByTittlePrefixMatch(String prefix);

    List<Book> findAllAvailableBooks();

    List<Book> findAllUnAvailableBooks();
}
