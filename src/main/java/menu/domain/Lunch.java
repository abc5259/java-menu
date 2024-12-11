package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Lunch {

    private final MenuSuggestionMachine menuSuggestionMachine;
    private final List<Coach> coaches;
    private final Map<Day, Category> eatCategoryInfos;

    public Lunch(MenuSuggestionMachine menuSuggestionMachine,
                 List<Coach> coaches,
                 Map<Day, Category> eatCategoryInfos) {
        this.menuSuggestionMachine = menuSuggestionMachine;
        this.coaches = coaches;
        this.eatCategoryInfos = eatCategoryInfos;
    }

    public void eat(List<Day> days) {
        for (Day day : days) {
            Category category;
            do {
                category = Category.findBySymbol(Randoms.pickNumberInRange(1, 5));
            } while (categoryCount(category) >= 2);
            eatCategoryInfos.put(day, category);

            for (Coach coach : coaches) {
                Menu suggestionMenu = menuSuggestionMachine.suggestion(category.getMenus(), coach);
                coach.eat(day, suggestionMenu);
            }
        }
    }

    private int categoryCount(Category category) {
        return (int) eatCategoryInfos.values().stream()
                .filter(currCategory -> currCategory == category)
                .count();
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

    public Map<Day, Category> getEatCategoryInfos() {
        return Collections.unmodifiableMap(eatCategoryInfos);
    }
}
