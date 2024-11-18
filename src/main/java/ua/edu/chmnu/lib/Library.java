package ua.edu.chmnu.lib;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class Library {

    private Long id;

    private String name;

    private String website;

    private final List<Catalog> catalogs = new ArrayList<>();

    public void add(Book book) {
        catalogs.forEach(c -> c.add(book));
    }

    public void removeBook(Book book) {
        catalogs.forEach(c -> c.removeBook(book));
    }

    public void showListCatalog() {
        for (var c : catalogs) {
            System.out.println(c.getIndex() + " catalog " + c.getId());
        }
    }

    public static void main(String[] args) {

        Library library = Library.builder()
                .id(1L)
                .name("UniversityLib")
                .website("https://www//ChmnuLib.com.edu.ua")
                .build();

        Catalog catalog1 = Catalog.builder()
                .id(1L)
                .index("N")
                .lib(library)
                .build();
        Catalog catalog2 = Catalog.builder()
                .id(2L)
                .index("C")
                .lib(library)
                .build();
        Book book1 = Book.builder()
                .isbn("97861454634643")
                .authors(Collections.singletonList("Valerian Pidmogilniy"))
                .title("City")
                .year(1928)
                .pages(238)
                .catalog(null)
                .build();
        Book book2 = Book.builder()
                .isbn("978614234326654")
                .authors(Collections.singletonList("Ivan Nechuy-Levitskiy"))
                .title("Kaydasheva simya")
                .year(1879)
                .pages(151)
                .catalog(null)
                .build();
        Book book3 = Book.builder()
                .isbn("978962135454")
                .authors(Collections.singletonList("Ivan Kotlyrevskiy"))
                .title("Natalka-Poltavka")
                .year(1819)
                .pages(69)
                .catalog(null)
                .build();
        Book book4 = Book.builder()
                .isbn("97861454634643")
                .authors(Collections.singletonList("Valerian Pidmogilniy"))
                .title("City")
                .year(1947)
                .pages(238)
                .catalog(null)
                .build();
        Book book5 = Book.builder()
                .isbn("97861454634643")
                .authors(Collections.singletonList("Valerian Pidmogilniy"))
                .title("City")
                .year(1987)
                .pages(238)
                .catalog(null)
                .build();

        library.getCatalogs().add(catalog1);
        library.getCatalogs().add(catalog2);

        library.showListCatalog();

        library.add(book1);
        library.add(book2);
        library.add(book3);

        System.out.println("Books in first catalog :" + catalog1.getBooks().size());
        System.out.println("Books in second catalog :" + catalog2.getBooks().size());

        library.removeBook(book2);

        System.out.println("Books in first catalog :" + catalog1.getBooks().size());
        System.out.println("Books in second catalog :" + catalog2.getBooks().size());

        catalog1.getBooksList();

        library.add(book4);
        library.add(book5);

        List<Book> books = catalog2.findAllBooksByName("City");

        int NumberInd = 1;

        for(Book bookShow: books){
            bookShow.getInfo();
        }

        int numberIndex = 1;
        Book findToBook = BookUtils.findByNumber(books, numberIndex);

        findToBook.getInfo();

        catalog1.removeBook(book3);
        catalog1.getBooksList();
    }
}
