package by.smirnov.listeners;

import by.smirnov.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameListener extends WindowAdapter {

    private View view;

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        view.exit();
    }

    public FrameListener(View view) {
        this.view = view;
    }
}
