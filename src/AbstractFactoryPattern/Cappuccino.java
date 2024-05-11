package AbstractFactoryPattern;

public class Cappuccino extends Coffee{
    public Cappuccino(IngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    void brew() {
        return;
    }

    @Override
    void boil() {
        return;
    }
}
