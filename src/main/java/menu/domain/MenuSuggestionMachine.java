package menu.domain;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.strategy.ListShuffleStrategy;

public class MenuSuggestionMachine {
    public Menu suggestion(List<Menu> menus, Coach coach, ListShuffleStrategy listShuffleStrategy) {
        Menu menu;
        do {
            List<String> collect = menus.stream().map(Menu::name).collect(Collectors.toList());
            String menuName = listShuffleStrategy.shuffle(collect).get(0);
            menu = new Menu(menuName);
        } while (!coach.isEatMenu(menu));
        return menu;
    }
}
