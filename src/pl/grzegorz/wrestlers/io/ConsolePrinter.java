package pl.grzegorz.wrestlers.io;

import pl.grzegorz.wrestlers.model.Organization;
import pl.grzegorz.wrestlers.model.LibraryUser;
import pl.grzegorz.wrestlers.model.FemaleWrestlers;
import pl.grzegorz.wrestlers.model.MaleWrestlers;

import java.util.Collection;

public class ConsolePrinter {

    public void printWrestlers(Collection<Organization> printWrestlers) {
        long count = printWrestlers.stream()
                .filter(wrestler -> wrestler instanceof MaleWrestlers)
                .map(Organization::toString)
                .peek(this::printLine)
                .count();

        if (count == 0) {
            printLine("Brak wrestlerów w bibliotece");
        }
    }

    public void printFemaleWrestlers(Collection<Organization> femaleWrestlers) {

        long count = femaleWrestlers.stream()
                .filter(femaleWrestler -> femaleWrestler instanceof FemaleWrestlers)
                .map(Organization::toString)
                .peek(this::printLine)
                .count();

        if (count == 0) {
            printLine("Brak wrestlerek w bibliotece");
        }
    }

    public void printUsers (Collection<LibraryUser> printUsers){
       printUsers.stream()
               .map(LibraryUser::toString)
               .forEach(this::printLine);

    }

    public void printLine(String text) {
        System.out.println(text.toUpperCase());
    }

}
