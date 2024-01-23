
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
        return "RegularPatient{" +
                ", id=" + id +
                ", fName='" + fName + ' ' + lName +
                ", age=" + age +
                "mainSymptom='" + mainSymptom + '\'' +
                ", PCR Test Result=" + pcr +
                "Treatment=" + treat() +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "RegularPatient{" +
//                "mainSymptom='" + mainSymptom + '\'' +
//                '}';
//    }
}
