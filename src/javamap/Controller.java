package javamap;

import java.sql.*;
import java.util.ArrayList;

public class Controller {
         static Connection con = null;
    static ArrayList locations;
    public static ArrayList GetAllGeo(){
         try {
            locations = new ArrayList<Mapping>();
            String query = "SELECT * FROM `mapping`";
            con = DriverManager.getConnection("jdbc:mysql://localhost/coda", "root", "");
            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(query);
            Mapping location;
            while(rs.next()){
                String emp = rs.getString("emp");
                Double lon = rs.getDouble("lon");
                Double lat = rs.getDouble("lat");
                float temp = rs.getFloat("temp");
                float taux = rs.getFloat("taux");
                int spc = rs.getInt("espace");
                int pop = rs.getInt("population");

                
                location = new Mapping(emp , lon ,lat,temp, taux , spc , pop);
                location.setEmp(emp);
                location.setLon(lon);
                location.setLat(lat);
                  location.setTemp(temp);
                location.setTaux(taux);
                location.setSpc(spc);
                location.setPop(pop);
                locations.add(location);
               
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
            return locations;

    }
    public static void AddGeo(Mapping location){
        try {
            String query = "INSERT INTO `mapping`(`emp`, `lon`, `lat`, `temp`, `taux`, `espace`, `population`) VALUES (?,?,?,?,?,?,?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost/coda", "root", "");
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,location.getEmp());
            pst.setDouble(2, location.getLon());
            pst.setDouble(3, location.getLat());
            pst.setFloat(4, location.getTemp());
            pst.setFloat(5, location.getTaux());
            pst.setInt(6,location.getSpc());
            pst.setInt(7,location.getPop());
            pst.executeUpdate();            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
    }}
//     
        
//    Connection con;
//    PreparedStatement st;
//    ResultSet res;
//
//    void connexion() {
//        try {
//            String url = "jdbc:mysql://localhost/coda";
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection(url, "root", "");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    void deconnexion() {
//        try {
//            st.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    ArrayList<Mapping> recupererEmplacements() {
//        connexion();
//        ArrayList<Mapping> liste = new ArrayList<Mapping>();
//        try {
//            st = con.prepareStatement("SELECT * FROM `mapping`");
//            res = st.executeQuery();
//            while (res.next() == true) {
//                String emp = res.getString("Emp");
//                String lal = res.getString("lat");
//                String log = res.getString("lon");
//
//                Mapping e = new Mapping();
//                e.setEmpacement(emp);
//                e.setLal(lal);
//                e.setLon(log);
//
//                liste.add(e);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        deconnexion();
//        return liste;
//    }
//
//    void ajouterEmplacement(String emplacement, String laltitude, String longitude) {
//        connexion();
//        try {
//            st = con.prepareStatement("INSERT INTO  `mapping`(emp, lat, lon) VALUES (?,?,?)");
//            st.setString(1, emplacement);
//            st.setString(2, laltitude);
//            st.setString(3, longitude);
//
//            st.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    

