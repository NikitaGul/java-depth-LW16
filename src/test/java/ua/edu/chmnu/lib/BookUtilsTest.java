package ua.edu.chmnu.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookUtilsTest {

    private Catalog catalog;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;

    @BeforeEach
    void setUp(){
        catalog = Catalog.builder()
                .id(231321L)
                .index("C")
                .build();

        book1 = Book.builder()
                .isbn("97861454634643")
                .authors(Collections.singletonList("Valerian Pidmogilniy"))
                .title("City")
                .year(1928)
                .pages(238)
                .catalog(null)
                .build();
        book2 = Book.builder()
                .isbn("978614234326654")
                .authors(Collections.singletonList("Ivan Nechuy-Levitskiy"))
                .title("Kaydasheva simya")
                .year(1879)
                .pages(151)
                .catalog(null)
                .build();
        book3 = Book.builder()
                .isbn("978962135454")
                .authors(Collections.singletonList("Ivan Kotlyrevskiy"))
                .title("Natalka-Poltavka")
                .year(1819)
                .pages(69)
                .catalog(null)
                .build();
        book4 = Book.builder()
                .isbn("97861454634643")
                .authors(Collections.singletonList("Valerian Pidmogilniy"))
                .title("City")
                .year(1947)
                .pages(238)
                .catalog(null)
                .build();
        book5 = Book.builder()
                .isbn("97861454634643")
                .authors(Collections.singletonList("Valerian Pidmogilniy"))
                .title("City")
                .year(1987)
                .pages(238)
                .catalog(null)
                .build();
    }

    @Test
    void showList(){
        catalog.add(book1);
        catalog.add(book4);
        catalog.add(book5);

        List<Book> BooksList = catalog.findAllBooksByName("Cit");

        Book book = BookUtils.findByNumber(BooksList, 1);

        assertEquals(book1, book);

    }

    @Test
    void emptyList(){
        catalog.add(book2);
        catalog.add(book3);

        List<Book> BooksList = catalog.findAllBooksByName("Cit");

        Book book = BookUtils.findByNumber(BooksList, 1);

        boolean check = false;
        if(book != null){
            check = true;
        }

        assertFalse(check);

    }
}