package LibraryManagement;

import LibraryManagement.DataLayer.BooksDBAccessor;
import LibraryManagement.DataLayer.UserBooksMapperDB;
import LibraryManagement.DataLayer.UsersDBAccessor;
import LibraryManagement.authentication.UserAuthenticator;
import LibraryManagement.lib.Library;
import LibraryManagement.searcher.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LibraryManagementStimulator {

    // Main method
    public static void main(String[] args){
        Library library = new Library(new BooksDBAccessor(), new UsersDBAccessor(), new UserBooksMapperDB());
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your email id to log in!");
        String email = sc.next();
        boolean isLoggedInUserAdmin = UserAuthenticator.IsAdmin(email); // here we will return User object
        boolean isActive = UserAuthenticator.IsActive();
        if (isLoggedInUserAdmin && isActive){
            System.out.println("Welcome admin!");
        } else{
            System.out.println("Welcome members!");
        }
        System.out.println("Enter books author name to search!");
        IBookSearcher bookSearcher = new AuthorBasedNameSearcher(sc.next(), new BooksDBAccessor());
        List<Books> searchByAuthorName = bookSearcher.search();
        for (Books book :
                searchByAuthorName) {
            System.out.println(book.getBookName() + " " + book.getPublishedDate());
        }
        System.out.println("Enter book name to search!");
        bookSearcher = new NameBasedBookSearcher(sc.next(), new BooksDBAccessor());
        searchByAuthorName = bookSearcher.search();
        for (Books book :
                searchByAuthorName) {
            System.out.println(book.getBookName() + " " + book.getPublishedDate());
        }
        System.out.println("Enter members name to search!");
        if (isLoggedInUserAdmin && isActive){
            IMemberSearcher memberSearcher = new NameBasedMemberSearcher(sc.next(), new UsersDBAccessor());
            List<User> loggedInMember = memberSearcher.search();
            for (User user :
                    loggedInMember) {
                System.out.println(user.getEmail() + " " + user.getName());
            }
        }

        System.out.println("Add a book?");
        boolean isAddRq = sc.nextInt() != 0;
        if (isAddRq && isLoggedInUserAdmin && isActive){
            library.AddBook();
        }else{
            System.out.println("You are not admin!");
        }
        System.out.println("Delete a book?");
        boolean isDelRq = sc.nextInt() != 0;
        if (isDelRq && isLoggedInUserAdmin && isActive){
            List<Books> booksAfterDeletion = library.DeleteBook();
        }else{
            System.out.println("You are not admin!");
        }
        System.out.println("Issue a book?");
        boolean isIssueRequest = sc.nextInt() != 0;
        if (isIssueRequest){
            library.IssueABook(sc.nextInt());
        }
        System.out.println("Submit a book?");
        boolean isSubmitRequest = sc.nextInt() != 0;
        if (isSubmitRequest){
            System.out.println("Enter a bookID ");
            library.IsSubmitRequest(sc.nextInt());
        }

        // we can check here if User has role of Librarian then different else different
    }

    // Search books owned by user

    // Block the user by user id

    // See how many copies are there for a book

    // See a book is owned by which all users

    // Issue a book based on student id

    // Block a member
}
