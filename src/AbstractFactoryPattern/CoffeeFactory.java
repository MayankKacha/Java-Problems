package AbstractFactoryPattern;

public class CoffeeFactory {
    public Coffee Serve(String coffeeType){
        Coffee coffee;
        if (coffeeType.equals("Espresso")){
            return new Cappuccino(new CappuccinoIngredientFactory());
        }
        return null;
    }
}
