import java.time.LocalDate;
import java.util.Scanner;

public class TestMain {
        private static XFirm firma = new XFirm(10);
    public static void main(String[] args) {
        boolean shouldClose = false;
        while (!shouldClose) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Mitarbeiter ausgeben = 1");
            System.out.println("MinLohn ausgeben= 2");
            System.out.println("Verdienstspanne ausgeben = 3");
            System.out.println("GeschlechtAnteil ausgeben = 4");
            System.out.println("DurchschnittsAlter ausgeben = 5");
            System.out.println("Längster Mitarbeiter ausgeben = 6");
            System.out.println("Datei neu auslesen = 7");
            System.out.println("Programm beenden = 8");
            System.out.println("Mitarbeiter wählen = 0");

            int eingabe = Integer.parseInt(scan.nextLine());
            switch (eingabe){
                case 1 ->{
                    for (int i = 0; i < firma.getAngestelltenListe().length; i++) {
                        if(firma.getAngestelltenListe()[i] != null){
                            System.out.println(i + ". " + firma.getAngestelltenListe()[i].toString());
                        }
                    }
                }
                case 2 ->{
                    System.out.println("Minimaler Lohn - Gering Verdiener: " + firma.MinLohn() + " €");
                }
                case 3 ->{
                    System.out.println("Verdienstspanne zwischen Min und Max Lohn: " + firma.VerdienstSpanne() + " €");
                }
                case 4 ->{
                    System.out.println("Männlicher Anteil: " + firma.GeschlechterAnteilM() + " %");
                    System.out.println("Weiblicher Anteil: " + firma.GeschlechterAnteilW() + " %");
                    System.out.println("Diverser Anteil: " + (100 - (firma.GeschlechterAnteilM() + firma.GeschlechterAnteilW())) + " %");
                }
                case 5 ->{
                    System.out.println("Das Durchschnittsalter beträgt: " + (LocalDate.now().getYear() - firma.DurchschittsAlter()));
                }
                case 6 ->{
                    System.out.println("Der längste Mitarbeiter der Firma ist: " + firma.LaengsterMitarbeiter().toString());
                }
                case 7 ->{
                    firma.woerterAusDateiLesen("Text.txt");
                }
                case 8 ->{
                    shouldClose = true;
                }
                case 0 ->{
                    Menue2();
                }

            }
        }

        }
        public static void Menue2(){
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
                }
                else {
                    System.out.println("LohnErhöhen = 1");
                    System.out.println("Prämie hinzufügen = 2");
                    if (temp[i].getClass() == Manager.class || temp[i].getClass() == Geschaeftsfuehrer.class){
                    System.out.println("Gewinn eintragen = 3");
                    }
                    eingabe = Integer.parseInt(scan.nextLine());
                    switch (eingabe) {
                        case 0 -> {
                            String[] args = {};
                            main(args);
                        }
                        case 1 -> {
                            temp[i].LohnErhoehen();
                        }
                        case 2 -> {
                            System.out.println("Prämie in €: ");
                            double praemie = Double.parseDouble(scan.nextLine());
                            temp[i].praemie(praemie);
                        }
                        case 3 -> {
                            System.out.println("Gewinn in €: ");
                            double gewinn = Double.parseDouble(scan.nextLine());
                            temp[i].setGewinn(gewinn);
                        }
                    }
                }
            }
        }
    }
