package AbstractFactoryPattern;

public class CappuccinoIngredientFactory implements IngredientFactory{
    @Override
    public Bean getBean() {
        return new EspressoBeans();
    }

    @Override
    public Milk getMilk() {
        return new CowMilk();
    }

    @Override
    public Sugar getSugar() {
        return null;
    }
}
