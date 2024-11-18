package ua.edu.chmnu.lib;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class BookUtils {
    public Book findByNumber(List<Book> chooseBook, int number){
        if(chooseBook.isEmpty()) {
            return null;
        }
        else {
            return chooseBook.get(number - 1);
        }
    }
}
