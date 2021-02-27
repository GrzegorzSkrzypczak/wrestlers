package pl.grzegorz.wrestlers.app;

import pl.grzegorz.wrestlers.exceptions.*;
import pl.grzegorz.wrestlers.io.ConsolePrinter;
import pl.grzegorz.wrestlers.io.DataReader;
import pl.grzegorz.wrestlers.io.file.FileMenager;
import pl.grzegorz.wrestlers.io.file.FileMenagerBuilder;
import pl.grzegorz.wrestlers.model.*;

import java.util.InputMismatchException;

public class WrestlersController {

    private final ConsolePrinter printer = new ConsolePrinter();
    private final DataReader dataReader = new DataReader(printer);
    private WrestlersLibrary wrestlersLibrary;
    private FileMenager fileMenager;

    WrestlersController() {
        fileMenager = new FileMenagerBuilder(printer, dataReader).build();
        try {
            wrestlersLibrary = fileMenager.importData();
            printer.printLine("Zaimportowano dane z pliku.");
        } catch (DataImportException | InvalidDataException e) {
            printer.printLine(e.getMessage());
            printer.printLine("Zainicjowano nową bazę!");
            wrestlersLibrary = new WrestlersLibrary();
        }
    }

     void control() {
        Options option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_WRESTLER:
                    addWrestler();
                    break;
                case ADD_REFEREE:
                    addReferee();
                    break;
                case PRINT_WRESTLER:
                    printWrestlers();
                    break;
                case PRINT_REFEREE:
                    printReferees();
                    break;
                case DELATE_WRESTLER:
                    delateWrestler();
                    break;
                case DELATE_REFEREE:
                    delateReferee();
                    break;
                case EXIT:
                    exit();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case PRINT_USERS:
                    printUsers();
                    break;
                default:
                    printer.printLine("Nie ma takiej opcji, wybierz ponownie!");
            }
        } while (option != Options.EXIT);
    }

    private void addUser() {
        LibraryUser user = dataReader.createUser();
        try {
            wrestlersLibrary.addUser(user);
        } catch (UserAllreadyExistsException e) {
            printer.printLine(e.getMessage());
        }
    }

    public void printUsers(){
        printer.printUsers(wrestlersLibrary.getUsers().values());

    }

    private Options getOption() {
        boolean optionOk = false;
        Options options = null;

        while (!optionOk) {
            try {
                options = Options.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzono wartość która nie jest liczbą, podaj liczbę: ");
            }
        }
        return options;
    }

    private void printOptions() {
        printer.printLine("Wybierz opcję: ");
        for (Options option : Options.values()) {
            printer.printLine(option.toString());
        }
    }

    private void addWrestler() {
        try {
            Wrestlers wrestler = dataReader.readAndCreateWrestler();
            wrestlersLibrary.addEmployees(wrestler);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się dodać wrestlera, spróbuj ponownie!");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Brak miejsca na zapis wrestlera!");
        }
    }

    private void delateWrestler() {
        try {
        Wrestlers wrestlers = dataReader.readAndCreateWrestler();
        if(wrestlersLibrary.removeEmployee(wrestlers))
            printer.printLine("Usunięto wrestlera");
        else
            printer.printLine("Brak takiego wrestlera!");
        } catch(InputMismatchException e) {
            printer.printLine("Nie udało się usunąć wrestlera, niepoprawne dane!");
        }
    }

    private void addReferee() {
        try {
            Referees referees = dataReader.readAndCreateReferees();
            wrestlersLibrary.addEmployees(referees);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się dodać sędziego, spróbuj ponownie!");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Brak miejsca na zapis sędziego!");
        }
    }

    private void delateReferee() {
        try {
            Referees referees = dataReader.readAndCreateReferees();
            if (wrestlersLibrary.removeEmployee(referees))
                printer.printLine("Usunięto sędziego");
            else
                printer.printLine("Brak takiego sędziego!");
        } catch(InputMismatchException e) {
            printer.printLine("Nie udało się usunąć sędziego, niepoprawne dane!");
        }
    }

    private void printWrestlers() {
        printer.printWrestlers(wrestlersLibrary.getCompany().values());
    }

    private void printReferees() {
        printer.printReferee(wrestlersLibrary.getCompany().values());
    }


    private void exit() {
        try {
            fileMenager.exportData(wrestlersLibrary);
            printer.printLine("Export danych do pliku zakończony powodzeniem.");
        } catch (DataExportException e) {
            printer.printLine(e.getMessage());
        }
        printer.printLine("Koniec programu.");
        dataReader.close();
    }

    private enum Options {

        EXIT(0, "Wyjście z programu"),
        ADD_WRESTLER(1, "Dodaj wrestlera"),
        ADD_REFEREE(2, "Dodaj sędziego"),
        PRINT_WRESTLER(3, "Wyświetl wrestlerów"),
        PRINT_REFEREE(4, "WYświetl sędziów"),
        DELATE_WRESTLER(5, "Usuń Wrestlera"),
        DELATE_REFEREE(6, "Usuń sędziego"),
        ADD_USER(7,"Dodaj użytkownika"),
        PRINT_USERS(8,"Wyświetl użytkowników");

        private int value;
        private String description;

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        Options() {
        }

        Options(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Options createFromInt(int option) throws NoSuchOptionException {
            try {
                return Options.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id " + option);
            }

        }
    }

}


