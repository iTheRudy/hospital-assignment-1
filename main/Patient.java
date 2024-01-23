package main;

public abstract class Patient {
    public int id;
    public String fName;
    public String lName;
    public  int age;
    public boolean pcr;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isPcr() {
        return pcr;
    }

    public void setPcr(boolean pcr) {
        this.pcr = pcr;
    }

    public Patient(int id, String fName, String lName, int age) {
        setId(id);
        setfName(fName);
        setlName(lName);
        setAge(age);
    }

    public treat();

    @java.lang.Override
    public java.lang.String toString() {
        return "Patient{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                ", pcr=" + pcr +
                '}';
    }
}
