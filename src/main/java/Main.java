import service.AusleiheService;
import service.BuchService;

public class Main {

    public static void main(String[] args) {

        BuchService.getAusgelieheneBuecherByLeser(3)
                .forEach(buch -> System.out.println(buch.getTitel()));

        AusleiheService.ausleihen(3, "B-3");

        BuchService.getAusgelieheneBuecherByLeser(3)
                .forEach(buch -> System.out.println(buch.getTitel()));
    }
}
