package menu.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.strategy.ListShuffleStrategy;
import menu.domain.strategy.NumberPickInRangeStrategy;

public class Lunch {

    private final MenuSuggestionMachine menuSuggestionMachine;
    private final CategorySuggestionMachine categorySuggestionMachine;
    private final List<Coach> coaches;
    private final Map<Day, Category> eatCategoryInfos;

    public Lunch(MenuSuggestionMachine menuSuggestionMachine,
                 CategorySuggestionMachine categorySuggestionMachine,
                 List<Coach> coaches,
                 Map<Day, Category> eatCategoryInfos) {
        this.menuSuggestionMachine = menuSuggestionMachine;
        this.categorySuggestionMachine = categorySuggestionMachine;
        this.coaches = coaches;
        this.eatCategoryInfos = eatCategoryInfos;
    }

    public void eat(List<Day> days,
                    NumberPickInRangeStrategy numberPickInRangeStrategy,
                    ListShuffleStrategy listShuffleStrategy) {
        for (Day day : days) {
            Category category = categorySuggestionMachine.suggestion(getterCategoryInfos(), numberPickInRangeStrategy);
            eatCategoryInfos.put(day, category);

            for (Coach coach : coaches) {
                Menu suggestionMenu = menuSuggestionMachine.suggestion(category.getMenus(), coach, listShuffleStrategy);
                coach.eat(day, suggestionMenu);
            }
        }
    }

    public List<Coach> getCoaches() {
        return Collections.unmodifiableList(coaches);
    }

    public Map<Day, Category> getEatCategoryInfos() {
        return Collections.unmodifiableMap(eatCategoryInfos);
    }

    private Map<Category, Long> getterCategoryInfos() {
        return eatCategoryInfos.values().stream()
                .collect(Collectors.groupingBy((category) -> category, Collectors.counting()));
    }
}
