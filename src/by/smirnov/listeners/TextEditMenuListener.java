package by.smirnov.listeners;

import by.smirnov.view.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class TextEditMenuListener implements MenuListener {

    private final View view;
    @Override
    public void menuSelected(MenuEvent menuEvent) {
        JMenu jMenu = (JMenu) menuEvent.getSource();
        Component[] components = jMenu.getMenuComponents();
        for (Component component : components) {
            component.setEnabled(view.isHtmlTabSelected());
        }
    }

    @Override
    public void menuDeselected(MenuEvent menuEvent) {

    }

    @Override
    public void menuCanceled(MenuEvent menuEvent) {

    }

    public TextEditMenuListener(View view) {
        this.view = view;
    }
}
