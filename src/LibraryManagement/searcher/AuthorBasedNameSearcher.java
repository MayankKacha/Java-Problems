package LibraryManagement.searcher;

import LibraryManagement.Books;
import LibraryManagement.DataLayer.IBooksDB;

import java.util.ArrayList;
import java.util.List;

public class AuthorBasedNameSearcher implements IBookSearcher{
    private String authorName;
    private IBooksDB booksDB;
    public AuthorBasedNameSearcher(String authorName, IBooksDB booksDB){
        this.authorName = authorName;
        this.booksDB = booksDB;
    }
    @Override
    public List<Books> search(){
        List<Books> books = this.booksDB.LoadAllBooks();
        return books.stream().filter(x -> x.getAuthorName().startsWith(authorName)).toList();
    }
}
