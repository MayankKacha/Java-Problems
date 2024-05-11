package AbstractFactoryPattern;

public interface IngredientFactory {
    Bean getBean();
    Milk getMilk();
    Sugar getSugar();
}
