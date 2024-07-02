import java.time.LocalDate;
/*
@author: Randip Singh, Luis Ott
@version: 1.0
 */
public class Angestellter extends Mitarbeiter{
    private double stundenlohn;
    private double ueberstundenlohn;
    private double stundenanzahl;
    private double ueberstundenanzahl;

    public Angestellter(char geschlecht, String nachname, String vorname, String adresse, LocalDate geburtsdatum, LocalDate eintrittsdatum, double stundenlohn, double ueberstundenlohn, double studnenanzahl, double ueberstundenanzahl) throws Exception {
        super(nachname, vorname, adresse, geburtsdatum, eintrittsdatum, geschlecht);
        try{
            setStundenlohn(stundenlohn);
            setUeberstundenlohn(ueberstundenlohn);
            setStundenanzahl(studnenanzahl);
            setUeberstundenanzahl(ueberstundenanzahl);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Angestellter(String nachname, String vorname, String adresse, LocalDate geburtsdatum, LocalDate eintrittsdatum, char geschlecht) throws Exception {
        super(nachname, vorname, adresse, geburtsdatum, eintrittsdatum, geschlecht);
    }

    public double getStundenlohn() {
        return stundenlohn;
    }

    public void setStundenlohn(double stundenlohn) throws Exception {
        if (stundenlohn <= 0){
            throw new Exception("Stundenlohn should be greater than 0");
        }
        this.stundenlohn = stundenlohn;
    }

    public double getUeberstundenlohn() {
        return ueberstundenlohn;
    }

    public void setUeberstundenlohn(double ueberstundenlohn) throws Exception {
        if (ueberstundenlohn <= 0){
            throw new Exception("Ueberstundenlohn should be greater than 0");
        }
        this.ueberstundenlohn = ueberstundenlohn;
    }

    public double getStundenanzahl() {
        return stundenanzahl;
    }

    public void setStundenanzahl(double stundenanzahl) throws Exception {
        if (stundenanzahl <= 0){
            throw new Exception("Stundenanzahl should be greater than 0");
        }
        this.stundenanzahl = stundenanzahl;
    }

    public double getUeberstundenanzahl() {
        return ueberstundenanzahl;
    }

    public void setUeberstundenanzahl(double ueberstundenanzahl) throws Exception {
        if (ueberstundenanzahl < 0){
            throw new Exception("Ueberstundenanzahl cannot be negative");
        }
        this.ueberstundenanzahl = ueberstundenanzahl;
    }

    public void LohnErhoehen() {
        stundenlohn += stundenlohn * (5 / 100);
        ueberstundenlohn += ueberstundenlohn * (5 / 100);
    }

    @Override
    public double GehaltBerechnen() {
        return 0;
    }
}
