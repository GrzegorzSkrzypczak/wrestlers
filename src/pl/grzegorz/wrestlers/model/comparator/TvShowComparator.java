package pl.grzegorz.wrestlers.model.comparator;

import pl.grzegorz.wrestlers.model.Organization;

import java.util.Comparator;

public class TvShowComparator implements Comparator<Organization> {
    @Override
    public int compare(Organization o1, Organization o2) {
        if(o1 == null && o2 == null)
            return 0;
        else if(o1 == null)
            return 1;
        else if(o2 == null)
            return -1;
        return o1.getTvShow().compareToIgnoreCase(o2.getTvShow());
    }
}
