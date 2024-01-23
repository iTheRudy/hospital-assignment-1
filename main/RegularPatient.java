import main.*;

public class RegularPatient extends Patient {
    public String mainSymptom;

    public RegularPatient(int id, String fName, String lName, int age, String mainSymptom) {
        this.mainSymptom = mainSymptom;
    }

    public String treat() {
        return "";
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RegularPatient{" +
                "mainSymptom='" + mainSymptom + '\'' +
                '}';
    }
}
