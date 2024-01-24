
public class Covid19Patient extends Patient {
    public double temperature;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Covid19Patient(int id, String fName, String lName, int age, double temperature) {
        super(id, fName, lName, age);

        setTemperature(temperature);
    }

    public String treat() {

        if (temperature > 40) {
            return "Dexamethasone";
        }
        if (age > 59 && temperature > 36.5) {
            return "Paxlovid";
        }
        return "fluids and Acetaminophen";
    }

    @Override
    public String toString() {
        return "Covid19Patient" +
                "\n  id=" + id +
                "\n  Name=" + fName + " " + lName +
                "\n  age=" + age +
                "\n temperature=" + temperature +
                "\n PCR Test Result=" + (true ? "Positive" : "Negative") +
                "\n  Treatment=" + treat() + "\n\n\n";
    }
}
