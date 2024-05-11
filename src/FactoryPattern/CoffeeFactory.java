package FactoryPattern;

// normal coffee factory
public class CoffeeFactory {

    public Coffee GetCoffeeType(String coffeeType){
        return switch (coffeeType) {
            case "Robusta" -> new RobustaCoffee();
            case "Espresso" -> new EspressoCoffee();
            default -> new EspressoCoffee();
        };
    }

}
