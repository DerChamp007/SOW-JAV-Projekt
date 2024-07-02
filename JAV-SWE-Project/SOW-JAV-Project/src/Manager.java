public class Manager {
    private double ManagerLohn;
    private double ProvisionSatz;

    public Manager(double managerLohn, double provisionSatz) {
        ManagerLohn = managerLohn;
        ProvisionSatz = provisionSatz;
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
        return ManagerLohn * ProvisionSatz;
    }
    public void LohnErhoehen(double Prozentsatz){
        if (Prozentsatz > 0){
        ManagerLohn += ManagerLohn * (Prozentsatz / 100);
        } else {
            System.out.println("Prozentsatz should be greater than 0.");
        }
    }
}
