package NumberStore_StrategyPattern;

public class NumberStoreTest {

    public static void main(String[] args) {
        NumberStore numberStore = new NumberStore(InsertStrategy.INORDERED, SearchStrategy.BINARY);

    }

}
