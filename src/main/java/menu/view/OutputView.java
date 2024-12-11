package menu.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Lunch;
import menu.domain.Menu;

public class OutputView {

    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s%n";
    private static final String MENU_START_MESSAGE = "점심 메뉴 추천을 시작합니다.";

    public void printStartMessage() {
        System.out.println(MENU_START_MESSAGE);
        System.out.println();
    }

    public void printErrorMessage(Exception exception) {
        System.out.printf(ERROR_MESSAGE_FORMAT, exception.getMessage());
    }

    public void printLunchMenus(Lunch lunch) {
        System.out.println("메뉴 추천 결과입니다.");
        String days = Arrays.stream(Day.values()).map(day -> day.getName())
                .collect(Collectors.joining(" | ", "[ 구분 | ", " ]"));

        List<Category> eatCategories = new ArrayList<>();
        for (Day day : Day.values()) {
            eatCategories.add(lunch.getEatCategoryInfos().get(day));
        }
        String categoryMessage = eatCategories.stream().map(Category::getName)
                .collect(Collectors.joining(" | ", "[ 카테고리 | ", " ]"));

        System.out.println(days);
        System.out.println(categoryMessage);

        List<Coach> coaches = lunch.getCoaches();
        for (Coach coach : coaches) {
            List<Menu> eatMenus = new ArrayList<>();
            for (Day day : Day.values()) {
                eatMenus.add(coach.getDayMenu(day));
            }
            String coachMenus = eatMenus.stream().map(Menu::name)
                    .collect(Collectors.joining(" | ", "[ " + coach.getName() + " | ", " ]"));
            System.out.println(coachMenus);
        }

        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
