package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_COACH_NAME = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public String inputCoach() {
        System.out.println(INPUT_COACH_NAME);
        return Console.readLine();
    }
}
