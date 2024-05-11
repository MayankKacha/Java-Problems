package FactoryPattern;

public class CoffeeFactoryV2 implements AbstractCoffeeFactory{
    @Override
    public Coffee GetCoffeeType(String coffeeType) {
        return switch (coffeeType) {
            case "Robusta" -> new RobustaCoffee();
            case "Espresso" -> new EspressoCoffee();
            default -> new EspressoCoffee();
        };
    }
}
