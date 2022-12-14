package by.smirnov.listeners;

import by.smirnov.view.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class UndoMenuListener implements MenuListener {

    private final View view;
    private final JMenuItem undoMenuItem;
    private final JMenuItem redoMenuItem;

    @Override
    public void menuSelected(MenuEvent menuEvent) {
        if (view.canUndo()) undoMenuItem.setEnabled(true);
        else undoMenuItem.setEnabled(false);
        if (view.canRedo()) redoMenuItem.setEnabled(true);
        else redoMenuItem.setEnabled(false);
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }
}
