package pl.grzegorz.wrestlers.io.file;

import pl.grzegorz.wrestlers.exceptions.DataExportException;
import pl.grzegorz.wrestlers.exceptions.DataImportException;
import pl.grzegorz.wrestlers.model.WrestlersLibrary;

import java.io.*;

/*
Metoda zapisu danych do pliku o dowolnym rozszerzeniu.
Rozszerzenie możemy dodać w enumie FileType.
 */
public class SerializableFileMenager implements FileMenager{
    private static final String FILE_NAME = "WrestlingFile.o";

    @Override
    public WrestlersLibrary importData() {
        try(
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (WrestlersLibrary) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("Brak pliku" +  FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd odczytu pliku" +  FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny typ danych w pliku" +  FILE_NAME);
        }
    }

    @Override
    public void exportData(WrestlersLibrary wrestlersLibrary) {
        try(
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(wrestlersLibrary);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Brak pliku" +  FILE_NAME);
        } catch (IOException e){
            throw new DataExportException("Błąd zapisu danych do pliku" +  FILE_NAME);
        }

    }
}
