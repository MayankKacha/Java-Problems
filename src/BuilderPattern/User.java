package BuilderPattern;

// here the disadvantages are if some of the parameters are optional, we will not be able to initialise User class without passing null or empty or garbage value
// we can try constructor loading  -> multiple overloading we have to do
// we can have setters but problem -> we wont be able to keep in final and final is needed to keep object immutable
public class User {

    private final int id;
    private final String name;
    private final String phoneNumber;
    private final int age;

    public User(int id, String name, String phoneNumber, int age) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
}
