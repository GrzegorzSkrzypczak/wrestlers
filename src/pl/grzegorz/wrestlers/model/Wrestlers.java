package pl.grzegorz.wrestlers.model;

import java.util.Objects;

public class Wrestlers extends Company {

    private String wrestlingName;
    private boolean champion;
    private String title;

    public Wrestlers() {
    }

    public Wrestlers(String wrestlingName, String organization, int age, boolean champion, String title) {
        this.wrestlingName = wrestlingName;
        this.setOrganizationName(organization);
        this.setAge(age);
        this.champion = champion;
        this.title = title;
    }

    public String getWrestlingName() {
        return wrestlingName;
    }

    public void setWrestlingName(String wrestlingName) {
        this.wrestlingName = wrestlingName;
    }

    public boolean isChampion() {
        return champion;
    }

    public void setChampion(boolean champion) {
        this.champion = champion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wrestlers wrestlers = (Wrestlers) o;
        return getAge() == wrestlers.getAge() && champion == wrestlers.champion && Objects.equals(wrestlingName, wrestlers.wrestlingName) && Objects.equals(getOrganizationName(), wrestlers.getOrganizationName()) && Objects.equals(title, wrestlers.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wrestlingName, getOrganizationName(), getAge(), champion, title);
    }

    @Override
    public String toString() {
        return "Wrestlers: " + "\n"
                + ", pseudonim: " + wrestlingName + "\n"
                + ", organizacja: " + getOrganizationName() + "\n"
                + ", wiek: " + getAge() + "\n"
                + ", czy posiada jakiś tytuł mistrzowski: " + champion + "\n"
                + ", nazwa posiadanego tytułu mistrzowskiego: " + title + "\n" + "\n";
    }
}
