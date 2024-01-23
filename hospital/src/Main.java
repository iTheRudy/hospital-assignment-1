
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static int idCounter = 0;

    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();

        Covid19Patient covid19Patient = new Covid19Patient(1, "fName", "lName", 28, 50);

        patientList.add(covid19Patient);

        covid19Patient.toString();
        System.out.println(covid19Patient.toString());
        System.out.println("1. Admit a patient");
        System.out.println("2. Print patient information");
        System.out.println("3. Submit a PCR Result");
        System.out.println("4. Do rounds");
        System.out.println("5. Discharge patient");
        System.out.println("6. Exit");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        switch (userInput) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }


    }

    public void admitPatient(List<Patient> patientList) {
        System.out.println("Pcr test result");
        System.out.println("1. Negative");
        System.out.println("2. Positive");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        switch (userInput) {
            case 1:
                patientList.add(createRegularPatient());
                break;
            case 2:
                patientList.add(createCovid19Patient());
                break;
            default:
                break;
        }
    }

    public void printPatientInformation(List<Patient> patientList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the patient id");
        int id = sc.nextInt();
        Patient patient = searchPatient(patientList, id);
        System.out.println(patient.toString());
    }

    public void submitPCRTestResult(List<Patient> patientList) {
        System.out.println("Enter user id");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Patient patient = searchPatient(patientList, id);
        System.out.println("Enter PCR Test Result: ");
        System.out.println("1. Negative");
        System.out.println("2. Positive");
        int userInput = sc.nextInt();
        switch (userInput) {
            case 1:
                patientList.add(createRegularPatient());
                break;
            case 2:
                patientList.add(createCovid19Patient());
                break;
            default:
                break;
        }

    }

    public Patient convertRegularPatientToCovid19Patient(List<Patient> patientList, RegularPatient patient) {
        Scanner sc = new Scanner(System.in);
        String fName;
        String lName;
        int age;
        System.out.println("Enter temperature: ");
        int temperature = sc.nextInt();
        Covid19Patient covid19Patient =
                new Covid19Patient(patient.getId(), patient.getfName(), patient.getlName(), patient.age, temperature);
        dismissPatient(patientList, patient);
        patientList.add(covid19Patient);
        return covid19Patient;
    }

    public void dismissPatient(List<Patient> patientList, Patient patient) {
        int patientListSize = patientList.size();

        for (int i = 0; i < patientListSize; i++) {
            if (patientList.get(i).getId() == patient.getId()) {
                patientList.remove(i);
                break;
            }
        }
    }

    public Patient searchPatient(List<Patient> patientList, int id) {
        List<Patient> filteredList =
                patientList.stream().filter(patient -> patient.getId() == id).collect(Collectors.toList());
        return filteredList.get(0);
    }

    public Covid19Patient createCovid19Patient() {
        Scanner sc = new Scanner(System.in);
        String fName;
        String lName;
        int age;
        System.out.println("Enter first name: ");
        fName = sc.next();
        System.out.println("Enter last name: ");
        lName = sc.next();
        System.out.println("Enter age: ");
        age = sc.nextInt();
        System.out.println("Enter temperature: ");
        int temperature = sc.nextInt();
        Covid19Patient covid19Patient = new Covid19Patient(idCounter++, fName, lName, age, temperature);
        return covid19Patient;
    }


    public RegularPatient createRegularPatient() {
        Scanner sc = new Scanner(System.in);
        String fName;
        String lName;
        int age;
        String symptom = "";
        int userInput;
        boolean validInput = false;
        System.out.println("Enter first name: ");
        fName = sc.next();
        System.out.println("Enter last name: ");
        lName = sc.next();
        System.out.println("Enter age: ");
        age = sc.nextInt();
        while (!validInput) {
            System.out.println("Select your symptom");
            System.out.println("1. coughing");
            System.out.println("2. runny nose");
            System.out.println("3. stuffy nose");
            System.out.println("4. hypertension");
            userInput = sc.nextInt();
            switch (userInput) {
                case 1:
                    symptom = "coughing";
                    validInput = true;
                    break;
                case 2:
                    symptom = "runny nose";
                    validInput = true;
                    break;
                case 3:
                    symptom = "stuffy nose";
                    validInput = true;
                    break;
                case 4:
                    symptom = "hypertension";
                    validInput = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        String mainSymptom = symptom;
        RegularPatient regularPatient = new RegularPatient(idCounter++, fName, lName, age, symptom);
        return regularPatient;
    }
}
