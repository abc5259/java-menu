package menu;

import menu.controller.MenuController;

public class Application {
    public static void main(String[] args) {
        MenuConfig menuConfig = new MenuConfig();
        MenuController menuController = menuConfig.menuController();
        menuController.process();
    }
}
