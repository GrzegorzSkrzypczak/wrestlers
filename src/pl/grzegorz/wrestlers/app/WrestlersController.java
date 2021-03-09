package pl.grzegorz.wrestlers.app;

import pl.grzegorz.wrestlers.exceptions.*;
import pl.grzegorz.wrestlers.io.ConsolePrinter;
import pl.grzegorz.wrestlers.io.DataReader;
import pl.grzegorz.wrestlers.io.file.FileMenager;
import pl.grzegorz.wrestlers.io.file.FileMenagerBuilder;
import pl.grzegorz.wrestlers.model.*;

import java.util.Comparator;
import java.util.InputMismatchException;

public class WrestlersController {

    private final ConsolePrinter printer = new ConsolePrinter();
    private final DataReader dataReader = new DataReader(printer);
    private WrestlersLibrary wrestlersLibrary;
    private final FileMenager fileMenager;

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
                case ADD_MALE_WRESTLER:
                    addMaleWrestler();
                    break;
                case ADD_FEMALE_REFEREE:
                    addFemaleReferee();
                    break;
                case PRINT_MALE_WRESTLER:
                    printMaleWrestlers();
                    break;
                case PRINT_FEMALE_REFEREE:
                    printFemaleWrestlers();
                    break;
                case DELATE_MALE_WRESTLER:
                    delateMaleWrestler();
                    break;
                case DELATE_FEMALE_WRESTLER:
                    delateFemaleWrestler();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case PRINT_USERS:
                    printUsers();
                    break;
                case EXIT:
                    exit();
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
        printer.printUsers(wrestlersLibrary.getSortedLibraryUsers(Comparator.comparing(User::getLastName)
        , String.CASE_INSENSITIVE_ORDER));
//                .getSortedLibraryUsers((o1, o2) -> o1
//                        .getLastName()
//                        .compareToIgnoreCase(o2.getLastName())));

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

    private void addMaleWrestler() {
        try {
            MaleWrestlers wrestler = dataReader.readAndCreateMaleWrestler();
            wrestlersLibrary.addWrestlers(wrestler);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się dodać wrestlera, spróbuj ponownie!");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Brak miejsca na zapis wrestlera!");
        }
    }

    private void delateMaleWrestler() {
        try {
        MaleWrestlers wrestlers = dataReader.readAndCreateMaleWrestler();
        if(wrestlersLibrary.removeWrestler(wrestlers))
            printer.printLine("Usunięto wrestlera");
        else
            printer.printLine("Brak takiego wrestlera!");
        } catch(InputMismatchException e) {
            printer.printLine("Nie udało się usunąć wrestlera, niepoprawne dane!");
        }
    }

    private void addFemaleReferee() {
        try {
            FemaleWrestlers referees = dataReader.readAndCreateFemaleWrestler();
            wrestlersLibrary.addWrestlers(referees);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się dodać wrestlerki, spróbuj ponownie!");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Brak miejsca na zapis wrestlerki!");
        }
    }

    private void delateFemaleWrestler() {
        try {
            FemaleWrestlers referees = dataReader.readAndCreateFemaleWrestler();
            if (wrestlersLibrary.removeWrestler(referees))
                printer.printLine("Usunięto wrestlerkę");
            else
                printer.printLine("Brak takiej wrestlerki!");
        } catch(InputMismatchException e) {
            printer.printLine("Nie udało się usunąć wrestlerki, niepoprawne dane!");
        }
    }

    private void printMaleWrestlers() {
        printer.printWrestlers(wrestlersLibrary
                .getSortedOrganizations(Comparator.comparing(Organization::getOrganizationFullName
                        , String.CASE_INSENSITIVE_ORDER)));
    }

    private void printFemaleWrestlers() {
        printer.printReferee(wrestlersLibrary
                .getSortedOrganizations(Comparator.comparing(Organization::getOrganizationFullName
        , String.CASE_INSENSITIVE_ORDER)));
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

        ADD_MALE_WRESTLER(0, "Dodaj wrestlera"),
        ADD_FEMALE_REFEREE(1, "Dodaj wrestlerkę"),
        PRINT_MALE_WRESTLER(2, "Wyświetl wrestlerów"),
        PRINT_FEMALE_REFEREE(3, "WYświetl wrestlerki"),
        DELATE_MALE_WRESTLER(4, "Usuń wrestlera"),
        DELATE_FEMALE_WRESTLER(5, "Usuń wrestlerkę"),
        ADD_USER(6,"Dodaj użytkownika"),
        PRINT_USERS(7,"Wyświetl użytkowników"),
        EXIT(8, "Wyjście z programu");

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


