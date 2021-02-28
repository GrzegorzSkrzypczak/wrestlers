package pl.grzegorz.wrestlers.io;

import pl.grzegorz.wrestlers.model.LibraryUser;
import pl.grzegorz.wrestlers.model.FemaleWrestlers;
import pl.grzegorz.wrestlers.model.MaleWrestlers;
import java.util.Scanner;

public class DataReader {
    private final Scanner scanner = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public MaleWrestlers readAndCreateMaleWrestler() {
        printer.printLine("Podaj range wrestlera: ");
        int rank = getInt();
        printer.printLine("Pełna nazwa organizacji:");
        String organizationName = scanner.nextLine();
        printer.printLine("Skrócona nazwa organizacji: ");
        String organizationShortName = scanner.nextLine();
        printer.printLine("Nazwa brandu na którym występuje wrestler: ");
        String tvShow = scanner.nextLine();
        printer.printLine("Pseudonim wrestlingowy: ");
        String wrestlingName = scanner.nextLine();
        printer.printLine("Prawdziwe imię i nazwisko: ");
        String realName = scanner.nextLine();
        printer.printLine("Wiek: ");
        int age = getInt();
        printer.printLine("Obecnie posiadany pas mistrzowski: ");
        String championchip = scanner.nextLine();
        printer.printLine("Mistrz federacji x: ");
        int championTimes = getInt();

        return new MaleWrestlers(rank, organizationName,organizationShortName,tvShow
        ,wrestlingName, realName, age, championchip, championTimes);
    }

    public FemaleWrestlers readAndCreateFemaleWrestler() {
        printer.printLine("Podaj range wrestlerki: ");
        int rank = getInt();
        printer.printLine("Pełna nazwa organizacji:");
        String organizationName = scanner.nextLine();
        printer.printLine("Skrócona nazwa organizacji: ");
        String organizationShortName = scanner.nextLine();
        printer.printLine("Nazwa brandu na którym występuje wrestlerka: ");
        String tvShow = scanner.nextLine();
        printer.printLine("Pseudonim wrestlingowy: ");
        String wrestlingName = scanner.nextLine();
        printer.printLine("Prawdziwe imię i nazwisko: ");
        String realName = scanner.nextLine();
        printer.printLine("Wiek: ");
        int age = getInt();
        printer.printLine("Obecnie posiadany pas mistrzowski: ");
        String championchip = scanner.nextLine();
        printer.printLine("Mistrzyni federacji x: ");
        int championTimes = getInt();

        return new FemaleWrestlers(rank, organizationName,organizationShortName,tvShow
                ,wrestlingName, realName, age, championchip, championTimes);
    }

    public LibraryUser createUser(){
        printer.printLine("Podaj id: ");
        int id =  getInt();
        printer.printLine("Podaj imię: ");
        String name = scanner.nextLine();
        printer.printLine("Podaj Nazwisko: ");
        String lastName = scanner.nextLine();
        return new LibraryUser(id, name, lastName);


    }

    public String getString() {
       return scanner.nextLine();
    }

    public int getInt() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public void close() {
        scanner.close();
    }
}
