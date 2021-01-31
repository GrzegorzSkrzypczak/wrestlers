package pl.grzegorz.wrestlers.model;

import java.util.Objects;

class Company {

    private String organizationName;
    private int age;

    public Company() {
    }

    public Company(String organizationName, int age) {
        this.organizationName = organizationName;
        this.age = age;
    }


    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Organizacja: " + "\n"
                + "nazwa organizacji: " + organizationName + "\n"
                + ", wiek: " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return age == company.age && Objects.equals(organizationName, company.organizationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationName, age);
    }
}
