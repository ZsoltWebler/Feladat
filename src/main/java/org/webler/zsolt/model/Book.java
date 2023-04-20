package org.webler.zsolt.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    private String isbn;
    private String title;
    private String author;
    private String genre;
    private boolean available;

}
