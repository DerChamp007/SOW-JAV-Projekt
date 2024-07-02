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

    
}
