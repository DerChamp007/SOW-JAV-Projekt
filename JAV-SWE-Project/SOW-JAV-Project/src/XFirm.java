import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.FileWriter;

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
        String dateiPfad = "../../Text.txt";

        // Methode aufrufen, um die Wörter aus der Datei zu lesen
        woerterAusDateiLesen(dateiPfad);

    }

    public static void woerterAusDateiLesen(String dateiPfad) {
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
                double x = Double.parseDouble(woerter[7]);
                double y = Double.parseDouble(woerter[8]);
                double z = 0;
                double w = 0;
                if(woerter[9]!=null){
                    z = Double.parseDouble(woerter[9]);
                }
                if(woerter[10]!=null){
                    w = Double.parseDouble(woerter[10]);
                }
                try{
                    if(woerter[0].equals("Angestellter")){
                        new Angestellter(woerter[1], woerter[2], woerter[3], l, m, ch, x, y, z, w);
                    }
                    if(woerter[0].equals("Manager")){
                        new Manager(woerter[1], woerter[2], woerter[3], l, m, ch, x, y);
                    }
                    if(woerter[0].equals("Geschaeftsfuehrer")){
                        new Geschaeftsfuehrer(woerter[1], woerter[2], woerter[3], l, m, ch, x, y, z);
                    }
                    anzahlMitarbeiter++;
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

    public double MinLohn(){
        double temp = MaxLohn();
        for (int i = 0; i < angestelltenListe.length; i++) {
            if (angestelltenListe[i] != null) {
                if (angestelltenListe[i].GehaltBerechnen() < temp){
                    temp = angestelltenListe[i].GehaltBerechnen();
                }
            } else if (angestelltenListe[i] == null) {
                System.out.println("The List is empty at index " + i);
                break;
            }
        }
        return temp;
    }

    public double MaxLohn(){
        double temp = 0.0;
        for (int i = 0; i < angestelltenListe.length; i++) {
            if (angestelltenListe[i] != null) {
                if (angestelltenListe[i].GehaltBerechnen() > temp){
                    temp = angestelltenListe[i].GehaltBerechnen();
                }
            } else if (angestelltenListe[i] == null) {
                System.out.println("The List is empty at index " + i);
                break;
            }
        }
        return temp;
    }

    public double VerdienstSpanne(){
        return MaxLohn() - MinLohn();
    }

    public double DurchschittsAlter(){
        double temp = 0.0;
        for (int i = 0; i < angestelltenListe.length; i++) {
            if (angestelltenListe[i] != null) {
                temp += angestelltenListe[i].getGeburtsdatum().getYear();
            } else if (angestelltenListe[i] == null) {
                System.out.println("The List is empty at index " + i);
                break;
            }
        }
        return temp / getAnzahlMitarbeiter();
    }

    public Mitarbeiter LaengsterMitarbeiter(){
        int temp = LocalDate.now().getYear();
        Mitarbeiter mitarbeiter = null;
        for (int i = 0; i < angestelltenListe.length; i++) {
            if (angestelltenListe[i] != null) {
                if (angestelltenListe[i].getEintrittsdatum().getYear() < temp) {
                    mitarbeiter = angestelltenListe[i];
                    temp = angestelltenListe[i].getEintrittsdatum().getYear();
                }
            }
        }
        return mitarbeiter;
    }

    public double GeschlechterAnteilW(){
        int w = 0;
        for (int i = 0; i < angestelltenListe.length; i++) {
            if (angestelltenListe[i] != null) {
                if (angestelltenListe[i].getGeschlecht() == 'w') {
                    w++;
                }
            }
        }
        return (w / getAnzahlMitarbeiter()) * 100;
    }

    public double GeschlechterAnteilM(){
        int m = 0;
        for (int i = 0; i < angestelltenListe.length; i++) {
            if (angestelltenListe[i] != null) {
                if (angestelltenListe[i].getGeschlecht() == 'm') {
                    m++;
                } else if (angestelltenListe[i] == null) {
                    System.out.println("The List is empty at index " + i);
                    break;
                }
            }
        }
        return ((double) m / getAnzahlMitarbeiter()) * 100;
    }

    public void gehaltsabrechnung(int monat){
    BufferedWriter writer = null;
    try {
        // BufferedWriter erstellen und mit einem FileWriter kombinieren
        writer = new BufferedWriter(new FileWriter("Gehaltsabrechnung2024_" + monat + ".txt"));

        // Schreiben von Text in die Datei
        double gehalt = 0;
        for (int i = 0; i < angestelltenListe.length; i++) {
            if (angestelltenListe[i] != null) {
                gehalt = angestelltenListe[i].GehaltBerechnen();
                writer.write(angestelltenListe[i].getKennung() + angestelltenListe[i].getNachname() + "Verdient: " + gehalt + " €\n");
            }
        }

        // Weitere Schreiboperationen hier

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        // Sicherstellen, dass der BufferedWriter geschlossen wird
        try {
            if (writer != null) writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

}
