package pl.grzegorz.wrestlers.app;

import pl.grzegorz.wrestlers.io.DataReader;
import pl.grzegorz.wrestlers.model.Referees;
import pl.grzegorz.wrestlers.model.Wrestlers;
import pl.grzegorz.wrestlers.model.WrestlersLibrary;

public class WrestlersController {

    private final DataReader dataReader = new DataReader();
    private final WrestlersLibrary wrestlersLibrary = new WrestlersLibrary();

    public void control() {
        Options option;

        do {
            printOptions();
            option = Options.createFromInt(dataReader.getInt());
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
                    System.out.println("Nie ma takiej opcji, wybierz ponownie!");
            }
        } while (option != Options.EXIT);
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        for(Options option: Options.values()){
            System.out.println(option);
        }
    }

    private void addWrestler() {
        Wrestlers wrestler = dataReader.readAndCreateWrestler();
        wrestlersLibrary.addWrestler(wrestler);
    }

    private void addReferee() {
        Referees referees = dataReader.readAndCreateReferees();
        wrestlersLibrary.addReferee(referees);

    }

    private void printWrestlers() {
        wrestlersLibrary.printWrestlers();
    }

    private void printReferees() {
        wrestlersLibrary.printReferee();
    }

    private void exit() {
        System.out.println("Koniec programu.");
        dataReader.close();
    }


}
