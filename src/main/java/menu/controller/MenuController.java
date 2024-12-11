package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.view.OutputView;

public class MenuController {
    private final IteratorInputHandler iteratorInputHandler;
    private final OutputView outputView;

    public MenuController(IteratorInputHandler iteratorInputHandler, OutputView outputView) {
        this.iteratorInputHandler = iteratorInputHandler;
        this.outputView = outputView;
    }

    public void process() {
        outputView.printStartMessage();
        List<Coach> coaches = iteratorInputHandler.inputCoaches();
        for (Coach coach : coaches) {
            List<Menu> menus = iteratorInputHandler.inputNoEatMenu(coach.getName());
            coach.settingNoEatMenus(menus);
        }
    }
}
