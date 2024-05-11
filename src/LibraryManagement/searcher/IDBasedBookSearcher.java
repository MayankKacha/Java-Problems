package LibraryManagement.searcher;

import LibraryManagement.Books;
import LibraryManagement.DataLayer.IBooksDB;

import java.util.List;

public class IDBasedBookSearcher implements IBookSearcher{
    private int id;
    private IBooksDB booksDB;
    public IDBasedBookSearcher(int id, IBooksDB booksDB) {
        this.id = id;
        this.booksDB = booksDB;
    }

    @Override
    public List<Books> search() {
        return this.booksDB.LoadAllBooks().stream().filter(s -> s.getID()==id).toList();
    }
}
