package Hospital;

import org.codehaus.groovy.ast.stmt.WhileStatement;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler extends Config {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void AddDoctor(String Firstname, String Surname, int Age, String Position, int Experience, int Salary) {
        String insert = "INSERT INTO " + Constant.DOCTORS_TABLE + "(" + Constant.DOCTORS_FIRSTNAME
                + "," + Constant.DOCTORS_SURNAME + "," + Constant.DOCTORS_AGE + "," + Constant.DOCTORS_POSITION + ","
                + Constant.DOCTORS_EXPERIENCE + "," + Constant.DOCTORS_SALARY + ")" + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, Firstname);
            prSt.setString(2, Surname);
            prSt.setInt(3, Age);
            prSt.setString(4, Position);
            prSt.setInt(5, Experience);
            prSt.setInt(6, Salary);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    };
    public void deleteDoctor(String name, String surname){
        String insert = "DELETE FROM " + Constant.DOCTORS_TABLE +" WHERE " + Constant.DOCTORS_FIRSTNAME + " = " + "'" +
                name +"' AND " + Constant.DOCTORS_SURNAME + " = " + "'" +  surname + "'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Record with name " + name + " successfully deleted.");
    }
    public void showDoctors(){
        String insert = "SELECT * FROM " + Constant.DOCTORS_TABLE;

        int i=0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet reSt = prSt.executeQuery(insert);
            System.out.println("ID Firstname Surname Age Position Experience Salary");
            while (reSt.next()){
                System.out.println(reSt.getString("ID") + " " + reSt.getString("Firstname") + " " +
                        reSt.getString("Surname") + " " + reSt.getString("Age") + " " +
                        reSt.getString("Position") + " " + reSt.getString("Experience") + " "
                        + reSt.getString("Salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void findDoctor(String firstname, String surname){
        String insert = "SELECT * FROM " + Constant.DOCTORS_TABLE + " WHERE " + Constant.DOCTORS_FIRSTNAME + " = '"
                + firstname + "' AND " + Constant.DOCTORS_SURNAME + " = '" + surname + "'";

        int i=0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet reSt = prSt.executeQuery(insert);
            System.out.println("ID Firstname Surname Age Position Experience Salary");
            while (reSt.next()){
                System.out.println(reSt.getString("ID") + " " + reSt.getString("Firstname") + " " +
                        reSt.getString("Surname") + " " + reSt.getString("Age") + " " +
                        reSt.getString("Position") + " " + reSt.getString("Experience") + " "
                        + reSt.getString("Salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddDrug(String name, int cost, String prescription) {
        String insert = "INSERT INTO " + Constant.DRUGS_TABLE + "(" + Constant.DRUGS_NAME + "," + Constant.DRUGS_COST + ","
                + Constant.DRUGS_PRESCRIPTION + ")" + "VALUES(?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, name);
            prSt.setInt(2, cost);
            prSt.setString(3, prescription);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    };
    public void deleteDrug(String name) {
        String delete = "DELETE FROM " + Constant.DRUGS_TABLE + " WHERE " + Constant.DRUGS_NAME + "=" + "'" + name +"'";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    };
    
    public void showDrug(){
        String show = "SELECT * FROM " + Constant.DRUGS_TABLE;
        int i=0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(show);
            ResultSet reSt = prSt.executeQuery(show);
            System.out.println( " Name Cost Prescription for medicine");
            while (reSt.next()){
                System.out.println(reSt.getString("Name") + " " + reSt.getString("Cost") + " " +
                        reSt.getString("PrescriptionForMedicine"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void findDrugs(String name){
        String insert = "SELECT * FROM " + Constant.DRUGS_TABLE + " WHERE " + Constant.DRUGS_NAME + " = '"
                + name + "'";
        int i=0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet reSt = prSt.executeQuery(insert);
            System.out.println( "Name Cost PrescriptionForMedicine");
            while (reSt.next()){
                System.out.println(reSt.getString("Name") + " " + reSt.getString("Cost") + " " +
                        reSt.getString("PrescriptionForMedicine"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddPatients(String firstName, String SureName,int age, String MedicalChamber, String MedicalInsurance, String Diagnosis){
        String insert = "INSERT INTO " + Constant.PATIENTS_TABLE+ "("+Constant.PATIENTS_FIRSTNAME + "," + Constant.PATIENTS_SURNAME + ","  + Constant.PATIENTS_AGE
                + "," + Constant.PATIENTS_CHAMBER+ "," + Constant.PATIENTS_INSURANCE+ "," + Constant.PATIENTS_DIAGNOSIS +")" +  "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, firstName);
            prSt.setString(2, SureName);
            prSt.setInt(3, age);
            prSt.setString(4, MedicalChamber);
            prSt.setString(5, MedicalInsurance);
            prSt.setString(6, Diagnosis);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    };
    public void deletePatients(String name, String surname){
        String insert = "DELETE FROM " + Constant.PATIENTS_TABLE +" WHERE " + Constant.PATIENTS_FIRSTNAME + " = " + "'" + name +"'"
                + " AND " + Hospital.Constant.PATIENTS_SURNAME + " = " + "'" + surname + "'" ;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Record with name " + name + " successfully deleted.");
    };
    
    public void showPatients(){
        String show2 = "SELECT * FROM " + Constant.PATIENTS_TABLE;
        int i=0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(show2);
            ResultSet reSt = prSt.executeQuery(show2);
            System.out.println( "idPatients Firstname Surename Age Medical Chamber Medical Insurance Diagnosis ");
            while (reSt.next()){
                System.out.println(reSt.getString("idPatients") + " " +
                                reSt.getString("Firstname") + " " + reSt.getString("Surname") + " " +
                        reSt.getString("Age") + " " + reSt.getString("Medical Chamber")+ " " +
                                reSt.getString("MedicalInsurance")+ " " + reSt.getString("Diagnosis") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void findPatients(String firstname, String surname){
        String insert = "SELECT * FROM " + Constant.PATIENTS_TABLE + " WHERE " + Constant.PATIENTS_FIRSTNAME + " = '"
                + firstname + "' AND " + Constant.PATIENTS_SURNAME + " = '" + surname + "'";
        int i=0;
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            ResultSet reSt = prSt.executeQuery(insert);
            System.out.println( "idPatients Firstname Surname Age Medical Chamber Medical Insurance Diagnosis ");
            while (reSt.next()){
                System.out.println(reSt.getString("idPatients") + " " +
                                reSt.getString("Firstname") + " " + reSt.getString("Surname") +
                        reSt.getString("Age") + " " + reSt.getString("MedicalChamber")+ " " +
                                reSt.getString("MedicalInsurance")+ " " + reSt.getString("Diagnosis") );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
