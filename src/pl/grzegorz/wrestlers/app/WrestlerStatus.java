package pl.grzegorz.wrestlers.app;

public class WrestlerStatus {
    public static void main(String[] args) {
        final String appVersion = "Wersja aplikacji v0.1";

        System.out.println(appVersion);
        WrestlersController controller = new WrestlersController();
        controller.control();


    }
}
