import java.time.LocalDate;
/*
@author: Randip Singh, Luis Ott
@version: 1.0
 */
public class Geschaeftsfluehrer extends Manager{
    private double geschaeftsfluehrerZulage;
    public Geschaeftsfluehrer(char geschlecht, String nachname, String vorname, String adresse, LocalDate geburtsdatum, LocalDate eintrittsdatum, double managerLohn, double provisionSatz, double geschaeftsfluehrerZulage) throws Exception {
        super(geschlecht, nachname, vorname, adresse, geburtsdatum, eintrittsdatum,   managerLohn, provisionSatz);

    }

    public Geschaeftsfluehrer(String nachname, String vorname, String adresse, LocalDate geburtsdatum, LocalDate eintrittsdatum, char geschlecht) throws Exception {
        super(nachname, vorname, adresse, geburtsdatum, eintrittsdatum, geschlecht);
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
}
