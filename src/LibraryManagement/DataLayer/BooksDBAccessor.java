package LibraryManagement.DataLayer;

import LibraryManagement.Books;
import LibraryManagement.UserBooksMapper;
import LibraryManagement.authentication.UserAuthenticator;
import LibraryManagement.searcher.IDBasedBookSearcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BooksDBAccessor implements IBooksDB {
    private List<Books> books = new ArrayList<>();
    @Override
    public List<Books> LoadAllBooks() {

        Books scienceBook = new Books();
        scienceBook.setBookName("Science magic");
        scienceBook.setCopies(2);
        scienceBook.setAuthorName("Mayank Kacha");
        scienceBook.setID(0);
        scienceBook.setPublishedDate(new Date());
        books.add(scienceBook);
        Books commerceBook = new Books();
        commerceBook.setBookName("Commerce magic");
        commerceBook.setCopies(1);
        commerceBook.setAuthorName("Mayank Kacha");
        commerceBook.setPublishedDate(new Date());
        commerceBook.setID(1);
        books.add(commerceBook);
        scienceBook = new Books();
        scienceBook.setBookName("Science World");
        scienceBook.setCopies(6);
        scienceBook.setAuthorName("Kacha");
        scienceBook.setID(2);
        scienceBook.setPublishedDate(new Date());
        books.add(scienceBook); // we have to create a method which can return us current id
        return books;
    }

    @Override
    public void AddBook(Books book) {
        this.books.add(book);
    }
    @Override
    public List<Books> DeleteBook(int id){
        List<Books> books = LoadAllBooks();
        Iterator<Books> iterator = books.iterator();
        while(iterator.hasNext()){
            Books book = iterator.next();
            if (book.getID() == id){
                iterator.remove();
                break;
            }
        }
        return books;
    }
    @Override
    public List<Books> DecreaseBooksCopies(Books searchBook){
        Predicate<Books> bookWithIssuedBookID = book -> book.getID() == searchBook.getID();
        return LoadAllBooks().stream().map(book -> {
            if (bookWithIssuedBookID.test(book)){
                book.setCopies(book.getCopies() - 1);
            }
            return book;
        }).collect(Collectors.toList());
    }
    @Override
    public List<UserBooksMapper> UsersIssuedBooks(IUserBooksMapperDB userBooksMapperDB, int bookID){
        return userBooksMapperDB.LoadAllUsersBooksMapper().stream()
                .filter(x -> x.getBookID() == bookID && x.getUserID() == UserAuthenticator.GetID())
                .toList();
    }
    @Override
    public void IncreaseRecord(List<UserBooksMapper> issuedBook){
        Predicate<Books> bookIdEqualsUserBookId = book -> book.getID() == issuedBook.get(0).getBookID();
        books = books.stream().map(
                book -> {
                    if (bookIdEqualsUserBookId.test(book)){
                        book.setCopies(book.getCopies() + 1);
                    }
                    return book;
                }
        ).collect(Collectors.toList());
    }
    @Override
    public List<Books> LoadAllBooksPerMember(IUserBooksMapperDB userBooksMapperDB,int memberID){
        List<UserBooksMapper> userBooksMappers = new ArrayList<>();
        userBooksMappers = userBooksMapperDB.LoadAllUsersBooksMapper().stream()
                .filter(x->x.getUserID() == memberID).collect(Collectors.toList());
        List<Books> books = new ArrayList<>();
        for (int i=0;i< userBooksMappers.size();i++){
            List<Books> book = new IDBasedBookSearcher(userBooksMappers.get(i).getBookID(),this).search();
            if (book != null && !book.isEmpty()){
                books.add(book.get(0));
            }
        }
        return books;
    }
}
