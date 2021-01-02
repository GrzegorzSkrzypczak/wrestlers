import java.util.Objects;

public class Wrestlers {

    private String name;
    private String lastName;
    private String organization;
    private int years;
    private boolean champion;
    private Championships title;

    public Wrestlers() {
    }

    public Wrestlers(String name, String lastName, String organization, int years, boolean champion, Championships title) {
        this.name = name;
        this.lastName = lastName;
        this.organization = organization;
        this.years = years;
        this.champion = champion;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public boolean isChampion() {
        return champion;
    }

    public void setChampion(boolean champion) {
        this.champion = champion;
    }

    public Championships getTitle() {
        return title;
    }

    public void setTitle(Championships title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrestlers wrestlers = (Wrestlers) o;
        return years == wrestlers.years && champion == wrestlers.champion && Objects.equals(name, wrestlers.name) && Objects.equals(lastName, wrestlers.lastName) && Objects.equals(organization, wrestlers.organization) && Objects.equals(title, wrestlers.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, organization, years, champion, title);
    }

    @Override
    public String toString() {
        return "Wrestler: " +
                "name: " + name + '\'' +
                ", last name: " + lastName + '\'' +
                ", organization: " + organization + '\'' +
                ", years old: " + years +
                ", chapionship status: " + champion +
                ", title: " + title;
    }
}
