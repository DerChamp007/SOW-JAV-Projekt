import java.time.LocalDate;
/*
@author: Randip Singh, Luis Ott
@version: 1.0
 */
public class Manager extends Mitarbeiter{
    private double ManagerLohn;
    private double ProvisionSatz;
    private double gewinn;
    private String kennung;

    public Manager(String nachname, String vorname, String adresse, LocalDate geburtsdatum, LocalDate eintrittsdatum,char geschlecht, double managerLohn, double provisionSatz) throws Exception {
        super(nachname, vorname, adresse, geburtsdatum, eintrittsdatum, geschlecht);
        try{
            setManagerLohn(managerLohn);
            setProvisionSatz(provisionSatz);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        kennung = super.kennung();
    }
    @Override
    public String getKennung() {
        return kennung;
    }

    public double getManagerLohn() {
        return ManagerLohn;
    }

    public void setManagerLohn(double managerLohn) throws Exception{
        if (ManagerLohn <= 0) {
            throw new Exception("Manager Lohn should be greater than 0.");
        }
        ManagerLohn = managerLohn;
    }

    public double getProvisionSatz() {
        return ProvisionSatz;
    }

    public void setProvisionSatz(double provisionSatz) throws Exception{
        if (ProvisionSatz <= 0) {
            throw new Exception("Provision Satz should be greater than 0.");
        }
        ProvisionSatz = provisionSatz;
    }
    public double ProvisionBerechnen(){
        if(gewinn <= 0){
            return 0;
        }
        double z = getGewinn();
        setGewinn(0);
        return z * ProvisionSatz;
    }

    public void Lohnerhoehen(double Prozentsatz) throws Exception {
        if (Prozentsatz > 0 && Prozentsatz <= 10){
            ManagerLohn += ManagerLohn * (Prozentsatz / 100);
        } else {
            throw new Exception("Prozentsatz should be greater than 0. and not more than 10.");
        }
    }

    public double getGewinn() {
        return gewinn;
    }

    public void setGewinn(double gewinn) {
        this.gewinn = gewinn;
    }

    @Override
    public void LohnErhoehen() {
    }

    @Override
    public double GehaltBerechnen() {
        return ManagerLohn + ProvisionBerechnen();
    }

    @Override
    public String toString() {
        return super.toString() +
                "ManagerLohn=" + ManagerLohn +
                "€, ProvisionSatz=" + ProvisionSatz +
                "%, gewinn=" + gewinn +
                "€, kennung='" + kennung + '\'' ;
    }
}
