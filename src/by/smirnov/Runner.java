package by.smirnov;

import by.smirnov.controller.Controller;
import by.smirnov.view.View;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }
}
