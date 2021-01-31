package pl.grzegorz.wrestlers.model;

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
}
