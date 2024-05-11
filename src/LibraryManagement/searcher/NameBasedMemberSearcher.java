package LibraryManagement.searcher;

import LibraryManagement.DataLayer.IUsersDB;
import LibraryManagement.User;

import java.util.ArrayList;
import java.util.List;

public class NameBasedMemberSearcher implements IMemberSearcher{
    private String memberName;
    private IUsersDB usersDB;
    public NameBasedMemberSearcher(String memberName, IUsersDB usersDB){
        this.memberName = memberName;
        this.usersDB = usersDB;
    }
    @Override
    public List<User> search(){
        List<User> users = this.usersDB.LoadAllUsers();
        return users.stream().filter(x -> x.getName().startsWith(memberName)).toList();
    }
}
