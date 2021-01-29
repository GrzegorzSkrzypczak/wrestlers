package pl.grzegorz.wrestlers.io;

import pl.grzegorz.wrestlers.model.Referees;
import pl.grzegorz.wrestlers.model.Wrestlers;
import java.util.Scanner;

public class DataReader {
    private final Scanner scanner = new Scanner(System.in);

    public void close() {
        scanner.close();
    }

    public int getInt() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public Wrestlers readAndCreateWrestler() {
        System.out.println("Pseudonim:");
        String name = scanner.nextLine();
        System.out.println("Organizacja: ");
        String organization = scanner.nextLine();
        System.out.println("Wiek: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Czy posiada pas: ");
        boolean isAChampion = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Tytuł mistrzowski: ");
        String championship = scanner.nextLine();

        return new Wrestlers(name, organization, age, isAChampion, championship);
    }

    public Referees readAndCreateReferees() {
        System.out.println("Imię i nazwisko :");
        String name = scanner.nextLine();
        System.out.println("Organizacja: ");
        String organization = scanner.nextLine();
        System.out.println("Wiek: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Staż w federacji: ");
        int yearsInCompany = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Przynależy do frakcji: ");
        String brand = scanner.nextLine();
        System.out.println("Płęć: ");
        String gender = scanner.nextLine();

        return new Referees(name, organization,age,yearsInCompany,brand,gender);
    }
}
