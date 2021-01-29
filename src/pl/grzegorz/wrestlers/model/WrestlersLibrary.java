package pl.grzegorz.wrestlers.model;

import java.util.Arrays;

public class WrestlersLibrary {
    private final int maxWrestlers = 1000;
    private Wrestlers[] allWrestlers = new Wrestlers[maxWrestlers];
    private int wretlersCount;

    public void addWrestler(Wrestlers wrestler){
        if(wretlersCount < maxWrestlers){
            allWrestlers[wretlersCount] = wrestler;
            wretlersCount++;
        } else {
            System.out.println("Nie ma miejsca na nowego wrestlera");
        }
    }

    public void printWrestlers(){
        if(wretlersCount == 0) {
            System.out.println("Bral wrestlerów w spisie");
        }

        for (int i = 0; i < wretlersCount; i++) {
            System.out.println(Arrays.toString(allWrestlers));
        }
    }

}
