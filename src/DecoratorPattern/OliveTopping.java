package DecoratorPattern;

public class OliveTopping extends Toppings{
    public OliveTopping(Pizza pizza) {
        super("Olive", 12, pizza);
    }
}
