package pl.grzegorz.wrestlers.app;

import pl.grzegorz.wrestlers.io.DataReader;
import pl.grzegorz.wrestlers.model.Wrestlers;
import pl.grzegorz.wrestlers.model.WrestlersLibrary;

public class WrestlersController {
    private static final int EXIT = 0;
    private static final int ADD_WRESTLER = 1;
    private static final int PRINT_WRESTLERS = 2;

    private final DataReader dataReader = new DataReader();
    private final WrestlersLibrary wrestlersLibrary = new WrestlersLibrary();

    public void control() {
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case ADD_WRESTLER:
                    addWrestler();
                    break;
                case PRINT_WRESTLERS:
                    printWrestlers();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Nie ma takiej opcji, wybierz ponownie!");
            }
        } while (option != EXIT);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        System.out.println(EXIT + " - Wyjście z programu.");
        System.out.println(ADD_WRESTLER + " - Dodaj wrestlera.");
        System.out.println(PRINT_WRESTLERS + " - Wyświetl wrestlerów.");
    }

    private void addWrestler() {
        Wrestlers wrestlerr = dataReader.readAndCreateWrestler();
        wrestlersLibrary.addWrestler(wrestlerr);
    }

    private void printWrestlers() {
        wrestlersLibrary.printWrestlers();
    }

    private void exit() {
        System.out.println("Koniec programu.");
        dataReader.close();
    }


}
