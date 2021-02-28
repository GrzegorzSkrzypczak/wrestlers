package pl.grzegorz.wrestlers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User{

    private List<Organization> wrestlersDatabase = new ArrayList<>();
    private List<Organization> operationsOnDatabase = new ArrayList<>();

    public LibraryUser(int id, String name, String lastName) {
        super(id, name, lastName);
    }

    @Override
    public String toCsv() {
        return getId() + ";" + getName() + ";" + getLastName();
    }

    public List<Organization> getWrestlersDatabase() {
        return wrestlersDatabase;
    }

    public List<Organization> getOperationsOnDatabase() {
        return operationsOnDatabase;
    }

    public void addToCompany(Organization company){
        wrestlersDatabase.add(company);
    }

    public void exchangeTalent(Organization company) {
        operationsOnDatabase.add(company);
    }

    public boolean returnEmployeeStatus (Organization employee) {
        boolean result = false;
        if(operationsOnDatabase.contains(employee)) {
            operationsOnDatabase.remove(employee);
            addToCompany(employee);
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(wrestlersDatabase, that.wrestlersDatabase) && Objects.equals(operationsOnDatabase, that.operationsOnDatabase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wrestlersDatabase, operationsOnDatabase);
    }
}
