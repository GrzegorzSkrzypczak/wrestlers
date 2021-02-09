package pl.grzegorz.wrestlers.app;

import pl.grzegorz.wrestlers.exceptions.NoSuchOptionException;
import pl.grzegorz.wrestlers.io.ConsolePrinter;
import pl.grzegorz.wrestlers.io.DataReader;
import pl.grzegorz.wrestlers.model.Company;
import pl.grzegorz.wrestlers.model.Referees;
import pl.grzegorz.wrestlers.model.Wrestlers;
import pl.grzegorz.wrestlers.model.WrestlersLibrary;

import java.util.InputMismatchException;

public class WrestlersController {

    private ConsolePrinter printer = new ConsolePrinter();
    private final DataReader dataReader = new DataReader(printer);
    private final WrestlersLibrary wrestlersLibrary = new WrestlersLibrary();


    public void control() {
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
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("Nie ma takiej opcji, wybierz ponownie!");
            }
        } while (option != Options.EXIT);
    }

    private Options getOption() {
        boolean optionOk = false;
        Options options = null;

        while (!optionOk){
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
        for(Options option: Options.values()){
            printer.printLine(option.toString());
        }
    }

    private void addWrestler() {
        try {
            Wrestlers wrestler = dataReader.readAndCreateWrestler();
            wrestlersLibrary.addWrestler(wrestler);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się dodać wrestlera, spróbuj ponownie!");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Brak miejsca na zapis wrestlera!");
        }
    }

    private void addReferee() {
        try {
            Referees referees = dataReader.readAndCreateReferees();
            wrestlersLibrary.addReferee(referees);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się dodać sędziego, spróbuj ponownie!");
        }  catch (ArrayIndexOutOfBoundsException e) {
        printer.printLine("Brak miejsca na zapis sędziego!");
    }

    }

    private void printWrestlers() {
        Company[] wrestlers = wrestlersLibrary.getCompany();
        printer.printWrestlers(wrestlers);
    }

    private void printReferees() {
        Company[] referees = wrestlersLibrary.getCompany();
        printer.printReferee(referees);
    }

    private void exit() {
        printer.printLine("Koniec programu.");
        dataReader.close();
    }

}
