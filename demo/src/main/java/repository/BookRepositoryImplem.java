package repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import types.BookType;
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

}