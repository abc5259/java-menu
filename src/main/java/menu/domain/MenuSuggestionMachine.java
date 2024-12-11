package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class MenuSuggestionMachine {
    public Menu suggestion(List<Menu> menus, Coach coach) {
        Menu menu;
        do {
            List<String> collect = menus.stream().map(menu1 -> menu1.name()).collect(Collectors.toList());
            String menuName = Randoms.shuffle(collect).get(0);
            menu = new Menu(menuName);
        } while (!coach.isEatMenu(menu));
        return menu;
    }
}
