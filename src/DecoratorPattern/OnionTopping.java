package DecoratorPattern;

public class OnionTopping extends Toppings {
    public OnionTopping(Pizza pizza) {
        super("Onion", 12, pizza);
    }
}
