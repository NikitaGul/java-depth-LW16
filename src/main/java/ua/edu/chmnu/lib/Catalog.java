package ua.edu.chmnu.lib;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder(toBuilder = true)
public class Catalog {

    private Long id;

    private String index;

    private Library lib;

    private final List<Book> books = new ArrayList<>();

    public void add(Book book){
        if(book.getTitle().startsWith(this.index)){
            books.add(book);
            book.setCatalog(this);
        }
    }

    public List<Book> findAllBooksByName(String name){
       return books.stream()
               .filter(book -> book.getTitle().startsWith(name))
               .collect(Collectors.toList());
    }

    public void removeBook(Book book){
        if(books.remove(book)){
            book.setCatalog(null);
        }
    }

    public void getBooksList(){
        if(!this.getBooks().isEmpty()) {
            this.getBooks().forEach(book -> book.getInfo());
        }
        else {
            System.out.println("Catalog doesn't have books");
        }
    }
}
