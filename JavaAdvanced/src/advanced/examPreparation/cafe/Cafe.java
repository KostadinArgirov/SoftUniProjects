package advanced.examPreparation.cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    List<Employee> employees;
    String name;
    int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        Employee employeeToRemove = this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);

        if (employeeToRemove != null) {
            this.employees.remove(employeeToRemove);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        return "Employees working at Cafe " + this.name + ":" + System.lineSeparator()
                + this.employees.stream().map(Employee::toString).collect(Collectors.joining(System.lineSeparator()));

    }
}