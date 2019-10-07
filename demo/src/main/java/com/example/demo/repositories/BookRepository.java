package com.example.demo.repositories;


import com.example.demo.types.BookType;

import java.util.List;

public interface BookRepository {

    List<BookType> getBooks();


}