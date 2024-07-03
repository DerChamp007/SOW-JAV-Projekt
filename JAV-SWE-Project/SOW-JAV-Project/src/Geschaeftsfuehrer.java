import java.time.LocalDate;
/*
@author: Randip Singh, Luis Ott
@version: 1.0
 */
public class Geschaeftsfuehrer extends Manager{
    private String kennung;
    private double geschaeftsfluehrerZulage;
    public Geschaeftsfuehrer(String nachname, String vorname, String adresse, LocalDate geburtsdatum, LocalDate eintrittsdatum, char geschlecht, double managerLohn, double provisionSatz, double geschaeftsfluehrerZulage) throws Exception {
        super( nachname, vorname, adresse, geburtsdatum, eintrittsdatum,geschlecht,   managerLohn, provisionSatz);
        kennung = super.kennung();
    }

    @Override
    public String getKennung() {
        return kennung;
    }

    public double getGeschaeftsfluehrerZulage() {
        return geschaeftsfluehrerZulage;
    }

    public void setGeschaeftsfluehrerZulage(double geschaeftsfluehrerZulage) throws Exception  {
        if(geschaeftsfluehrerZulage < 0){
            throw new Exception("GeschaeftsfluehrerZulage cannot be negative");
        }
        this.geschaeftsfluehrerZulage = geschaeftsfluehrerZulage;
    }

    @Override
    public double GehaltBerechnen() {
        return super.GehaltBerechnen()+geschaeftsfluehrerZulage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "geschaeftsfluehrerZulage=" + geschaeftsfluehrerZulage+ '\'' +
                ", kennung='" + kennung +
                "€";
    }
}
