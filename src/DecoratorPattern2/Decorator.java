package DecoratorPattern2;

public class Decorator implements Writer{
    private final Writer writer;
    public Decorator(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void write(String txt) {
        writer.write(txt);
    }
}
