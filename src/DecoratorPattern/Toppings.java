package DecoratorPattern;

public abstract class Toppings extends Pizza {
    private final Pizza pizza; // here this pizza will be passed from the extending classes, say OnionToppoing will extend,
    // it will take input as pizza and return that pizza to its super
    public Toppings(String name, double cost, Pizza pizza) {
        super(name, cost);
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return super.getName() + " " + pizza.getName();
    }

    @Override
    public double getCost() {
        return super.getCost() + pizza.getCost();
    }
}
