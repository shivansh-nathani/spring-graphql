package resolver;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import repository.BookRepository;
import types.BookType;

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
