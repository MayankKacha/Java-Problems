package DecoratorPattern2;

public class UpperCaseDecorator extends Decorator{
    public UpperCaseDecorator(Writer writer) {
        super(writer);
    }

    @Override
    public void write(String txt) {
        txt = txt.toUpperCase();
        super.write(txt);
    }


}
