package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MenuSuggestionMachine {
    public Menu suggestion(List<Menu> menus, Coach coach) {
        Menu menu;
        do {
            menu = Randoms.shuffle(menus).get(0);
        } while (!coach.isEatMenu(menu));
        return menu;
    }
}
