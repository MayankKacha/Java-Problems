package DecoratorPattern2;

public class tester {

    public static void main(String[] args) {
        Writer writer = new LowerCaseDecorator(new UpperCaseDecorator(new ConsoleWriter()));
        writer.write("HIII my name is Mayank");
    }


}
