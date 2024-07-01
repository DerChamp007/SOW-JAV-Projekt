import java.time.LocalDate;

public abstract class Mitarbeiter {
    private String Nachname;
    private String Vorname;
    private String Adresse;
    private LocalDate Geburtsdatum;
    private LocalDate Eintrittsdatum;
    private LocalDate Austrittsdatum;

    public Mitarbeiter(String nachname, String vorname, String adresse, LocalDate geburtsdatum, LocalDate eintrittsdatum) throws Exception{
        this.Nachname = nachname;
        this.Vorname = vorname;
        this.Adresse = adresse;
        this.Geburtsdatum = geburtsdatum;
        this.Eintrittsdatum = eintrittsdatum;
        this.Austrittsdatum = null;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String nachname) throws Exception {
        if (nachname.isEmpty()){
            throw new Exception("Nachname is empty");
        }
        Nachname = nachname;

    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) throws Exception {
        if (vorname.isEmpty()){
            throw new Exception("Vorname is empty");
        }
        Vorname = vorname;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) throws Exception {
        if (adresse.isEmpty()){
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
             }else if (geburtsdatum.isBefore(LocalDate.now())){
                throw new Exception("Geburtsdatum is before now");
        }
        Geburtsdatum = geburtsdatum;
    }

    public LocalDate getEintrittsdatum() {
        return Eintrittsdatum;
    }

    public void setEintrittsdatum(LocalDate eintrittsdatum) throws Exception {
        if (eintrittsdatum == null){
            throw new Exception("Eintrittsdatum is empty");
        } else if (eintrittsdatum.isAfter(LocalDate.now())){
            throw new Exception("Eintrittsdatum is after now");
        }
        Eintrittsdatum = eintrittsdatum;
    }

    public LocalDate getAustrittsdatum() {
        return Austrittsdatum;
    }

    public void setAustrittsdatum(LocalDate austrittsdatum) throws Exception {
        if (austrittsdatum == null){
            throw new Exception("Austrittsdatum is empty");
        } else if (austrittsdatum.isAfter(LocalDate.now())){
            throw new Exception("Austrittsdatum cannot be after now");
        }
        Austrittsdatum = austrittsdatum;
    }
    public abstract void LohnErhoehen();

    public abstract double GehaltBerechnen();
}
