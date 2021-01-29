package pl.grzegorz.wrestlers.model;

import java.util.Objects;

public class Wrestlers {

    private String name;
    private String wrestlingName;
    private String organization;
    private int age;
    private boolean champion;
    private String title;

    public Wrestlers() {
    }

    public Wrestlers(String name, String wrestlingName, String organization, int age, boolean champion, String title) {
        this.name = name;
        this.wrestlingName = wrestlingName;
        this.organization = organization;
        this.age = age;
        this.champion = champion;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWrestlingName() {
        return wrestlingName;
    }

    public void setWrestlingName(String wrestlingName) {
        this.wrestlingName = wrestlingName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        return age == wrestlers.age && champion == wrestlers.champion && Objects.equals(name, wrestlers.name) && Objects.equals(wrestlingName, wrestlers.wrestlingName) && Objects.equals(organization, wrestlers.organization) && Objects.equals(title, wrestlers.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, wrestlingName, organization, age, champion, title);
    }

    @Override
    public String toString() {
        return "Wrestlers: "
                + "Prawdziwe imię :" + name + "\n"
                + ", imię Wrestlingowe: " + wrestlingName + "\n"
                + ", organizacja: " + organization + "\n"
                + ", wiek: " + age + "\n"
                + ", czy posiada jakiś tytuł mistrzowski: " + champion + "\n"
                + ", nazwa posiadanego tytułu mistrzowskiego: " + title + "\n" + "\n";
    }
}
