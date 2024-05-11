package LibraryManagement.DataLayer;

import LibraryManagement.User;

import java.util.List;

public interface IUsersDB {
    List<User> LoadAllUsers();

    List<User> BlockMember(int memberID);
}
