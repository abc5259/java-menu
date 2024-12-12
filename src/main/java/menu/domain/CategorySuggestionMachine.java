package menu.domain;

import java.util.Map;
import menu.domain.strategy.NumberPickInRangeStrategy;

public class CategorySuggestionMachine {

    private static final int MAX_EAT_CATEGORY = 2;

    public Category suggestion(Map<Category, Long> eatCategoryInfos,
                               NumberPickInRangeStrategy numberPickInRangeStrategy) {
        Category category;
        do {
            category = Category.findBySymbol(numberPickInRangeStrategy.pickNumberInRange(1, 5));
        } while (eatCategoryInfos.getOrDefault(category, 0L) >= MAX_EAT_CATEGORY);

        return category;
    }
}
