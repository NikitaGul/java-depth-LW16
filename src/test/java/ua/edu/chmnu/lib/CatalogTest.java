package ua.edu.chmnu.lib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;

    private Catalog catalog;

    @BeforeEach
    public void setUp(){
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
    void shouldSuccessAddBook() {

        catalog.add(book1);
        assertEquals(1, catalog.getBooks().size());

    }
    @Test
    void shouldNotAddBook() {

        catalog.add(book2);
        assertEquals(0, catalog.getBooks().size());

    }

    @Test
    void findAllBooksByName() {

        String name = "Cit";

        catalog.add(book1);
        catalog.add(book3);
        catalog.add(book4);

        List<Book> bookList = catalog.findAllBooksByName(name);
        //bookList.forEach(book -> System.out.println(book.getTitle()));

        assertEquals(2, bookList.size());

    }

    @Test
    void findNotBooksByName() {

        String name = "Cit";

        catalog.add(book2);
        catalog.add(book3);

        List<Book> bookList = catalog.findAllBooksByName(name);
        //bookList.forEach(book -> System.out.println(book.getTitle()));

        assertEquals(0, bookList.size());

    }

    @Test
    void findAllBooksByNameList() {

        String name = "Cit";

        catalog.add(book1);
        catalog.add(book3);
        catalog.add(book5);

        List<Book> bookList = catalog.findAllBooksByName(name);

        for (Book book : bookList) {
            System.out.println("Title of book" + book.getTitle() + ", year " + book.getYear() + " index " + (bookList.indexOf(book) + 1));
        }

        int ind1 = 1;

        Book mainBook = BookUtils.findByNumber(bookList, ind1);

        /*for (Book book54 : bookList) {
            System.out.println("Title of book" );
        }*/

        assertEquals(book1, mainBook);


    }

    @Test
    void shouldSuccessRemoveBook() {

            catalog.add(book1);
            catalog.add(book3);

            catalog.removeBook(book1);

            assertEquals(0, catalog.getBooks().size());
    }

    @Test
    void showBooks() {

        catalog.add(book1);
        catalog.add(book3);

        catalog.getBooksList();

        assertEquals(1, catalog.getBooks().size());
    }

    @Test
    void NoBookInList() {

        catalog.add(book1);
        catalog.add(book3);

        catalog.removeBook(book1);

        catalog.getBooksList();

        assertEquals(0, catalog.getBooks().size());
    }
}