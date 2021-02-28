package pl.grzegorz.wrestlers.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Organization implements Serializable {

    private int rank;
    private String organizationFullName;
    private String ogranizationShortName;
    private String championshitTitle;
    private String tvShow;


    public Organization() {
    }

    public Organization(int rank, String organizationName, String shortName, String title, String show) {
        this.rank = rank;
        this.organizationFullName = organizationName;
        this.ogranizationShortName = shortName;
        this.championshitTitle = title;
        this.tvShow = show;
    }


    public String getOrganizationFullName() {
        return organizationFullName;
    }

    public void setOrganizationFullName(String organizationFullName) {
        this.organizationFullName = organizationFullName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getOgranizationShortName() {
        return ogranizationShortName;
    }

    public String getChampionshitTitle() {
        return championshitTitle;
    }

    public void setChampionshitTitle(String championshitTitle) {
        this.championshitTitle = championshitTitle;
    }

    public String getTvShow() {
        return tvShow;
    }

    public void setTvShow(String tvShow) {
        this.tvShow = tvShow;
    }

    @Override
    public String toString() {
        return  "Ranga (ptk): " + rank + ", "
                + " pełna nazwa organizacji: " + organizationFullName + ", "
                + " skrócona nazwa organizacji: " + ogranizationShortName + ", "
                + " pas mistrzowski: " + championshitTitle
                + " występuje na: " + tvShow;
    }

    public abstract String toCsv();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return rank == that.rank && Objects.equals(organizationFullName, that.organizationFullName) && Objects.equals(ogranizationShortName, that.ogranizationShortName) && Objects.equals(championshitTitle, that.championshitTitle) && Objects.equals(tvShow, that.tvShow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, organizationFullName, ogranizationShortName, championshitTitle, tvShow);
    }
}
