package com.example.demo.repositories;


import com.example.demo.types.Book;
import com.example.demo.types.BookType;

import java.util.List;

public interface BookRepository {

    List<BookType> getBooks();
    List<BookType> addBook(BookType b);
	Boolean deleteBook(String id);
	Boolean updateBook(Book book);


}