package by.smirnov.filter;

import javax.swing.filechooser.FileFilter;
import java.io.File;

import static by.smirnov.view.ViewConstants.*;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File file) {
        return file.isDirectory() || file.getName().toLowerCase().endsWith(HTML_EXT)
                || file.getName().toLowerCase().endsWith(HTM_EXT);
    }

    @Override
    public String getDescription() {
        return FILTER_DESCRIPTION;
    }
}
