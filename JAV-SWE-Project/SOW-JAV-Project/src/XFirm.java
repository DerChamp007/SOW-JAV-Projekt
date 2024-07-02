import java.time.LocalDate;

public class XFirm {
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
    public int LaengsterMitarbeiter(){
        int temp = LocalDate.now().getYear();
        for (int i = 0; i < angestelltenListe.length; i++) {
            if (angestelltenListe[i] != null) {
                if (angestelltenListe[i].getEintrittsdatum().getYear() < temp) {
                    temp = angestelltenListe[i].getEintrittsdatum().getYear();
                    System.out.println("The longest employee of the Company is: " + angestelltenListe[i].getVorname()+ " "+ angestelltenListe[i].getNachname());
                }
            }
        }
        return LocalDate.now().getYear() - temp;
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

}
