package LibraryManagement.DataLayer;

import LibraryManagement.Books;
import LibraryManagement.UserBooksMapper;

import java.util.List;

public interface IBooksDB {
    List<Books> LoadAllBooks();
    void AddBook(Books book);
    List<Books> DeleteBook(int id);

    List<Books> DecreaseBooksCopies(Books searchBook);

    List<UserBooksMapper> UsersIssuedBooks(IUserBooksMapperDB userBooksMapperDB, int bookID);

    void IncreaseRecord(List<UserBooksMapper> issuedBook);

    List<Books> LoadAllBooksPerMember(IUserBooksMapperDB userBooksMapperDB, int memberID);
}
