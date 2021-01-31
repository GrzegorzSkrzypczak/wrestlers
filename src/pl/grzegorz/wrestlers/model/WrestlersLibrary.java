package pl.grzegorz.wrestlers.model;

import java.util.Arrays;

public class WrestlersLibrary {

    private static final int maxSpace = 2000;
    private Company[] company = new Company[maxSpace];
    private int companySpace;


    public void addWrestler(Wrestlers wrestler){
        if(companySpace < maxSpace){
            company[companySpace] = wrestler;
            companySpace++;
        } else {
            System.out.println("Nie ma miejsca na nowego wrestlera");
        }
    }

    public void addReferee (Referees refree){
        if(companySpace < maxSpace){
            company[companySpace] = refree;
            companySpace++;
        } else {
            System.out.println("Brak miejsca na nowego sędziego");
        }
    }

    public void printWrestlers(){
        if(companySpace == 0) {
            System.out.println("Brak wrestlerów w spisie");
        }

        for (int i = 0; i < companySpace; i++) {
            System.out.println(Arrays.toString(company));
        }
    }

    public void printReferee(){
        if(companySpace == 0) {
            System.out.println("Brak sędziów w spisie");
        }

        for (int i = 0; i < companySpace; i++) {
            System.out.println(Arrays.toString(company));
        }
    }

}
