package by.smirnov.view;

import by.smirnov.actions.*;
import by.smirnov.listeners.TextEditMenuListener;
import by.smirnov.listeners.UndoMenuListener;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionListener;

import static by.smirnov.view.ViewConstants.*;

public class MenuHelper {
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(actionListener);
        parent.add(menuItem);
        return menuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem menuItem = addMenuItem(parent, action);
        menuItem.setText(text);
        return menuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem menuItem = new JMenuItem(action);
        parent.add(menuItem);
        return menuItem;
    }

    public static void initHelpMenu(View view, JMenuBar menuBar) {
        JMenu helpMenu = new JMenu(HELP);
        menuBar.add(helpMenu);

        addMenuItem(helpMenu, ABOUT, view);
    }

    public static void initFontMenu(View view, JMenuBar menuBar) {
        JMenu fontMenu = new JMenu(FONT);
        menuBar.add(fontMenu);

        JMenu fontTypeMenu = new JMenu(FONT);
        fontMenu.add(fontTypeMenu);

        for (String fontType : FONT_TYPES) {
            addMenuItem(fontTypeMenu, fontType, new StyledEditorKit.FontFamilyAction(fontType, fontType));
        }

        JMenu fontSizeMenu = new JMenu(FONT_SIZE);
        fontMenu.add(fontSizeMenu);

        for (String fontSize : FONT_SIZES) {
            addMenuItem(fontSizeMenu, fontSize, new StyledEditorKit.FontSizeAction(fontSize, Integer.parseInt(fontSize)));
        }

        fontMenu.addMenuListener(new TextEditMenuListener(view));
    }

    public static void initColorMenu(View view, JMenuBar menuBar) {
        JMenu colorMenu = new JMenu(COLOR);
        menuBar.add(colorMenu);

        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction(RED, Color.red));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction(ORANGE, Color.orange));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction(YELLOW, Color.yellow));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction(GREEN, Color.green));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction(BLUE, Color.blue));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction(CYAN, Color.cyan));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction(MAGENTA, Color.magenta));
        addMenuItem(colorMenu, new StyledEditorKit.ForegroundAction(BLACK, Color.black));

        colorMenu.addMenuListener(new TextEditMenuListener(view));
    }

    public static void initAlignMenu(View view, JMenuBar menuBar) {
        JMenu alignMenu = new JMenu("Выравнивание");
        menuBar.add(alignMenu);

        addMenuItem(alignMenu, new StyledEditorKit.AlignmentAction("По левому краю", StyleConstants.ALIGN_LEFT));
        addMenuItem(alignMenu, new StyledEditorKit.AlignmentAction("По центру", StyleConstants.ALIGN_CENTER));
        addMenuItem(alignMenu, new StyledEditorKit.AlignmentAction("По правому краю", StyleConstants.ALIGN_RIGHT));

        alignMenu.addMenuListener(new TextEditMenuListener(view));
    }

    public static void initStyleMenu(View view, JMenuBar menuBar) {
        JMenu styleMenu = new JMenu("Стиль");
        menuBar.add(styleMenu);

        addMenuItem(styleMenu, "Полужирный", new StyledEditorKit.BoldAction());
        addMenuItem(styleMenu, "Подчеркнутый", new StyledEditorKit.UnderlineAction());
        addMenuItem(styleMenu, "Курсив", new StyledEditorKit.ItalicAction());

        styleMenu.addSeparator();

        addMenuItem(styleMenu, "Подстрочный знак", new SubscriptAction());
        addMenuItem(styleMenu, "Надстрочный знак", new SuperscriptAction());
        addMenuItem(styleMenu, "Зачеркнутый", new StrikeThroughAction());

        styleMenu.addMenuListener(new TextEditMenuListener(view));
    }

    public static void initEditMenu(View view, JMenuBar menuBar) {
        JMenu editMenu = new JMenu(EDIT);
        menuBar.add(editMenu);

        JMenuItem undoItem = addMenuItem(editMenu, UNDO, new UndoAction(view));
        JMenuItem redoItem = addMenuItem(editMenu, REDO, new RedoAction(view));
        addMenuItem(editMenu, CUT, new DefaultEditorKit.CutAction());
        addMenuItem(editMenu, COPY, new DefaultEditorKit.CopyAction());
        addMenuItem(editMenu, PASTE, new DefaultEditorKit.PasteAction());

        editMenu.addMenuListener(new UndoMenuListener(view, undoItem, redoItem));
    }

    public static void initFileMenu(View view, JMenuBar menuBar) {
        JMenu fileMenu = new JMenu(FILE);
        menuBar.add(fileMenu);

        addMenuItem(fileMenu, NEW, view);
        addMenuItem(fileMenu, OPEN, view);
        addMenuItem(fileMenu, SAVE, view);
        addMenuItem(fileMenu, SAVE_AS, view);
        fileMenu.addSeparator();
        addMenuItem(fileMenu, EXIT, view);
    }
}
