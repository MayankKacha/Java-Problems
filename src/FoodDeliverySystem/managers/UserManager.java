package FoodDeliverySystem.managers;

import FoodDeliverySystem.datalayer.UsersDB;
import FoodDeliverySystem.models.User;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class UserManager {
    private UsersDB usersDB = new UsersDB();
    public User GetUserByID(int id){
        List<User> users = usersDB.GetAllFoodItems().stream().filter(x -> x.getId() == id).toList();
        return users.get(0);
    }

    public User GetUserByToken(String token){
        List<User> users = usersDB.GetAllFoodItems().stream().filter(x -> Objects.equals(x.getAuthToken(), token)).toList();
        return users.get(0);
    }

}
