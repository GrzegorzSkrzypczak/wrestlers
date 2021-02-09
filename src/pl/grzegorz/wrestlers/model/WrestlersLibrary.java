package pl.grzegorz.wrestlers.model;

public class WrestlersLibrary {

    private static final int MAX_SPACE = 2000;
    private Company[] company = new Company[MAX_SPACE];
    private int companySpace;

    public Company[] getCompany() {
        Company[] result = new Company[companySpace];
        for (int i = 0; i < result.length; i++) {
            result[i] = company[i];
        }
        return result;
    }

    public void addWrestler(Wrestlers wrestler) {
        addEmployees(wrestler);
    }

    public void addReferee(Referees refree) {
        addEmployees(refree);
    }

    private void addEmployees(Company employees) {
        if (companySpace >= MAX_SPACE) {
            throw new ArrayIndexOutOfBoundsException("No more space in database to save wrestler or referee!" + MAX_SPACE);
        }
        company[companySpace] = employees;
        companySpace++;
    }
}
