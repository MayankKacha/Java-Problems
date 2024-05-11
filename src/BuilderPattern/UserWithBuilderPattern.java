package BuilderPattern;

public class UserWithBuilderPattern {

    private final int id;
    private final String name;
    private final String phoneNumber;
    private final int age;

    private UserWithBuilderPattern(Builder userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.phoneNumber =userBuilder.phoneNumber;
        this.age = userBuilder.age;
    }


    // here even if properties are not final it doesnt care as main objects will be final
    // why static -> we will be able to create builder without creating instance of User class as User.Builder
    public static class Builder{
        private int id;
        private final String name;
        private String phoneNumber;
        private int age;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
            this.phoneNumber = "";
            this.age = 0;
        }

        public void setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        // this will help us in creating user class instance like User.Builder(params).build();
        public UserWithBuilderPattern build(){
            return new UserWithBuilderPattern(this);
        }

    }

    // above class can be called as new User.Builder and then after creating object we will be able to set parameters line by line if we want to have chaining then we can
    // return object like setAge and setName, which we will be able to user like new User.Builder(0,"Mayank").setAge(25).setName("XYZ"); etc.

    // we can have build method inside Builder class which will be called to get instance of User class.
}
