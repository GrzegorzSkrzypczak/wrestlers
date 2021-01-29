package pl.grzegorz.wrestlers.model;

import java.util.Arrays;

public class WrestlersLibrary {
    private static final int maxWrestlers = 1000;
    private static final int maxReferees = 1000;
    private Wrestlers[] allWrestlers = new Wrestlers[maxWrestlers];
    private Referees[] allReferees = new Referees[maxReferees];
    private int refereeCount;
    private int wretlersCount;

    public void addWrestler(Wrestlers wrestler){
        if(wretlersCount < maxWrestlers){
            allWrestlers[wretlersCount] = wrestler;
            wretlersCount++;
        } else {
            System.out.println("Nie ma miejsca na nowego wrestlera");
        }
    }

    public void addReferee (Referees refree){
        if(refereeCount < maxWrestlers){
            allReferees[refereeCount] = refree;
            refereeCount++;
        } else {
            System.out.println("Brak miejsca na nowego sędziego");
        }
    }

    public void printWrestlers(){
        if(wretlersCount == 0) {
            System.out.println("Brak wrestlerów w spisie");
        }

        for (int i = 0; i < wretlersCount; i++) {
            System.out.println(Arrays.toString(allWrestlers));
        }
    }

    public void printReferee(){
        if(refereeCount == 0) {
            System.out.println("Brak sędziów w spisie");
        }

        for (int i = 0; i < refereeCount; i++) {
            System.out.println(Arrays.toString(allReferees));
        }
    }

}
