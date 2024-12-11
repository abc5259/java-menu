package menu.controller;

import java.util.List;
import menu.converter.StringToCoachesConverter;
import menu.domain.Coach;
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

}
