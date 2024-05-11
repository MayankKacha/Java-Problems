package SystemDesign;

public class Main {
    public static void main(String[] args) {
        Students students = new Students("test",10);
        Students students1 = new Students(students.email, students.age);
        students1.age = 200;
        System.out.println(students.age +" " + students1.age);
    }
}

class Students{
    public String email;
    public int age;
    public Students(String email, int age) {
        this.email = email;
        this.age = age;
    }
}
