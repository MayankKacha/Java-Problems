package FactoryPattern;

public interface AbstractCoffeeFactory {
    Coffee GetCoffeeType(String coffeeType);
}
