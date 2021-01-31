package pl.grzegorz.wrestlers.model;

public class Referees extends Company{

    private String name;
    private int yearsInCompany;
    private String brand;
    private String gender;

    public Referees(String name, String organizationName,
                    int age, int yearsInCompany, String brand, String gender) {
        super(organizationName, age);
        this.name = name;
        this.yearsInCompany = yearsInCompany;
        this.brand = brand;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsInCompany() {
        return yearsInCompany;
    }

    public void setYearsInCompany(int yearsInCompany) {
        this.yearsInCompany = yearsInCompany;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Sędziowie: " + "\n"
                + "imię / ksywa : " + name + "\n"
                + ", organizacja: " + getOrganizationName() + "\n"
                + ", wiek: " + getAge() + "\n"
                + ", staż: " + yearsInCompany + "\n"
                + ", frakcja: " + brand + "\n"
                + ", płęć: " + gender + "\n" + "\n";
    }
}
