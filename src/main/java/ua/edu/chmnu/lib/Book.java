package ua.edu.chmnu.lib;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Book {
    private String isbn;

    private List<String> authors;

    private String title;

    private int year;

    private int pages;

    private Catalog catalog;

    public void getInfo(){
        System.out.println("IBSN: " + this.getIsbn() + " Authors: " + this.getAuthors() + " Title is: " + this.getTitle() + " Year " + this.getYear() +
                " Pages are " + this.getPages() + " Catalog is " + this.getCatalog().getIndex());
    }
}
