package DecoratorPattern;

public class Tester {


    public static void main(String[] args) {
        Pizza pizza = new OliveTopping(new OnionTopping(new WheatBase()));
        System.out.println(pizza.getName() + " " + pizza.getCost());
    }

}
