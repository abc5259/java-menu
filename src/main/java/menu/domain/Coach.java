package menu.domain;

import java.util.List;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;

    private final String name;
    private List<Menu> noEatMenus;

    public Coach(String name) {
        validateName(name);
        this.name = name.trim();
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
}
