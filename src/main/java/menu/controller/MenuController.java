package menu.controller;

import static menu.domain.Day.FRI;
import static menu.domain.Day.MON;
import static menu.domain.Day.THU;
import static menu.domain.Day.TUE;
import static menu.domain.Day.WED;

import java.util.LinkedHashMap;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Lunch;
import menu.domain.Menu;
import menu.domain.MenuSuggestionMachine;
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

        Lunch lunch = new Lunch(new MenuSuggestionMachine(), coaches, new LinkedHashMap<>());
        lunch.eat(List.of(MON, TUE, WED, THU, FRI));
        outputView.printLunchMenus(lunch);
    }
}
