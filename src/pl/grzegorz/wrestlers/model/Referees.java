package pl.grzegorz.wrestlers.model;

import java.util.Objects;

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
        return "Sędzia: " + "\n"
                + "imię / ksywa : " + name + "\n"
                + super.toString() + "\n"
                + " staż: " + yearsInCompany + "\n"
                + " frakcja: " + brand + "\n"
                + " płęć: " + gender + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Referees referees = (Referees) o;
        return yearsInCompany == referees.yearsInCompany && Objects.equals(name, referees.name) && Objects.equals(brand, referees.brand) && Objects.equals(gender, referees.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, yearsInCompany, brand, gender);
    }
}
