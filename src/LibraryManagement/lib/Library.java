package LibraryManagement.lib;

import LibraryManagement.Books;
import LibraryManagement.DataLayer.IBooksDB;
import LibraryManagement.DataLayer.IUserBooksMapperDB;
import LibraryManagement.DataLayer.IUsersDB;
import LibraryManagement.DataLayer.UserBooksMapperDB;
import LibraryManagement.UserBooksMapper;
import LibraryManagement.authentication.UserAuthenticator;
import LibraryManagement.searcher.IDBasedBookSearcher;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Library {
    //Instead of creating multiple interfaces we can inject classes
    private IBooksDB booksDB;
    private IUsersDB usersDB;
    private IUserBooksMapperDB userBooksMapperDB;
    public Library(IBooksDB booksDB , IUsersDB usersDB, IUserBooksMapperDB userBooksMapperDB){
        this.booksDB = booksDB;
        this.usersDB = usersDB;
        this.userBooksMapperDB = userBooksMapperDB;
    }
    // add a book
    public void AddBook(){
        Scanner sc = new Scanner(System.in);
        Books addBook = new Books();
        System.out.println("Add Book detail!");
        addBook.setID(sc.nextInt());
        sc.nextLine();
        addBook.setAuthorName(sc.nextLine());
        addBook.setBookName(sc.nextLine());
        addBook.setPublishedDate(new Date());
        this.booksDB.AddBook(addBook);
    }
    // delete a book
    public List<Books> DeleteBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book id to delete!");
        int deleteId = sc.nextInt();
        return this.booksDB.DeleteBook(deleteId);
    }
    // issue a book
    public void IssueABook(int bookID){
        List<Books> searchedBooks = new IDBasedBookSearcher(bookID , this.booksDB).search();
        Books searchBook = new Books();
        if (!searchedBooks.isEmpty()){
            searchBook = searchedBooks.get(0);
        }
        // see if copies count > 0
        if (searchBook.getCopies() > 0){
            SetUserBooksMapper(searchBook);
        }else{
            System.out.println("We cant issue this book as we dont have enough copies with us!");
        }
    }
    private void SetUserBooksMapper(Books searchBook){
        int userID = UserAuthenticator.GetID();
        int bookID = searchBook.getID();
        UserBooksMapper userBooksMapper = new UserBooksMapper();
        userBooksMapper.setUserID(userID);
        userBooksMapper.setBookID(bookID);
        System.out.println("Do you want to set back dated date?");
        Scanner sc = new Scanner(System.in);
        if (sc.nextInt() != 0){
            System.out.println("Enter number of days!");
            SetBackDatedDate(sc.nextInt(),userBooksMapper);
        }else{
            SetBackDatedDate(0, userBooksMapper);
        }
        this.userBooksMapperDB.AddUserBooksMap(userBooksMapper);
        this.booksDB.DecreaseBooksCopies(searchBook);
    }
    private void SetBackDatedDate(int numberOfdays,UserBooksMapper userBooksMapper ){
        int miliSeconds = numberOfdays * 60 * 60 * 24 * 1000;
        Date currentDate = new Date();
        Date backDate = new Date(currentDate.getTime() - miliSeconds);
        userBooksMapper.setIssuedDate(backDate);
    }
    public void IsSubmitRequest(int bookID){
        List<UserBooksMapper> issuedBook = this.booksDB.UsersIssuedBooks(this.userBooksMapperDB , bookID);
        if (!issuedBook.isEmpty()){
            // calculate penalties if any
            long penalties = CalculatePenalties(issuedBook.get(0));
            System.out.println("Current penalty amount is " + penalties);
            // remove that record where we pass userid and bookid
            this.userBooksMapperDB.RemoveRecord(issuedBook);
            // increase the counter in object
            this.booksDB.IncreaseRecord(issuedBook);
        }
    }
    private long CalculatePenalties(UserBooksMapper userBooksMapper){
        Date currentDate = new Date();
        long diffinMs = Math.abs(userBooksMapper.getIssuedDate().getTime() - currentDate.getTime());
        long numOfDays = TimeUnit.DAYS.convert(diffinMs , TimeUnit.MILLISECONDS);
        return numOfDays * 5;
    }
    // block a member
    public void BlockMember(int memberID){
        this.usersDB.BlockMember(memberID);
    }
    // get borrower which book copy is assigned to which user
    public List<UserBooksMapper> LoadBorrowersAndBooksAssigned(){
        return this.userBooksMapperDB.LoadAllUsersBooksMapper();
    }
    // get borrowed books a member borrowed which all books
    public List<Books> GetMemberBooksBorrowed(int memberID){
        return this.booksDB.LoadAllBooksPerMember(new UserBooksMapperDB() , memberID);
    }
}
