package by.smirnov.listeners;

import by.smirnov.view.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameListener extends WindowAdapter {

    private final View view;

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        view.exit();
    }

    public FrameListener(View view) {
        this.view = view;
    }
}
