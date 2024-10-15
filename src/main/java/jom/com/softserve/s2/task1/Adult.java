package jom.com.softserve.s2.task1;

public class Adult extends Person {
    int age;
    String healthInfo;
    String name;
    private String passportNumber;

    public Adult(int age, String healthInfo, String passportNumber, String name) {

        this.age = age;
        this.healthInfo = healthInfo;
        this.passportNumber = passportNumber;
        this.name = name;
    }


    public String getHealthStatus() {
        return name + " " + healthInfo;
    }
}