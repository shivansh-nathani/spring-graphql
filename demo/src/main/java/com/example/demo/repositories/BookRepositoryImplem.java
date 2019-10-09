package com.example.demo.repositories;

import com.example.demo.types.BookType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BookRepositoryImplem implements BookRepository{

    private List<BookType> book = new ArrayList<BookType>(Arrays.asList(
            new BookType("123","a"),
            new BookType("234","B")
    ));

    @Override
    public List<BookType> getBooks() {

        return this.book;
    }
    @Override
    public List<BookType> addBook(BookType b){
    	book.add(b);
    	return book;
    }
 

}
