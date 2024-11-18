package ua.edu.chmnu.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Catalog catalog1;
    private Catalog catalog2;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;


    @BeforeEach
    void setUp(){
        library = Library.builder()
                .id(1L)
                .name("UniversityLib")
                .website("https://www//ChmnuLib.com.edu.ua")
                .build();
        catalog1 = Catalog.builder()
                .id(1L)
                .index("N")
                .lib(library)
                .build();
        catalog2 = Catalog.builder()
                .id(2L)
                .index("C")
                .lib(library)
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
    void shouldSuccessAddBookToCatalog() {
        library.getCatalogs().add(catalog2);

        library.add(book1);

        catalog2.getBooks().forEach(book -> System.out.println(book.getTitle()));

        assertTrue(catalog2.getBooks().contains(book1));
    }


    @Test
    void shouldNotAddBookToCatalog() {
        library.getCatalogs().add(catalog2);

        library.add(book3);

        catalog2.getBooks().forEach(book -> System.out.println(book.getTitle()));

        assertFalse(catalog2.getBooks().contains(book1));
    }

    @Test
    void shouldRemoveBook() {

        library.getCatalogs().add(catalog1);
        library.getCatalogs().add(catalog2);

        library.add(book1);
        library.add(book2);
        library.add(book3);
        library.add(book4);
        library.add(book5);

        library.removeBook(book1);
        library.removeBook(book4);

        assertEquals(1, catalog1.getBooks().size());
    }

    @Test
    void shouldNotRemoveBook() {

        library.getCatalogs().add(catalog1);
        library.getCatalogs().add(catalog2);

        library.add(book1);
        library.add(book2);
        library.add(book3);
        library.add(book4);
        library.add(book5);

        library.removeBook(book1);
        library.removeBook(book4);

        assertEquals(1, catalog2.getBooks().size());
    }


    @Test
    void showListCatalog() {

        library.getCatalogs().add(catalog1);
        library.getCatalogs().add(catalog2);

        catalog1.add(book2);
        catalog1.add(book3);
        catalog2.add(book1);
        catalog2.add(book4);
        catalog2.add(book5);

        library.showListCatalog();

        assertEquals(3, catalog2.getBooks().size());
    }

    @Test
    void showEmptyCatalog() {

        library.getCatalogs().add(catalog1);
        library.getCatalogs().add(catalog2);

        catalog1.add(book2);
        catalog1.add(book3);

        library.showListCatalog();

        assertEquals(0, catalog2.getBooks().size());
    }
}