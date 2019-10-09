package com.example.demo.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.BookRepositoryImplem;
import com.example.demo.types.Book;
import com.example.demo.types.BookType;
@Component
public class MutationResolver implements GraphQLMutationResolver{
	
	@Autowired
	private BookRepository bookrep;
	
	void setBookObj(BookRepository b)
	{
		this.bookrep=b;
	}
	
	
	public List<BookType> addBook(Book book){
		
	return	this.bookrep.addBook(book);
		

	}
}
