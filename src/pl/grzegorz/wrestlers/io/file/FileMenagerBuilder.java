package pl.grzegorz.wrestlers.io.file;

import pl.grzegorz.wrestlers.exceptions.NoSuchFileTypeException;
import pl.grzegorz.wrestlers.io.ConsolePrinter;
import pl.grzegorz.wrestlers.io.DataReader;

public class FileMenagerBuilder {
    private ConsolePrinter printer;
    private DataReader dataReader;

    public FileMenagerBuilder(ConsolePrinter printer, DataReader dataReader) {
        this.printer = printer;
        this.dataReader = dataReader;
    }

    public FileMenager build() {
        printer.printLine("Wybierz format danych: ");
        FileType fileType = getFileType();

        switch (fileType){
            case SERIAL:
                return new SerializableFileMenager();
            case CSV:
                return new CsvFileMenager();
            default:
                throw new NoSuchFileTypeException("Nie obsługiwany format danych!");
        }
    }

    private FileType getFileType() {
        boolean typeOK = false;
        FileType result = null;

        do {
            printTypes();
            String type = dataReader.getString().toUpperCase();
            try {
                result = FileType.valueOf(type);
                typeOK = true;
            } catch (IllegalArgumentException e) {
                printer.printLine("Nie obsługiwany typ danych, spróbuj ponownie!");
            }

        } while (!typeOK);
        return result;
    }

    private void printTypes() {
        for (FileType value : FileType.values()) {
            printer.printLine(value.name());
        }
    }
}
