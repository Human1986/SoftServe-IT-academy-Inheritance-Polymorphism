package jom.com.softserve.s2.task4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

        int maxExperienceEmployee = 0;
        int maxExperienceManager = 0;
        BigDecimal maxEmployeePayment = BigDecimal.ZERO;
        BigDecimal maxManagerPayment = BigDecimal.ZERO;

        for (Employee worker : workers) {
            if (worker instanceof Manager) {
                Manager manager = (Manager) worker;
                if (manager.getExperience() > maxExperienceManager) {
                    maxExperienceManager = manager.getExperience();
                }
                if (manager.getBasePayment().compareTo(maxManagerPayment) > 0) {
                    maxManagerPayment = manager.getBasePayment();
                }

            } else {
                Employee employee = worker;
                if (employee.getExperience() > maxExperienceEmployee) {
                    maxExperienceEmployee = employee.getExperience();
                }
                if (employee.getBasePayment().compareTo(maxEmployeePayment) > 0) {
                    maxEmployeePayment = employee.getBasePayment();
                }
            }
        }

        List<Employee> result = new ArrayList<>();


        for (Employee employee : workers) {

            if (employee instanceof Manager) {
                if (employee.getExperience() >= maxExperienceManager) {
                    addUniqueEmployee(employee, result);
                } else if (employee.getBasePayment().compareTo(maxManagerPayment) > 0)
                    addUniqueEmployee(employee, result);
            } else {
                if (employee.getExperience() >= maxExperienceEmployee) {
                    addUniqueEmployee(employee, result);
                } else if (employee.getBasePayment().compareTo(maxEmployeePayment) >= 0)
                    addUniqueEmployee(employee, result);

            }
        }

        return result;
    }

    private static void addUniqueEmployee(Employee employee, List<Employee> result) {
        if (! result.contains(employee))
            result.add(employee);
    }
}