package LibraryManagement.DataLayer;

import LibraryManagement.UserBooksMapper;

import java.util.List;

public interface IUserBooksMapperDB {
    void AddUserBooksMap(UserBooksMapper userBooksMapper);

    List<UserBooksMapper> LoadAllUsersBooksMapper();

    void RemoveRecord(List<UserBooksMapper> issuedBook);
}
