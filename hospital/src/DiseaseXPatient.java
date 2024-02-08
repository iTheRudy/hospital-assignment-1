class DiseaseXPatient extends Patient {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String symptoms;
    private final boolean pcrTestResult;

    public DiseaseXPatient(int id, String firstName, String lastName, int age, String symptoms, boolean pcrTestResult) {
        super(id, firstName, lastName, age);
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.symptoms = symptoms;
        this.pcrTestResult = pcrTestResult;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public boolean isPcrTestResult() {
        return pcrTestResult;
    }

    @Override
    public String treat() {
        return "REGEN-COV antibody cocktail and therapeutic dose of heparin";
    }

    public String toString() {
        return "DiseaseXPatient" +
                "\n  id=" + id +
                "\n  Name=" + fName + " " + lName +
                "\n  age=" + age +
                "\n PCR Test Result=" + (pcrTestResult ? "Positive" : "Negative") +
                "\n  Treatment=" + treat() + "\n\n\n";
    }

}
