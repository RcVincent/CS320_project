package DBpersist;

import java.util.List;

import edu.ycp.cs320.booksdb.model.Author;
import edu.ycp.cs320.booksdb.model.Book;
import edu.ycp.cs320.booksdb.model.Pair;

public interface IDatabase {
	public List<Pair<Author, Book>> findAuthorAndBookByTitle(String title);

	public List<Pair<Author, Book>> findBookByAuthorName(String authorLast);

	public List<Pair<Author, Book>> insertNewBook(String title, String authorLast, String authorFirst, String isbn);
}