package DecoratorPattern2;

public class FileWriter implements Writer{
    @Override
    public void write(String txt) {
        System.out.println("From File!");
    }
}
