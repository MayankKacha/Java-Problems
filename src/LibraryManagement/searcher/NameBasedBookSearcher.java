package LibraryManagement.searcher;

import LibraryManagement.Books;
import LibraryManagement.DataLayer.IBooksDB;

import java.util.ArrayList;
import java.util.List;

public class NameBasedBookSearcher implements IBookSearcher{
    private String bookName;
    private IBooksDB booksDB;
    public NameBasedBookSearcher(String bookName, IBooksDB booksDB){
        this.bookName = bookName;
        this.booksDB = booksDB;
    }
    @Override
    public List<Books> search(){
        List<Books> books = this.booksDB.LoadAllBooks();
        return books.stream().filter(x -> x.getBookName().startsWith(bookName)).toList();
    }
}
