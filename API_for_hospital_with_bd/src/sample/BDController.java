package sample;


import java.sql.*;
import java.util.ArrayList;

public class BDController {
    Connection con;
    String url;
    String user;
    String pass;

    public int getMaxId() {
        int returned = 0;
        PreparedStatement stat;
        ResultSet rs;
        String sql = "SELECT MAX(nummed) AS max_nummed FROM patient";
        try{
            stat = con.prepareStatement(sql);
            rs = stat.executeQuery();
            if (rs.next()) {
                returned = rs.getInt("max_nummed");
            }
            return  returned;
        }catch (SQLException ex){
            ex.printStackTrace();
            return  0;
        }

    }

    //Добавить диагноз
    public void addDiagnos(String id, String diagnosis) throws SQLException {
        String str = "\""+id+
                "\",\""+diagnosis+"\"";

        Statement stmt = con.createStatement();
        stmt.executeUpdate ( "INSERT INTO diagnosis " +
                "VALUES ("+str+")");

    }
    public ArrayList<Diagnosis> getDiagnosis(){
        ArrayList<Diagnosis> res = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery (
                    "SELECT id, diagnosis FROM diagnosis");
            while(rs.next()){
                res.add(new Diagnosis(rs.getInt("id"),
                        rs.getString("diagnosis")
                ));

            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Добавить запись в файл
    public void addPatient(Patient patient){
        String str ="default"+
                ", \""+patient.getSurname()+
                "\", \""+patient.getName()+
                "\", \""+patient.getPatronymic()+
                "\", \""+patient.getAdress()+
                "\", \""+patient.getPhone()+
                "\", \""+patient.getNumMed()+ "\"";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate ( "INSERT INTO patient " +
                    "VALUES ("+str+")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //Удалить запись из файла!!
    public void removePatient(int id){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate ( "DELETE FROM patient WHERE id='"+id+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Patient getPatient(int nummed){

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery (
                    "SELECT surname, name, patronymic, adress, phone, nummed FROM patient");
            while(rs.next()){
                if(rs.getInt("nummed") == nummed)
                    return new Patient(rs.getString("Surname"),
                            rs.getString("Name"),
                            rs.getString("Patronymic"),
                            rs.getString("Adress"),
                            rs.getString("Phone"),
                            rs.getInt("NumMed"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addPatientDiagnos(int MedicalNumber, String Diagnos) throws SQLException {
        String str = MedicalNumber +
                ", \""+Diagnos+ "\"";
        Statement stmt = con.createStatement();
        stmt.executeUpdate ( "INSERT INTO patient_diagnosis " +
                "VALUES ("+str+")");

    }

    public  ArrayList<String> getPatientDiagnos(int nummed){
        ArrayList<String> res = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery (
                    "SELECT nummed, diagnosis FROM patient_diagnosis");
            while(rs.next()){
                if(rs.getInt("nummed") == nummed)
                    res.add(rs.getString("diagnosis"));

            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    //Возвращает HashSet со всема записями
    public ArrayList<Patient> getPatient() {
        ArrayList<Patient> res = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery (
                    "SELECT surname, name, patronymic, adress, phone, nummed FROM patient");
            while(rs.next()){
                res.add(new Patient(rs.getString("Surname"),
                        rs.getString("Name"),
                        rs.getString("Patronymic"),
                        rs.getString("Adress"),
                        rs.getString("Phone"),
                        rs.getInt("NumMed")));
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
    public BDController(String url, String user, String pass){
        this.url = url;
        this.user = user;
        this.pass = pass;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
