
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static int idCounter = 0;

    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();

        boolean userExited = false;

        while (!userExited) {
            try {
                System.out.println("1. Admit a patient");
                System.out.println("2. Print patient information");
                System.out.println("3. Submit a PCR Result");
                System.out.println("4. Do rounds");
                System.out.println("5. Discharge patient");
                System.out.println("6. Admit a Disease X patient");
                System.out.println("7. Exit");
                Scanner sc = new Scanner(System.in);
                int userInput = sc.nextInt();
                switch (userInput) {
                    case 1:
                        admitPatient(patientList);
                        break;
                    case 2:
                        printPatientInformation(patientList);
                        break;
                    case 3:
                        submitPCRTestResult(patientList);
                        break;
                    case 4:
                        doRounds(patientList);
                        break;
                    case 5:
                        dischargePatient(patientList, -1);
                        break;
                    case 6:
                        admitDiseaseXPatient(patientList);
                        break;
                    case 7:
                        userExited = true;
                        break;
                    default:
                        System.out.println("Please enter a valid input");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Enter only a number");
            }

        }
    }

    public static void admitDiseaseXPatient(List<Patient> patientList) {
        Scanner sc = new Scanner(System.in);
        String fName;
        String lName;
        int age;
        String symptom;
        String pcrTestResult;
        System.out.println("Enter first name: ");
        fName = sc.next();
        System.out.println("Enter last name: ");
        lName = sc.next();
        System.out.println("Enter age: ");
        age = sc.nextInt();
        sc.nextLine(); // Consume newline
        System.out.println("Enter symptom: ");
        symptom = sc.nextLine();
        System.out.println("Enter PCR test result (Positive/Negative): ");
        pcrTestResult = sc.nextLine();
        Patient patient = new DiseaseXPatient(idCounter++, fName, lName, age, symptom, pcrTestResult);
        patientList.add(patient);
        System.out.println("Disease X patient admitted successfully.");
    }

    public static void dischargePatient(List<Patient> patientList, int receivedId) {
        Patient toBeDischarged = searchPatient(patientList, receivedId);
        if (receivedId > 1) {
            if (toBeDischarged instanceof Covid19Patient) {
                return;
            }
        }
        if (receivedId < 1) {
            Scanner sc = new Scanner(System.in);
            int id;
            System.out.println("Enter patient id to discharge");
            id = sc.nextInt();
            toBeDischarged = searchPatient(patientList, id);
        }
        dismissPatient(patientList, toBeDischarged);
        System.out.println(patientList);
        System.out.println("\n\n\n");
    }

    public static void admitPatient(List<Patient> patientList) {
        boolean validPCRInput = false;

        int userInput = 0;

        while (!validPCRInput) {
            try {
                System.out.println("Pcr test result");
                System.out.println("1. Negative");
                System.out.println("2. Positive");
                Scanner sc = new Scanner(System.in);
                userInput = sc.nextInt();
                validPCRInput = true;

            } catch (InputMismatchException e) {
                System.out.println("Enter only a number");
            }
        }
        switch (userInput) {
            case 1:
                patientList.add(createRegularPatient());
                break;
            case 2:
                patientList.add(createCovid19Patient());
                break;
            default:
                System.out.println("Enter a valid input");
                break;
        }
    }

    public static void printPatientInformation(List<Patient> patientList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the patient id");
        int id = sc.nextInt();
        Patient patient = searchPatient(patientList, id);
        System.out.println(patient);
    }

    public static void submitPCRTestResult(List<Patient> patientList) {
        System.out.println("Enter patient id");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        Patient patient = searchPatient(patientList, id);
        System.out.println("Enter PCR Test Result: ");
        System.out.println("1. Negative");
        System.out.println("2. Positive");
        int userInput = sc.nextInt();
        boolean validInput = false;
        while (!validInput) {
            switch (userInput) {
                case 1:
                    dischargePatient(patientList, id);
                    validInput = true;
                    break;
                case 2:
                    convertRegularPatientToCovid19Patient(patientList, searchPatient(patientList, id));
                    validInput = true;
                    break;
                default:
                    System.out.println("Enter a valid input");
                    break;
            }
        }

    }

    public static void doRounds(List<Patient> patientList) {
        System.out.println(patientList);
        Scanner sc = new Scanner(System.in);
        patientList.stream().forEach(patient -> {
            if (patient instanceof Covid19Patient) {
                System.out.println("Patient Name: " + patient.getfName() + " " + patient.getlName());
                System.out.println("Patient id: " + patient.getId());
                System.out.println("Enter the temperature: ");
                System.out.println("\n\n\n");
                double temperature = sc.nextDouble();
                ((Covid19Patient) patient).setTemperature(temperature);
            }
        });
        System.out.println();
        System.out.println();
        System.out.println();

        patientList.stream().forEach(patient -> {
            System.out.println("Patient id: " + patient.getId());
            System.out.println("Treatment for patient: " + patient.treat());
        });

    }

    public static void convertRegularPatientToCovid19Patient(List<Patient> patientList, Patient patient) {
        dismissPatient(patientList, patient);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter temperature: ");
        double temperature = sc.nextDouble();

        Covid19Patient covid19Patient = new Covid19Patient(patient.getId(), patient.getfName(), patient.getlName(), patient.getAge(), temperature);

        patientList.add(covid19Patient);
    }

    public static void dismissPatient(List<Patient> patientList, Patient patient) {
        int patientListSize = patientList.size();

        for (int i = 0; i < patientListSize; i++) {
            if (patientList.get(i).getId() == patient.getId()) {
                patientList.remove(i);
                break;
            }
        }
    }

    public static Patient searchPatient(List<Patient> patientList, int receivedId) {
        Patient searchedPatient = null;
        Scanner sc = new Scanner(System.in);
        try {
            searchedPatient =
                    patientList.stream().filter(patient -> patient.getId() == receivedId).collect(Collectors.toList())
                            .get(0);

        } catch (Exception e) {
            System.out.println("Patient with id " + receivedId + " does not exist");
            System.out.println("Enter a valid patient id: ");
            int id = sc.nextInt();
            searchedPatient = searchPatient(patientList, id);
        }
        return searchedPatient;
    }

    public static Patient createCovid19Patient() {
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
        double temperature = sc.nextDouble();
        Covid19Patient covid19Patient = new Covid19Patient(idCounter++, fName, lName, age, temperature);
        System.out.println(covid19Patient);
        return covid19Patient;
    }

    public static Patient createRegularPatient() {
        Scanner sc = new Scanner(System.in);
        String symptom = "";
        int userInput;
        boolean validInput = false;
        System.out.println("Enter first name: ");
        String fName = sc.next();
        System.out.println("Enter last name: ");
        String lName = sc.next();
        System.out.println("Enter age: ");
        int age = sc.nextInt();
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
                    break;
            }
        }
        RegularPatient regularPatient = new RegularPatient(idCounter++, fName, lName, age, symptom);
        System.out.println(regularPatient);
        return regularPatient;
    }
}
