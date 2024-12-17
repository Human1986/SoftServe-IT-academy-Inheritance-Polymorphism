package jom.com.softserve.s2.task1;

public class Adult extends Person {
    private int age;
    private String healthInfo;
    private String name;
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