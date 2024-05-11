package FactoryPattern;

public class CoffeeServer {

    private final AbstractCoffeeFactory abstractCoffeeFactory;

    public CoffeeServer(AbstractCoffeeFactory abstractCoffeeFactory) {
        this.abstractCoffeeFactory = abstractCoffeeFactory;
    }

    // normal factory pattern
    public Coffee Serve(String coffeeType){
        Coffee coffee = new CoffeeFactory().GetCoffeeType(coffeeType);
        coffee.brew();
        coffee.brew();
        return coffee;
    }

    public Coffee ServeV2(String coffeeType){
        Coffee coffee = this.abstractCoffeeFactory.GetCoffeeType(coffeeType);
        coffee.brew();
        coffee.brew();
        return coffee;
    }

}
