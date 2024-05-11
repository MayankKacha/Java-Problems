package LibraryManagement.DataLayer;

import LibraryManagement.Books;
import LibraryManagement.UserBooksMapper;

import java.util.ArrayList;
import java.util.List;

public class UserBooksMapperDB implements IUserBooksMapperDB{
    private List<UserBooksMapper> userBookMapping = new ArrayList<>();
    @Override
    public void AddUserBooksMap(UserBooksMapper userBooksMapper) {
        this.userBookMapping.add(userBooksMapper);
    }

    @Override
    public List<UserBooksMapper> LoadAllUsersBooksMapper() {
        return this.userBookMapping;
    }
    @Override
    public void RemoveRecord(List<UserBooksMapper> issuedBook){
        userBookMapping.removeIf(x->x.getUserID() == issuedBook.get(0).getUserID() &&
                x.getBookID() == issuedBook.get(0).getBookID());
    }


}
