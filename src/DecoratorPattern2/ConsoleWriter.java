package DecoratorPattern2;

public class ConsoleWriter implements Writer{
    @Override
    public void write(String txt) {
        System.out.println("From Console " + txt);
    }
}
