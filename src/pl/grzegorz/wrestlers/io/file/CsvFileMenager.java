package pl.grzegorz.wrestlers.io.file;

import pl.grzegorz.wrestlers.exceptions.DataExportException;
import pl.grzegorz.wrestlers.exceptions.DataImportException;
import pl.grzegorz.wrestlers.exceptions.InvalidDataException;
import pl.grzegorz.wrestlers.model.*;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileMenager implements FileMenager {

    private static final String WRESTLERS_FILE_NAME = "Wrestlers.csv";
    private static final String USERS_FILE_NAME = "Users.csv";

    @Override
    public WrestlersLibrary importData() {
        WrestlersLibrary employeeLibrary = new WrestlersLibrary();
        inportCompany(employeeLibrary);
        importUsers(employeeLibrary);
        return employeeLibrary;
    }

    private void importUsers(WrestlersLibrary employeeLibrary) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(USERS_FILE_NAME))) {
            bufferedReader.lines()
                    .map(this::createUserFromString)
                    .forEach(employeeLibrary::addUser);
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku " + USERS_FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd odczytu pliku " + USERS_FILE_NAME);
        }
    }

    private LibraryUser createUserFromString(String csvTxt) {
        String[] split = csvTxt.split(";");
        int id = Integer.parseInt(split[0]);
        String name = split[1];
        String lastName = split[2];
        return new LibraryUser(id, name, lastName);
    }

    private void inportCompany(WrestlersLibrary library) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(WRESTLERS_FILE_NAME))) {
            bufferedReader.lines()
                    .map(this::createObjectFromString)
                    .forEach(library::addWrestlers);
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku " + WRESTLERS_FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Bład odczytu pliku" + WRESTLERS_FILE_NAME);
        }
    }

    private Organization createObjectFromString(String nextLine) {
        String[] split = nextLine.split(";");
        String type = split[0];
        if(MaleWrestlers.TYPE.equals(type)) {
            return createMaleWretler(split);
        } else if (FemaleWrestlers.TYPE.equals(type)) {
            return createFemaleWrestler(split);
        }
        throw new InvalidDataException("Nieznany typ publikacji " + type);

    }

    private Organization createMaleWretler(String[] wrestler) {
        int rank = Integer.parseInt(wrestler[1]);
        String organizationName = wrestler[2];
        String organizationShortName = wrestler[3];
        String tvShow = wrestler[4];
        String wrestlingName = wrestler[5];
        String realName = wrestler[6];
        int age = Integer.parseInt(wrestler[7]);
        String championschipTitle = wrestler[8];
        int timesAsChampion = Integer.parseInt(wrestler[9]);
        return new MaleWrestlers(rank,organizationName,organizationShortName,tvShow,
                wrestlingName,realName,age,championschipTitle,timesAsChampion);
    }

    private Organization createFemaleWrestler(String[] wrestler) {
        int rank = Integer.parseInt(wrestler[1]);
        String organizationName = wrestler[2];
        String organizationShortName = wrestler[3];
        String tvShow = wrestler[4];
        String wrestlingName = wrestler[5];
        String realName = wrestler[6];
        int age = Integer.parseInt(wrestler[7]);
        String championschipTitle = wrestler[8];
        int timesAsChampion = Integer.parseInt(wrestler[9]);
        return new FemaleWrestlers(rank,organizationName,organizationShortName,tvShow,
                wrestlingName,realName,age,championschipTitle,timesAsChampion);
    }

    @Override
    public void exportData(WrestlersLibrary wrestlersLibrary) {
        exportWrestlers(wrestlersLibrary);
        exportUsers(wrestlersLibrary);

    }

    public void exportWrestlers(WrestlersLibrary library){
        Collection<Organization> employees = library.getCompany().values();
        exportToCsv(employees, WRESTLERS_FILE_NAME);
    }

    public void exportUsers (WrestlersLibrary library) {
        Collection<LibraryUser> libraryUsers = library.getUsers().values();
        exportToCsv(libraryUsers, USERS_FILE_NAME);

    }

    public<T extends CsvConvertible> void exportToCsv (Collection<T> collection, String fileName) {
        try (
                FileWriter fileWriter = new FileWriter(fileName);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (T element : collection) {
                bufferedWriter.write(element.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + USERS_FILE_NAME);
        }
    }
}
