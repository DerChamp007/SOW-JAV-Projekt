import java.time.LocalDate;

public class Geschaeftsfluehrer extends Manager{
    private double geschaeftsfluehrerZulage;
    public Geschaeftsfluehrer(char geschlecht, String nachname, String vorname, String adresse, LocalDate geburtsdatum, LocalDate eintrittsdatum, double managerLohn, double provisionSatz, double geschaeftsfluehrerZulage) throws Exception {
        super(geschlecht, nachname, vorname, adresse, geburtsdatum, eintrittsdatum,   managerLohn, provisionSatz);

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

    public void Lohnerhoehen(double Prozentsatz) throws Exception {
        super.LohnErhoehen(Prozentsatz);
    }

    @Override
    public double GehaltBerechnen() {
        return super.GehaltBerechnen()+geschaeftsfluehrerZulage;
    }
}
