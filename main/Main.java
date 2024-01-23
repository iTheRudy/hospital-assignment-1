package main;

import main.*;

public class Main {
    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();

        Covid19Patient covid19Patient = new Covid19Patient(1, "fName", "lName", 28, 50);

        patientList.add(covid19Patient);

        covid19Patient.toString();
//        System.out.println("Options");
//        System.out.println("Admit a patient");
//        System.out.println("Print patient information");
//        System.out.println("Submit a PCR Result");
//        System.out.println("Do rounds");
//        System.out.println("Discharge patient");
//        System.out.println("Exit");


    }
}
