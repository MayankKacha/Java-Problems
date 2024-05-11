package LibraryManagement.authentication;

import LibraryManagement.DataLayer.IUsersDB;
import LibraryManagement.DataLayer.UsersDBAccessor;
import LibraryManagement.User;
import LibraryManagement.searcher.EmailBasedMemberSearcher;
import LibraryManagement.searcher.IMemberSearcher;

import java.util.List;

public class UserAuthenticator {
    private UserAuthenticator(){

    }
    private static IUsersDB usersDB;
    private static User loggedInUser;
    private static User GetLoggedInUser(String email){
        usersDB = new UsersDBAccessor();
        IMemberSearcher memberSearcher = new EmailBasedMemberSearcher(new UsersDBAccessor(),email);
        // check if the user has privilege for librarian or member.
        List<User> matchedUsers = memberSearcher.search();
        if (!matchedUsers.isEmpty())
            return matchedUsers.get(0);
        // return login token
        return null; // we will return here User object
    }

    public static boolean IsAdmin(String email){
        loggedInUser = GetLoggedInUser(email);
        return loggedInUser.isAdmin();
    }

    public static boolean IsActive(){
        return loggedInUser.isActive();
    }

    public static int GetID(){
        if (loggedInUser == null || !loggedInUser.isAdmin()){
            throw new IllegalArgumentException("Either user is logged out or user is not admin!");
        }
        return loggedInUser.getId();
    }
}
