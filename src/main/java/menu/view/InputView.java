package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_NO_EAT_MENU_NAME_FORMAT = "%s(이)가 못 먹는 메뉴를 입력해 주세요.%n";

    public String inputCoach() {
        System.out.println(INPUT_COACH_NAME);
        return Console.readLine();
    }

    public String inputNoEatMenuName(String coachName) {
        System.out.println();
        System.out.printf(INPUT_NO_EAT_MENU_NAME_FORMAT, coachName);
        return Console.readLine();
    }
}
