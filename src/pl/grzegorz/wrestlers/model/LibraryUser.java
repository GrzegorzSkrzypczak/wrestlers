package pl.grzegorz.wrestlers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User{

    private List<Company> companyHistory = new ArrayList<>();
    private List<Company> talentExchange = new ArrayList<>();

    public LibraryUser(int id, String name, String lastName) {
        super(id, name, lastName);
    }

    @Override
    public String toCsv() {
        return getId() + ";" + getName() + ";" + getLastName();
    }

    public List<Company> getCompanyHistory() {
        return companyHistory;
    }

    public List<Company> getTalentExchange() {
        return talentExchange;
    }

    public void addToCompany(Company company){
        companyHistory.add(company);
    }

    public void exchangeTalent(Company company) {
        talentExchange.add(company);
    }

    public boolean returnEmployeeStatus (Company employee) {
        boolean result = false;
        if(talentExchange.contains(employee)) {
            talentExchange.remove(employee);
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
        return Objects.equals(companyHistory, that.companyHistory) && Objects.equals(talentExchange, that.talentExchange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), companyHistory, talentExchange);
    }
}
