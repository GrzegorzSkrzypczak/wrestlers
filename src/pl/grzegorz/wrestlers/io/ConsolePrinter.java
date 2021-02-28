package pl.grzegorz.wrestlers.io;

import pl.grzegorz.wrestlers.model.Organization;
import pl.grzegorz.wrestlers.model.LibraryUser;
import pl.grzegorz.wrestlers.model.FemaleWrestlers;
import pl.grzegorz.wrestlers.model.MaleWrestlers;

import java.util.Collection;

public class ConsolePrinter {

    public void printWrestlers(Collection<Organization> printWrestlers) {
        int countWrestlers = 0;
        for (Organization wrestlers : printWrestlers) {
            if (wrestlers instanceof MaleWrestlers) {
                printLine(wrestlers.toString());
                countWrestlers++;
            }
        }
        if (countWrestlers == 0) {
            printLine("Brak wrestlerów w bibliotece");
        }
    }

    public void printReferee(Collection<Organization> printReferees) {
        int countReferees = 0;
        for (Organization referees : printReferees) {
            if (referees instanceof FemaleWrestlers) {
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
