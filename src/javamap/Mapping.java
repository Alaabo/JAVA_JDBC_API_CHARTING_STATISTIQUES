package javamap;

public class Mapping {
   
   private String emp;
   private Double lon,lat;
   private float temp,taux ;
   int spc,pop;

    public String getEmp() {
        return emp;
    }

    public Double getLon() {
        return lon;
    }

    public Double getLat() {
        return lat;
    }

    public float getTemp() {
        return temp;
    }

    public float getTaux() {
        return taux;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    public Mapping() {
    }

    public Mapping(String emp, Double lon, Double lat) {
        this.emp = emp;
        this.lon = lon;
        this.lat = lat;
    }

    public Mapping(String emp, Double lon, Double lat, float temp, float taux, int spc, int pop) {
        this.emp = emp;
        this.lon = lon;
        this.lat = lat;
        this.temp = temp;
        this.taux = taux;
        this.spc = spc;
        this.pop = pop;
    }    

    public int getSpc() {
        return spc;
    }

    public void setSpc(int spc) {
        this.spc = spc;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }
}
