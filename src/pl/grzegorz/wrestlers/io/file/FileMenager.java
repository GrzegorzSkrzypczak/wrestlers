package pl.grzegorz.wrestlers.io.file;

import pl.grzegorz.wrestlers.model.WrestlersLibrary;

public interface FileMenager {
    WrestlersLibrary importData();
    void exportData (WrestlersLibrary wrestlersLibrary);
}
