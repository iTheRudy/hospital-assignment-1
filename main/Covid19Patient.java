package main;

import main.*;

public class Covid19Patient extends Patient {
    public double temperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Covid19Patient(int id, String fName, String lName, int age, double temperature) {
        super.setId(id);
        super.setfName(fName);
        super.setlName(lName);
        super.setAge(age);
        setTemperature(temperature);
    }

    public String treat() {

        if (temperature > 40) {
            return "Dexamethasone";
        }
        if (age > 59 && temperature > 36.5) {
            return "Paxlovid"
        }
        return "fluids and Acetaminophen";
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Covid19Patient{" +
                "id=" + super.id +
                ", Full Name='" + super.fName + super.lName+'\'' +
                ", age=" + super.age +
                ", Temperatur="+temperature+
                ", PCR Test Result=" + super.pcr?"Postive":"Negative" +
                ", Treatment=" + treat()
                '}';
    }
}
