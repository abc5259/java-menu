package menu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;
    private List<Menu> noEatMenus;
    private final Map<Day, Menu> eatMenuInfos;

    public Coach(String name) {
        this(name, new HashMap<>());
    }

    public Coach(String name, Map<Day, Menu> eatMenuInfos) {
        validateName(name);
        this.name = name.trim();
        this.eatMenuInfos = eatMenuInfos;
    }

    public void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        int length = name.trim().length();
        if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("코치의 이름은 " + MIN_NAME_LENGTH + "이상 " + MAX_NAME_LENGTH + "이하여야 합니다.");
        }
    }

    public void settingNoEatMenus(List<Menu> menus) {
        this.noEatMenus = menus;
    }

    public String getName() {
        return name;
    }

    public boolean canEatMenu(Menu menu) {
        return !noEatMenus.contains(menu) && !eatMenuInfos.containsValue(menu);
    }

    public void eat(Day day, Menu suggestionMenu) {
        eatMenuInfos.put(day, suggestionMenu);
    }

    public Menu getDayMenu(Day day) {
        return eatMenuInfos.get(day);
    }
}
