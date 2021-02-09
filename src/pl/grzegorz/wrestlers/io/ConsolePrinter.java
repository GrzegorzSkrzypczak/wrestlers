package pl.grzegorz.wrestlers.io;

import pl.grzegorz.wrestlers.model.Company;
import pl.grzegorz.wrestlers.model.Referees;
import pl.grzegorz.wrestlers.model.Wrestlers;

public class ConsolePrinter {

    public void printWrestlers(Company[] printWrestlers) {
        int countWrestlers = 0;
        for (Company wrestlers : printWrestlers) {
            if (wrestlers instanceof Wrestlers) {
                System.out.println(wrestlers);
                countWrestlers++;
            }
        }
        if (countWrestlers == 0) {
            printLine("Brak wrestlerów w bibliotece");
        }
    }

    public void printReferee(Company[] printReferees) {
        int countReferees = 0;
        for (Company referees : printReferees) {
            if (referees instanceof Referees) {
                System.out.println(referees);
                countReferees++;
            }
        }
        if (countReferees == 0) {
            printLine("Brak sędziów w bibliotece");
        }
    }

    public void printLine(String text) {
        System.out.println(text.toUpperCase());
    }

}
