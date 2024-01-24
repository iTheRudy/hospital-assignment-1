
public class RegularPatient extends Patient {
    public String mainSymptom;

    public RegularPatient(int id, String fName, String lName, int age, String mainSymptom) {
        super(id, fName, lName, age);
        this.mainSymptom = mainSymptom;
    }

    public String treat() {
        if (mainSymptom.equals("coughing") || mainSymptom.equals("runny nose") || mainSymptom.equals("stuffy nose")) {
            return "Amoxicillin";
        }
        if (mainSymptom.equals("hypertension")) {
            return "ACE inhibitors";
        }
        return " IV fluids";
    }

    @Override
    public String toString() {
        return "RegularPatient" +
                "\n id=" + id +
                "\n Name=" + fName + ' ' + lName +
                "\n age=" + age +
                "\n mainSymptom=" + mainSymptom +
                "\n PCR Test Result=" + (false ? "Positive" : "Negative") +
                "\n Treatment=" + treat() + "\n\n\n";
    }
}
