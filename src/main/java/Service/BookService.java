package Service;

import bean.Book;
import bean.BookSearch;

import java.util.List;

/**
 * Created by 96283 on 2018/11/7.
 */
public interface BookService {
    public void insertBook(Book book);
    public void deleteBook(int id);
    public void updateBook(Book book);
    public List<Book> getBooks(BookSearch bookSearch);
}
