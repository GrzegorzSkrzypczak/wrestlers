package pl.grzegorz.wrestlers.model;

import java.io.Serializable;
import java.util.Arrays;

public class WrestlersLibrary implements Serializable {

    private static final int CAPACITY = 1;
    private Company[] company = new Company[CAPACITY];
    private int companySpace = 0;

    public Company[] getCompany() {
        Company[] result = new Company[companySpace];
        for (int i = 0; i < result.length; i++) {
            result[i] = company[i];
        }
        return result;
    }

    public void addEmployees(Company employees) {
        if (companySpace == company.length) {
            company = Arrays.copyOf(company, company.length * 2);
        }
        company[companySpace] = employees;
        companySpace++;
    }

    public boolean removeEmployee(Company comp) {
        final int notFound = -1;
        int found = notFound;
        int i = 0;

        while(i < companySpace && found == notFound) {
            if(comp.equals(company[i])) {
                found = i;
            } else {
                i++;
            }
        }

        if(found != notFound){
            System.arraycopy(company, found +1, company, found, company.length - found -1);
            companySpace--;
            company[companySpace] = null;
        }

        return found != notFound;
    }
}
