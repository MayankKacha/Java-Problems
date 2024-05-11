package LibraryManagement.DataLayer;

import LibraryManagement.Librarian;
import LibraryManagement.Member;
import LibraryManagement.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UsersDBAccessor implements IUsersDB{
    private List<User> users = new ArrayList<>();
    @Override
    public List<User> LoadAllUsers() {
        User librarian = new Librarian();
        librarian.setRole("Admin"); librarian.setActive(true); librarian.setName("Admin"); librarian.setId(1);
        librarian.setAdmin(true);
        librarian.setEmail("admin@test.com");
        users.add(librarian);
        User member = new Member();
        member.setRole("Member"); member.setActive(true); member.setName("Member"); member.setId(1);
        member.setEmail("member@test.com");
        member.setAdmin(false);
        users.add(member);
        return users;
    }
    @Override
    public List<User> BlockMember(int memberID){
        Predicate<User> userPredicate = user -> user.getId() == memberID;
        return LoadAllUsers().stream().map(user -> {
            if (userPredicate.test(user)){
                user.setActive(false);
            }
            return user;
        }).collect(Collectors.toList());
    }

}
