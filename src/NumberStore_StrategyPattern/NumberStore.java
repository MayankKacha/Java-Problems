package NumberStore_StrategyPattern;

import java.util.ArrayList;
import java.util.List;

public class NumberStore {

    // Here instead of creating enums we can create 2 interfaces and implement it to classes for ordered, unordered insert and same for search
    // and from main test class user can pass any instance of class wanted to be used and in this class we can create wrappers method like simple
    // insert and search and it will call interface methods.
    private final List<Integer> nums;
    private final InsertStrategy insertStrategy;
    private final SearchStrategy searchStrategy;

    public NumberStore(InsertStrategy insertStrategy, SearchStrategy searchStrategy) {
        this.insertStrategy = insertStrategy;
        this.searchStrategy = searchStrategy;
        nums = new ArrayList<>();
    }




}
