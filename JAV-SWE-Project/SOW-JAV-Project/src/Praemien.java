import java.time.LocalDate;

public class Praemien {
    private double wert;
    private LocalDate datum;
    public Praemien(double wert) {
        try {
            setWert(wert);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        datum = LocalDate.now();
    }

    public double getWert() {
        return wert;
    }

    public void setWert(double wert) throws Exception{
        if (wert <= 0) {
            throw new Exception("Wert must be greater than 0");
        }
        this.wert = wert;
    }

    public LocalDate getDatum() {
        return datum;
    }

}
