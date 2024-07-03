import java.util.Scanner;

public class TestMain {
        XFirm firma = new XFirm(10);
    public static void main(String[] args) {
        boolean shouldClose = false;
        while (!shouldClose) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Mitarbeiter ausgeben = 1");
            System.out.println("MinLohn ausgeben= 2");
            System.out.println("Verdienstspanne ausgeben = 3");
            System.out.println("GeschlechtAnteil Weiblich ausgeben = 4");
            System.out.println("GeschlechtAnteil Männlich ausgeben = 5");
            System.out.println("GeschlechtAnteil Divers ausgeben = 6");
            System.out.println("DurchschnittsAlter ausgeben = 7");
            System.out.println("Längster Mitarbeiter ausgeben = 8");
            System.out.println("Datei neu auslesen = 9");
            System.out.println("Programm beenden = 10");
            System.out.println("Mitarbeiter wählen = 0");
        }

        }
        public void Menue2(){
            Mitarbeiter[] temp = firma.getAngestelltenListe();
            Scanner scan = new Scanner(System.in);
            boolean shouldClose2 = false;
            while (!shouldClose2) {
                int i;
                for (i = 0; i < temp.length; i++) {
                    System.out.println(temp[i].toString() + " = " + (i+1));
                }
                System.out.println("Zurück zum Hauptmenü = 0");
                int eingabe = Integer.parseInt(scan.nextLine());
                if (eingabe < 0 || eingabe > 20) {
                    System.out.println("Fehler beim lesen");
                }else {
                    System.out.println("LohnErhöhen = 1");
                    System.out.println("Prämie hinzufügen = 2");
                    if (temp[i].getClass() == Manager.class || temp[i].getClass() == Geschaeftsfuehrer.class){
                    System.out.println("Gewinn eintragen = 3");
                    }
                    switch (eingabe) {
                        case 0 -> {
                            String[] args = {};
                            main(args);
                        }
                        case 1 -> {
                            temp[i].LohnErhoehen();
                        }
                        case 2 -> {
                            temp[i]
                        }
                    }
                }
            }
        }
    }
