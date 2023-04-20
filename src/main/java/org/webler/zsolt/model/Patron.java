package org.webler.zsolt.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Patron {

    private String name;
    private String email;
    private long libraryCardNumber;
    private List<Book> borrowedBooks;


}
