package jom.com.softserve.s2.task1;

public class Child extends Person {
    int age;
    String healthInfo;
    String name;
    private String childIDNumber;


    public Child(int age, String healthInfo, String name, String childIDNumber) {
        super(childIDNumber);
        this.age = age;
        this.healthInfo = healthInfo;
        this.name = name;
    }


    public String getHealthStatus() {
        return name + " " + healthInfo;
    }
}