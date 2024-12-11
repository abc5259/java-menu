package menu.controller;

import java.util.List;
import menu.converter.StringToCoachesConverter;
import menu.converter.StringToMenusConverter;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.view.InputView;

public class IteratorInputHandler {

    private final InputView inputView;
    private final IteratorInputTemplate iteratorInputTemplate;

    public IteratorInputHandler(InputView inputView, IteratorInputTemplate iteratorInputTemplate) {
        this.inputView = inputView;
        this.iteratorInputTemplate = iteratorInputTemplate;
    }

    public List<Coach> inputCoaches() {
        return iteratorInputTemplate.execute(
                inputView::inputCoach,
                new StringToCoachesConverter()
        );
    }

    public List<Menu> inputNoEatMenu(String coachName) {
        return iteratorInputTemplate.execute(
                () -> inputView.inputNoEatMenuName(coachName),
                new StringToMenusConverter()
        );
    }
}
