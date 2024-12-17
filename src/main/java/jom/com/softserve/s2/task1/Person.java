package jom.com.softserve.s2.task1;

public class Person {
    private String childIDNumber;
    private int age;
    private String healthInfo;
    private String name;

    public Person() {
    }

    public Person(String childIDNumber) {
        this.childIDNumber = childIDNumber;
    }

    public Person(int age, String childIDNumber, String healthInfo, String name) {
        this.childIDNumber = childIDNumber;
        this.age = age;
        this.healthInfo = healthInfo;
        this.name = name;
    }

    public Person(int age, String healthInfo, String name) {
        this.age = age;
        this.healthInfo = healthInfo;
        this.name = name;
    }

    public String getHealthStatus() {
        return name + " " + healthInfo;
    }

}