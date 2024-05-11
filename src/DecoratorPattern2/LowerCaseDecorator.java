package DecoratorPattern2;

public class LowerCaseDecorator extends Decorator{
    public LowerCaseDecorator(Writer writer) {
        super(writer);
    }

    @Override
    public void write(String txt) {
        txt = txt.toLowerCase();
        super.write(txt);
    }
}
