package jom.com.softserve.s2.task4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Employee {
    private final BigDecimal basePayment;
    private String name;
    private int experience;

    public Employee(BigDecimal basePayment) {
        this.basePayment = basePayment;
    }

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Employee employee)) return false;
        return experience == employee.experience &&
               name.equals(employee.name) &&
               basePayment.equals(employee.basePayment);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + experience;
        result = 31 * result + basePayment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee[name=" + getName() + ", experience=" + getExperience() +
               ", basePayment= " + getBasePayment() + "]";
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getBasePayment() {
        return basePayment;
    }

    public BigDecimal getPayment() {
        return BigDecimal.valueOf(experience).multiply(basePayment);
    }


}


class Manager extends Employee {
    private final double coefficient;


    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Manager)) return false;
        if (! super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Double.hashCode(coefficient);

    }

    @Override
    public String toString() {
        return "Manager[" + "name= " + getName() +
               ", experience=" + getExperience() +
               ", basePayment=" + getPayment() +
               ']';
    }

    @Override
    public BigDecimal getPayment() {
        return BigDecimal.valueOf(coefficient).multiply(getBasePayment());
    }

    public double getCoefficient() {
        return coefficient;
    }

}


public class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        if (workers.size() == 1) return workers;
        if (workers.isEmpty()) return new ArrayList<>();

        int maxExperience = 0;
        BigDecimal maxPayment = BigDecimal.ZERO;

        for (Employee worker : workers) {
            if (worker.getExperience() > maxExperience) {
                maxExperience = worker.getExperience();
            }
            if (worker.getPayment().compareTo(maxPayment) > 0) {
                maxPayment = worker.getPayment();
            }
        }

        List<Employee> result = new ArrayList<>();
        Set<Employee> uniqueEmployees = new HashSet<>();

        for (Employee employee : workers) {
            if (employee instanceof Employee) {
                if (employee.getExperience() == maxExperience || employee.getPayment().equals(maxPayment)) {
                    result.add(employee);
                }
            } else if (employee instanceof Manager) {
                Manager manager = (Manager) employee;
                if (manager.getExperience() == maxExperience || manager.getPayment().equals(maxPayment)) {
                    result.add(manager);
                }
            }


        }
        return result;
    }
}

