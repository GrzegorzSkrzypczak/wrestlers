package pl.grzegorz.wrestlers.app;

enum Options {

    EXIT(0, "Wyjście z programu"),
    ADD_WRESTLER(1, "Dodaj wrestlera"),
    ADD_REFEREE(2,"Dodaj sędziego"),
    PRINT_WRESTLER(3, "Wyświetl wrestlerów"),
    PRINT_REFEREE(4, "WYświetl sędziów");

    private int value;
    private String description;

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    Options() {
    }

    Options(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    static Options createFromInt(int option) {
        return Options.values()[option];
    }
}
