package pl.grzegorz.wrestlers.io;

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
        System.out.println("Prawdziwe imię :");
        String name = scanner.nextLine();
        System.out.println("Imię Wrestlingowe: ");
        String wrestlingName = scanner.nextLine();
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

        return new Wrestlers(name, wrestlingName, organization, age, isAChampion, championship);
    }
}
