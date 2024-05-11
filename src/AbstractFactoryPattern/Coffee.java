package AbstractFactoryPattern;

public abstract class Coffee {
    private final IngredientFactory ingredientFactory;
    public Coffee(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    abstract void brew();
    abstract void boil();

}
