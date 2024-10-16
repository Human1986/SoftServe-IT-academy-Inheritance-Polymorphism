package jom.com.softserve.s2.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyUtils {

    public List<Person> maxDuration(List<Person> persons) {

        if (persons.size() == 1) return new ArrayList<>();

        if (! persons.isEmpty()) {

            int maxStudyYears = 0;
            int maxExperienceYears = 0;

            List<Person> result = new ArrayList<>();

            for (Person person : persons) {
                if (person instanceof Student) {
                    Student student = (Student) person;
                    if (student.getStudyYears() > maxStudyYears) {
                        maxStudyYears = student.getStudyYears();
                    }
                } else if (person instanceof Worker) {
                    Worker worker = (Worker) person;
                    if (worker.getExperienceYears() > maxExperienceYears) {
                        maxExperienceYears = worker.getExperienceYears();
                    }
                }
            }

            for (Person person : persons) {
                if (person instanceof Student) {
                    Student student = (Student) person;
                    if (student.getStudyYears() == maxStudyYears) {
                        result.add(student);
                    }
                } else if (person instanceof Worker) {
                    Worker worker = (Worker) person;
                    if (worker.getExperienceYears() == maxExperienceYears) {
                        result.add(worker);
                    }
                }
            }

            return result;

        }

        return new ArrayList<>();
    }
}

class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person[");
        sb.append("name='").append(name).append('\'');
        sb.append(']');
        return sb.toString();
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    private final String studyPlace;
    private final int studyYears;

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.studyPlace = studyPlace;
        this.studyYears = studyYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Student student)) return false;
        return getStudyYears() == student.getStudyYears() && getStudyPlace().equals(student.getStudyPlace());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (super.getName() == null ? 0 : super.getName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student[");
        sb.append(super.getName()).append(" ");
        sb.append("studyPlace='").append(studyPlace).append('\'');
        sb.append(", studyYears=").append(studyYears);
        sb.append(']');
        return sb.toString();
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }
}

class Worker extends Person {
    private final String workPosition;
    private final int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.workPosition = workPosition;
        this.experienceYears = experienceYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Worker worker)) return false;
        return getExperienceYears() == worker.getExperienceYears() && getWorkPosition().equals(worker.getWorkPosition());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (super.getName() == null ? 0 : super.getName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Worker[");
        sb.append("workPosition='").append(workPosition).append('\'');
        sb.append(", experienceYears=").append(experienceYears);
        sb.append(']');
        return sb.toString();
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}