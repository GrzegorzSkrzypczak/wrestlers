package pl.grzegorz.wrestlers.io;

import pl.grzegorz.wrestlers.model.Referees;
import pl.grzegorz.wrestlers.model.Wrestlers;
import java.util.Scanner;

public class DataReader {
    private final Scanner scanner = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public void close() {
        scanner.close();
    }

    public int getInt() {
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();
        }
    }

    public Wrestlers readAndCreateWrestler() {
        printer.printLine("Pseudonim:");
        String name = scanner.nextLine();
        printer.printLine("Organizacja: ");
        String organization = scanner.nextLine();
        printer.printLine("Wiek: ");
        int age = getInt();
        scanner.nextLine();
        printer.printLine("Czy posiada pas: ");
        boolean isAChampion = scanner.nextBoolean();
        scanner.nextLine();
        printer.printLine("Tytuł mistrzowski: ");
        String championship = scanner.nextLine();

        return new Wrestlers(name, organization, age, isAChampion, championship);
    }

    public Referees readAndCreateReferees() {
        printer.printLine("Imię i nazwisko :");
        String name = scanner.nextLine();
        printer.printLine("Organizacja: ");
        String organization = scanner.nextLine();
        printer.printLine("Wiek: ");
        int age = getInt();
        scanner.nextLine();
        printer.printLine("Staż w federacji: ");
        int yearsInCompany = getInt();
        scanner.nextLine();
        printer.printLine("Przynależy do frakcji: ");
        String brand = scanner.nextLine();
        printer.printLine("Płęć: ");
        String gender = scanner.nextLine();

        return new Referees(name, organization,age,yearsInCompany,brand,gender);
    }
}
