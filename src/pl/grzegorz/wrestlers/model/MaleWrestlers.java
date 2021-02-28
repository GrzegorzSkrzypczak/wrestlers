package pl.grzegorz.wrestlers.model;

import java.util.Objects;

public class MaleWrestlers extends Organization {

    public static final String TYPE = "Male Wrestler";
    private String wrestlingName;
    private String realName;
    private int age;
    private int howManyMainTitleReigns;

    public MaleWrestlers(int rank, String organizationName,
                           String ogranizationShortName, String tvShow,
                           String wrestlingName, String realName, int age, String championschipTitle, int titleReigns) {
        super(rank, organizationName, ogranizationShortName, championschipTitle, tvShow);
        this.wrestlingName = wrestlingName;
        this.realName =realName;
        this.age = age;
        this.howManyMainTitleReigns = titleReigns;
    }

    public String getWrestlingName() {
        return wrestlingName;
    }

    public void setWrestlingName(String wrestlingName) {
        this.wrestlingName = wrestlingName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHowManyMainTitleReigns() {
        return howManyMainTitleReigns;
    }

    public void setHowManyMainTitleReigns(int howManyMainTitleReigns) {
        this.howManyMainTitleReigns = howManyMainTitleReigns;
    }

    @Override
    public String toString() {
        return "Wrestler: "
                + super.toString() + ", "
                + " imię wrestlingowe: " + wrestlingName + ", "
                + " prawdziwe imię i nazwisko: " + realName + ", "
                + " wiek: " + age + ", "
                + " ilość razy jako główna mistrzyni federacji: " + howManyMainTitleReigns + "\n";
    }

    @Override
    public String toCsv() {
        return TYPE + ";"
                + getRank() + ";"
                + getOrganizationFullName() + ";"
                + getOgranizationShortName() + ";"
                + getTvShow() + ";"
                + wrestlingName + ";"
                + realName + ";"
                + age + ";"
                + getChampionshitTitle() + ";"
                + howManyMainTitleReigns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MaleWrestlers that = (MaleWrestlers) o;
        return age == that.age && howManyMainTitleReigns == that.howManyMainTitleReigns && Objects.equals(wrestlingName, that.wrestlingName) && Objects.equals(realName, that.realName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wrestlingName, realName, age, howManyMainTitleReigns);
    }
}
