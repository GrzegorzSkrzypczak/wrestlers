package pl.grzegorz.wrestlers.io;

import pl.grzegorz.wrestlers.model.Company;
import pl.grzegorz.wrestlers.model.LibraryUser;
import pl.grzegorz.wrestlers.model.Referees;
import pl.grzegorz.wrestlers.model.Wrestlers;

import java.util.Collection;

public class ConsolePrinter {

    public void printWrestlers(Collection<Company> printWrestlers) {
        int countWrestlers = 0;
        for (Company wrestlers : printWrestlers) {
            if (wrestlers instanceof Wrestlers) {
                printLine(wrestlers.toString());
                countWrestlers++;
            }
        }
        if (countWrestlers == 0) {
            printLine("Brak wrestlerów w bibliotece");
        }
    }

    public void printReferee(Collection<Company> printReferees) {
        int countReferees = 0;
        for (Company referees : printReferees) {
            if (referees instanceof Referees) {
                printLine(referees.toString());
                countReferees++;
            }
        }
        if (countReferees == 0) {
            printLine("Brak sędziów w bibliotece");
        }
    }

    public void printUsers (Collection<LibraryUser> printUsers){
        int countUsers = 0;
        for (LibraryUser users : printUsers) {
            printLine(users.toString());
        }

    }

    public void printLine(String text) {
        System.out.println(text.toUpperCase());
    }

    // TODO zmiana koncepcli + poprawić kolejnosc wyswietlania!
}
