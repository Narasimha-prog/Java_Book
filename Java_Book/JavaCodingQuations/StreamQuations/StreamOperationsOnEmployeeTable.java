
import java.util.*;
import java.util.stream.*;

class Employee {
    private int id;
    private String name;
    private double salary;
    private int department;

    public Employee() {}

    public Employee(int id, String name, double salary, int department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
}
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public int getDepartment() { return department; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setDepartment(int department) { this.department = department; }

    @Override
    public String toString() {
        return "[id: " + id +
               ", name: " + name +
               ", salary: " + salary +
               ", department: " + department +
               "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, department);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Employee emp) { // Java 21 pattern matching
            return this.id == emp.id &&
                   Double.compare(this.salary, emp.salary) == 0 &&
                   Objects.equals(this.name, emp.name) &&
                   this.department == emp.department;
        }
        return false;
    }
}

public class StreamOperationsOnEmployeeTable {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(1, "Alice", 5000, 101),
            new Employee(2, "Bob", 6000, 102),
            new Employee(3, "Charlie", 5500, 101),
            new Employee(4, "David", 7000, 103),
            new Employee(5, "Eve", 6200, 102),
            new Employee(6, "Frank", 4800, 101),
            new Employee(7, "Grace", 7500, 104),
            new Employee(8, "Hannah", 5300, 103),
            new Employee(9, "Ian", 6700, 102),
            new Employee(10, "Julia", 5900, 104)
        );

        // Highest salary employee
        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highestPaid.ifPresent(emp -> System.out.println("Highest Paid: " + emp));

        // Lowest salary employee
        Optional<Employee> lowestPaid = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
        lowestPaid.ifPresent(emp -> System.out.println("Lowest Paid: " + emp));

        // Maximum salary value
        double maxSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
        System.out.println("Max Salary Value: " + maxSalary);

        // Total salary
        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total Salary: " + totalSalary);

        // Average salary
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println("Average Salary: " + avgSalary);

        // Employees grouped by department
        Map<Integer, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("\nEmployees by Department:");
        byDept.forEach((dept, list) -> {
            System.out.println("Department " + dept + ": " + list);
        });

        // Top 3 highest salaries
        List<Employee> top3 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("\nTop 3 Highest Salaries: " + top3);

        // Names of employees earning more than 6000
        List<String> highEarners = employees.stream()
                .filter(emp -> emp.getSalary() > 6000)
                .map(Employee::getName)
                .toList();
        System.out.println("\nEmployees earning > 6000: " + highEarners);
    }
}
