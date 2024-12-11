package menu.view;

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
}
