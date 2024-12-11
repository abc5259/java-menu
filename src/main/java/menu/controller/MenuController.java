package menu.controller;

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
    }
}
