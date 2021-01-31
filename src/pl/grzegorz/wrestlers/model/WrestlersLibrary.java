package pl.grzegorz.wrestlers.model;

public class WrestlersLibrary {

    private static final int MAX_SPACE = 2000;
    private Company[] company = new Company[MAX_SPACE];
    private int companySpace;


    public void addWrestler(Wrestlers wrestler){
        if(companySpace < MAX_SPACE){
            company[companySpace] = wrestler;
            companySpace++;
        } else {
            System.out.println("Nie ma miejsca na nowego wrestlera");
        }
    }

    public void addReferee (Referees refree){
        if(companySpace < MAX_SPACE){
            company[companySpace] = refree;
            companySpace++;
        } else {
            System.out.println("Brak miejsca na nowego sędziego");
        }
    }

    public void printWrestlers(){
        int countWrestlers = 0;
        for (int i = 0; i < companySpace; i++) {
            if(company[i] instanceof Wrestlers){
                System.out.println(company[i]);
                countWrestlers++;
            }
        }
        if (countWrestlers == 0) {
            System.out.println("Brak wrestlerów w bibliotece");
        }
    }

    public void printReferee() {
        int countReferees = 0;
        for (int i = 0; i < companySpace; i++) {
            if (company[i] instanceof Referees) {
                System.out.println(company[i]);
                countReferees++;
            }
        }
        if (countReferees == 0) {
            System.out.println("Brak sędziów w bibliotece");
        }
    }

}
