package pl.grzegorz.wrestlers.io.file;

import pl.grzegorz.wrestlers.exceptions.DataExportException;
import pl.grzegorz.wrestlers.exceptions.DataImportException;
import pl.grzegorz.wrestlers.exceptions.InvalidDataException;
import pl.grzegorz.wrestlers.model.Company;
import pl.grzegorz.wrestlers.model.Referees;
import pl.grzegorz.wrestlers.model.Wrestlers;
import pl.grzegorz.wrestlers.model.WrestlersLibrary;

import java.io.*;
import java.util.Scanner;

public class CsvFileMenager implements FileMenager {

    private static final String FILE_NAME = "WrestlingLibrary.csv";

    @Override
    public WrestlersLibrary importData() {
        WrestlersLibrary employeeLibrary = new WrestlersLibrary();
        try (Scanner fileReader = new Scanner(new File(FILE_NAME))) {
            while(fileReader.hasNext()) {
                String nextLine = fileReader.nextLine();
                Company employee = createObjectFromString(nextLine);
                employeeLibrary.addEmployees(employee);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku " + FILE_NAME);
        }
        return employeeLibrary;
    }

    private Company createObjectFromString(String nextLine) {
        String[] split = nextLine.split(";");
        String type = split[0];
        if(Wrestlers.TYPE.equals(type)) {
            return createWretler(split);
        } else if (Referees.TYPE.equals(type)) {
            return createReferee(split);
        }
        throw new InvalidDataException("Nieznany typ publikacji " + type);

    }

    private Company createWretler(String[] wrestler) {
        String organizationName = wrestler[1];
        String wrestlingName = wrestler[2];
        int age = Integer.valueOf(wrestler[3]);
        boolean champion = Boolean.valueOf(wrestler[4]);
        String title = wrestler[5];
        return new Wrestlers(organizationName,wrestlingName,age,champion,title);
    }

    private Company createReferee(String[] referee) {
        String organizationName = referee[1];
        String wrestlingName = referee[2];
        int age = Integer.valueOf(referee[3]);
        int yearsInCompany = Integer.valueOf(referee[4]);
        String gender = referee[5];
        String brand = referee[6];
        return new Referees(organizationName,wrestlingName,age,yearsInCompany,gender,brand);
    }

    @Override
    public void exportData(WrestlersLibrary wrestlersLibrary) {
        Company[] employees = wrestlersLibrary.getCompany();
        try (
                FileWriter fileWriter = new FileWriter(FILE_NAME);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Company employee : employees) {
                bufferedWriter.write(employee.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }
}
