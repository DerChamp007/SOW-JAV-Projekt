import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class XFirm {
    /*
@author: Randip Singh, Luis Ott
@version: 1.0
 */
    private Mitarbeiter[] angestelltenListe = new Mitarbeiter[20];
    private Mitarbeiter[] ehemaligenListe;
    private static int anzahlMitarbeiter = 0;
    public XFirm(Mitarbeiter[] angestelltenListe) {
        try {
            setAngestelltenListe(angestelltenListe);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public XFirm(int maxMitarbeiter){
        // Pfad zur Textdatei
        String dateiPfad = "C:/Users/user/OneDrive - bib & FHDW/Dokumente/SWE/SOW-JAV-Projekt/Text.txt";

        // Methode aufrufen, um die Wörter aus der Datei zu lesen
        wörterAusDateiLesen(dateiPfad);

    }

    public static void wörterAusDateiLesen(String dateiPfad) {
        try (BufferedReader br = new BufferedReader(new FileReader(dateiPfad))) {
            String zeile;

            // Lesen der Datei zeilenweise
            while ((zeile = br.readLine()) != null) {
                // Zerlegen der Zeile in Wörter (Annahme: Wörter sind durch Leerzeichen getrennt)
                String[] woerter = zeile.split("\\s+");

                String[] woerter2 = woerter[4].split("-");
                int a = Integer.parseInt(woerter2[0]);
                int b = Integer.parseInt(woerter2[1]);
                int c = Integer.parseInt(woerter2[2]);
                LocalDate l = LocalDate.of(a, b, c);
                woerter2 = woerter[5].split("-");
                a = Integer.parseInt(woerter2[0]);
                b = Integer.parseInt(woerter2[1]);
                c = Integer.parseInt(woerter2[2]);
                LocalDate m = LocalDate.of(a, b, c);
                char ch = woerter[6].charAt(0);
                try{
                    if(woerter[0].charAt(0) == 'a'){
                        new Angestellter(woerter[1], woerter[2], woerter[3], l, m, ch);
                    }
                    if(woerter[0].charAt(0) == 'm'){
                        new Manager(woerter[1], woerter[2], woerter[3], l, m, ch);
                    }
                    if(woerter[0].charAt(0) == 'g'){
                        new Geschaeftsfluehrer(woerter[1], woerter[2], woerter[3], l, m, ch);
                    }
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Mitarbeiter[] getAngestelltenListe() {
        return angestelltenListe;
    }

    public void setAngestelltenListe(Mitarbeiter[] angestelltenListe) throws Exception {
        for (int i = 0; i < angestelltenListe.length; i++) {
            if (angestelltenListe[i] != null) {
                this.angestelltenListe = angestelltenListe;
            }
        }
        if(getAngestelltenListe()==null){
            throw new Exception("angestelltenListe cannot be empty");
        }
    }

    public Mitarbeiter[] getEhemaligenListe() {
        return ehemaligenListe;
    }

    public void setEhemaligenListe(Mitarbeiter[] ehemaligenListe) {
        this.ehemaligenListe = ehemaligenListe;
    }

    public static int getAnzahlMitarbeiter() {
        return anzahlMitarbeiter;
    }

    public static void setAnzahlMitarbeiter(int anzahlMitarbeiter) throws Exception {
        if(anzahlMitarbeiter <= 0){
            throw new Exception("anzahlMitarbeiter must be greater than 0");
        }
        XFirm.anzahlMitarbeiter = anzahlMitarbeiter;
    }

    public void mitarbeiterHinzufuegen(Mitarbeiter mitarbeiter) throws Exception {
        if (mitarbeiter == null) {
            throw new Exception("mitarbeiter must not be null");
        }
        for (int i = 0; i < getAngestelltenListe().length; i++) {
            if (getAngestelltenListe()[i] == null) {
                getAngestelltenListe()[i] = mitarbeiter;
            }
        }
    }

    public void mitarbieterEntfernen(Mitarbeiter mitarbeiter) throws Exception {
        if (mitarbeiter == null) {
            throw new Exception("mitarbeiter must not be null");
        }
        for (int i = 0; i < getAngestelltenListe().length; i++) {
            if (getAngestelltenListe()[i] == mitarbeiter) {
                for (int j = i + 1; j < getEhemaligenListe().length; j++) {
                    if (getEhemaligenListe()[j] != null) {
                        getEhemaligenListe()[j] = mitarbeiter;
                    }
                }
                getAngestelltenListe()[i] = null;
            }
        }
    }
}