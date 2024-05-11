package LibraryManagement.searcher;

import LibraryManagement.DataLayer.IUsersDB;
import LibraryManagement.DataLayer.UsersDBAccessor;
import LibraryManagement.User;

import java.util.List;
import java.util.stream.Collectors;

public class IDBasedMemberSearcher implements IMemberSearcher{
    private int id;
    public IDBasedMemberSearcher(int id){
        this.id = id;
    }
    @Override
    public List<User> search() {
        IUsersDB usersDB = new UsersDBAccessor();
        List<User> users = usersDB.LoadAllUsers();
        return users.stream().filter(x-> x.getId() == id).collect(Collectors.toList());
    }
}
