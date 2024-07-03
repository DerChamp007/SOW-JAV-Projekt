import java.time.LocalDate;
import java.util.Arrays;

import static java.lang.String.valueOf;

/*
@author: Randip Singh, Luis Ott
@version: 1.0
 */
public abstract class Mitarbeiter {
    private String Nachname;
    private String Vorname;
    private String Adresse;
    private char geschlecht;
    private LocalDate Geburtsdatum;
    private LocalDate Eintrittsdatum;
    private LocalDate Austrittsdatum;
    private Praemien[] praemien = new Praemien[10];
    private static int zaehler = 0;

    public Mitarbeiter(String nachname, String vorname, String adresse, LocalDate geburtsdatum, LocalDate eintrittsdatum, char geschlecht) throws Exception{
        try {
            setGeschlecht(geschlecht);
            setNachname(nachname);
            setVorname(vorname);
            setAdresse(adresse);
            setGeburtsdatum(geburtsdatum);
            setEintrittsdatum(eintrittsdatum);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        kennung();
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

    public char getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(char geschlecht) throws Exception {
        if(geschlecht != 'w' && geschlecht != 'm' && geschlecht != 'd'){
            throw new Exception("Geschlecht is invalid");
        }
        this.geschlecht = geschlecht;
    }

    public String kennung(){
        String kennung = getNachname().substring(0,1).concat(getVorname().substring(0,1)).concat(valueOf(getClass()).substring(0,1)).concat(valueOf(getGeschlecht())).concat(valueOf(getGeburtsdatum().getYear()));
        return kennung;
    }

    public void praemie(double p){
        praemien[zaehler] = new Praemien(p);
        zaehler++;
    }

    public double getPraemie(){
        double wert = 0;
        for (int i = 0; i < zaehler; i++) {
            wert += praemien[i].getWert();
        }
        return wert;
    }
    public abstract void LohnErhoehen();
    public abstract double GehaltBerechnen();
    public abstract String getKennung();

    @Override
    public String toString() {
        return "Mitarbeiter: " +
                "Nachname='" + Nachname + '\'' +
                ", Vorname='" + Vorname + '\'' +
                ", Adresse='" + Adresse + '\'' +
                ", geschlecht=" + geschlecht +
                ", Geburtsdatum=" + Geburtsdatum +
                ", Eintrittsdatum=" + Eintrittsdatum +
                ", Austrittsdatum=" + Austrittsdatum +
                ", praemien=" + getPraemie() +
                '€';
    }
}
