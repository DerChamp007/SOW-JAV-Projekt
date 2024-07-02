import java.time.LocalDate;

public abstract class Mitarbeiter {
    private String Nachname;
    private String Vorname;
    private String Adresse;
    private LocalDate Geburtsdatum;
    private LocalDate Eintrittsdatum;
    private LocalDate Austrittsdatum;

    public Mitarbeiter(String nachname, String vorname, String adresse, LocalDate geburtsdatum, LocalDate eintrittsdatum) throws Exception{
        try {
            setNachname(nachname);
            setVorname(vorname);
            setAdresse(adresse);
            setGeburtsdatum(geburtsdatum);
            setEintrittsdatum(eintrittsdatum);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) throws Exception {
        if (nachname.isBlank()){
            throw new Exception("Nachname is empty");
        }
        Nachname = nachname;

    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) throws Exception {
        if (vorname.isBlank()){
            throw new Exception("Vorname is empty");
        }
        Vorname = vorname;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) throws Exception {
        if (adresse.isBlank()){
            throw new Exception("Adresse is empty");
        }
        Adresse = adresse;
    }

    public LocalDate getGeburtsdatum() {
        return Geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) throws Exception {
        if (geburtsdatum == null){
            throw new Exception("Geburtsdatum is empty");
             }else if (geburtsdatum.getYear()>LocalDate.now().getYear()-13){
                throw new Exception("This is too young");
        }
        Geburtsdatum = geburtsdatum;
    }

    public LocalDate getEintrittsdatum() {
        return Eintrittsdatum;
    }

    public void setEintrittsdatum(LocalDate eintrittsdatum) throws Exception {
        if (eintrittsdatum == null){
            throw new Exception("Eintrittsdatum is empty");
        }
        Eintrittsdatum = eintrittsdatum;
    }

    public LocalDate getAustrittsdatum() {
        return Austrittsdatum;
    }

    public void setAustrittsdatum(LocalDate austrittsdatum) throws Exception {
        if (austrittsdatum == null){
            throw new Exception("Austrittsdatum is empty");
        }
        Austrittsdatum = austrittsdatum;
    }
    public abstract void LohnErhoehen();

    public abstract double GehaltBerechnen();
}
