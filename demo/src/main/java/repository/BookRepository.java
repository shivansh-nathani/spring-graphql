package repository;
import java.util.List;

import org.springframework.stereotype.Component;

import types.BookType;
@Component
public interface BookRepository {
	
	
	public List<BookType> getBooks();
	

}
