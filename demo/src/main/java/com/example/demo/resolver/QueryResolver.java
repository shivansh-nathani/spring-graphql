package com.example.demo.resolver;

import java.util.List;

import com.example.demo.repositories.BookRepository;
import com.example.demo.types.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;


@Component
public class QueryResolver implements GraphQLQueryResolver {

	@Autowired
	private BookRepository bookrep;

	void setBookObj(BookRepository b)
	{
		this.bookrep=b;
	}
	
	public List<BookType> allBooks() {
		
		return bookrep.getBooks();
	}

}
