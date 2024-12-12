package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class CategorySuggestionMachine {

    private static final int MAX_EAT_CATEGORY = 2;

    public Category suggestion(Map<Category, Long> eatCategoryInfos) {
        Category category;
        do {
            category = Category.findBySymbol(Randoms.pickNumberInRange(1, 5));
        } while (eatCategoryInfos.getOrDefault(category, 0L) >= MAX_EAT_CATEGORY);

        return category;
    }
}
