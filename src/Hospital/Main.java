package Hospital;

import groovy.lang.GString;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        DatabaseHandler dbHandler = new DatabaseHandler();
        int mctrl = 1;
        String name;
        System.out.println("Welcome to the hospital management system");
        while (mctrl == 1) {
            System.out.println("What DB you want to get access to?");
            System.out.println("1) Doctors");
            System.out.println("2) Drugs");
            System.out.println("3) Patients");
            System.out.println("4) Stop session");
            mctrl = scanner.nextInt();
            switch (mctrl) {
                case 1:
                    doctorsDB();
                    break;
                case 2:
                    drugsDB();
                    break;
                case 3:
                    patientsDB();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
            System.out.println("Want to do something else?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            mctrl = scanner.nextInt();
        }






    }

    public static void doctorsDB(){
        Scanner scanner = new Scanner(System.in);
        DatabaseHandler dbHandler = new DatabaseHandler();
        int ctrl;
        String name, surname;

        System.out.println("Welcome to Doctors DB");
        System.out.println("What is your aim?");
        System.out.println("1) Add new record");
        System.out.println("2) Delete record");
        System.out.println("3) Show all records");
        System.out.println("4) Find record");
        System.out.println("5) Stop session");
        ctrl = scanner.nextInt();


        switch (ctrl){
            case 1:
                addDoctor();
                break;
            case 2:
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter doctor's first name:");
                name = scan.nextLine();
                System.out.println("Enter doctor's surname:");
                surname = scan.nextLine();
                deleteDoctor(name, surname);
                break;
            case 3:
                showDoctors();
                break;
            case 4:
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter doctor's first name:");
                name = scanner1.nextLine();
                System.out.println("Enter doctor's surname:");
                surname = scanner1.nextLine();
                findDoctors(name ,surname);
                break;
            case 5:  System.exit(0);
                break;
        }
    }

    public static void addDoctor(){
        Scanner scanner = new Scanner(System.in);
        DatabaseHandler dbHandler = new DatabaseHandler();
        String s1, s2, s3;
        int i2, i3, i4;
        System.out.println("Enter doctor's name:");
        s1 = scanner.nextLine();
        System.out.println("Enter doctor's surname:");
        s2 = scanner.nextLine();
        System.out.println("Enter doctor's position:");
        s3 = scanner.nextLine();
        System.out.println("Enter doctor's age:");
        i2 = scanner.nextInt();
        System.out.println("Enter doctor's salary:");
        i3 = scanner.nextInt();
        System.out.println("Enter doctor's experience:");
        i4 = scanner.nextInt();
        dbHandler.AddDoctor(s1, s2, i2, s3, i4, i3);
    }
    public static void deleteDoctor(String name, String surname){
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.deleteDoctor(name, surname);
    }
    public static void showDoctors(){
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.showDoctors();
    }
    public static void findDoctors(String firstname, String surname){
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.findDoctor(firstname, surname);
    }

    public static void patientsDB(){
        Scanner scanner = new Scanner(System.in);
        DatabaseHandler dbHandler = new DatabaseHandler();
        int ctrl;
        String name, surname;
        System.out.println("Welcome to Patients DB");
        System.out.println("What is your aim?");
        System.out.println("1) Add new record");
        System.out.println("2) Delete record");
        System.out.println("3) Show all records");
        System.out.println("4) Find record");
        System.out.println("5) Stop session");
        ctrl = scanner.nextInt();
        switch (ctrl){
            case 1:
                addPatient();
                break;
            case 2:
                Scanner scanne = new Scanner(System.in);
                System.out.println("Enter patient's first name:");
                name = scanne.nextLine();
                System.out.println("Enter patient's surname:");
                surname = scanne.nextLine();
                deletePatient(name, surname);
                break;
            case 3:
                showPatients();
                break;
            case 4:
                Scanner scann = new Scanner(System.in);
                System.out.println("Enter patient's name:");
                name = scann.nextLine();
                System.out.println("Enter patient's surname:");
                surname = scann.nextLine();
                findPatients(name, surname);
                break;
            case 5:  System.exit(0);
                break;
        }
    }
    public static void addPatient(){
        Scanner scanner = new Scanner(System.in);
        DatabaseHandler dbHandler = new DatabaseHandler();
        String firstName, SureName, MedicalChamber, MedicalInsurance, Diagnosis;
        int age;
        System.out.println("Enter patient's firstname:");
        firstName = scanner.nextLine();
        System.out.println("Enter patient's surname:");
        SureName = scanner.nextLine();
        System.out.println("Enter patient's chamber:");
        MedicalChamber = scanner.nextLine();
        System.out.println("Do patient have medical insurance:");
        MedicalInsurance = scanner.nextLine();
        System.out.println("Enter patient's diagnosis:");
        Diagnosis = scanner.nextLine();
        System.out.println("Enter patient's age:");
        age = scanner.nextInt();
        dbHandler.AddPatients(firstName,SureName, age, MedicalChamber, MedicalInsurance, Diagnosis);
    }
   public static void deletePatient(String name, String surname){
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.deletePatients(name,surname);
    }
    public static void showPatients(){
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.showPatients();
    }
    public static void findPatients(String name, String surname){
    DatabaseHandler dbHandler = new DatabaseHandler();
    dbHandler.findPatient(name,surname);
}

    public static void drugsDB(){
        Scanner scanner = new Scanner(System.in);
        DatabaseHandler dbHandler = new DatabaseHandler();
        int ctrl;
        String name;
        System.out.println("Welcome to Drugs DB");
        System.out.println("What is your aim?");
        System.out.println("1) Add new record");
        System.out.println("2) Delete record");
        System.out.println("3) Show all records");
        System.out.println("4) Find record");
        System.out.println("5) Stop session");
        ctrl = scanner.nextInt();
        switch (ctrl){
            case 1:
                addDrug();
                break;
            case 2:
                Scanner scanne = new Scanner(System.in);
                System.out.println("Enter drug's name:");
                name = scanne.nextLine();
                deleteDrug(name);
                break;
            case 3:
                showDrugs("*");
                break;
            case 4:
                Scanner scann = new Scanner(System.in);
                System.out.println("Enter drug's name:");
                name = scann.nextLine();
                findDrugs(name);
                break;
            case 5:  System.exit(0);
                break;
        }
    }
    public static void addDrug(){
        Scanner scanner = new Scanner(System.in);
        DatabaseHandler dbHandler = new DatabaseHandler();
        String name,prescription;
        int cost;
        System.out.println("Enter drug's name:");
        name = scanner.nextLine();
        System.out.println("Do drug's buying requires prescription:");
        prescription = scanner.nextLine();
        System.out.println("Enter drug's cost:");
        cost = scanner.nextInt();
        dbHandler.AddDrug(name, cost, prescription);
    }
public static void deleteDrug(String name){
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.deleteDrug(name);
    }
   public static void showDrugs(String name) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.showDrug();
    }
public static void findDrugs(String name){
        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.findDrugs(name);
    }
}
