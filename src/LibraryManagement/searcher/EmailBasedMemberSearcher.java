package LibraryManagement.searcher;

import LibraryManagement.DataLayer.IUsersDB;
import LibraryManagement.User;

import java.util.List;

public class EmailBasedMemberSearcher implements IMemberSearcher{
    private IUsersDB usersDB;
    private String email;
    public EmailBasedMemberSearcher(IUsersDB usersDB, String email){
        this.usersDB = usersDB;
        this.email = email;
    }
    @Override
    public List<User> search() {
        List<User> users = this.usersDB.LoadAllUsers();
        return users.stream().filter(x -> x.getEmail().equals(email)).toList();
    }
}
