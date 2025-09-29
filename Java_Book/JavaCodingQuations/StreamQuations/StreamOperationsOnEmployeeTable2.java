import java.util.*;
import java.util.stream.*;



public  class StreamOperationsOnEmployeeTable2{

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


Map<Boolean, List<Employee>> partitioned = employees.stream()
    .collect(Collectors.partitioningBy(e -> e.salary() >= 5000));
System.out.println("Emplyees with salary above 5000");
     partitioned.get(true).forEach(x->System.out.println(x));

Map<Boolean, DoubleSummaryStatistics> salary_starts = employees.stream()
    .collect(Collectors.partitioningBy(
        e -> e.salary() >= 5000,
        Collectors.summarizingDouble(Employee::salary)
    ));
System.out.println("\nStatistics of of Employees ");
salary_starts.forEach((salary, stats) -> {
    System.out.println("Salary " + salary+ ": " +
        "Count=" + stats.getCount() +
        ", Sum=" + stats.getSum() +
        ", Avg=" + stats.getAverage() +
        ", Min=" + stats.getMin() +
        ", Max=" + stats.getMax());
});


System.out.println("\nMaximum Salary Employee   "+
employees.stream().max(Comparator.comparingDouble( e->e.salary() )).orElseThrow());

System.out.println("\nMinimum Salary Employee   "+
employees.stream().min(Comparator.comparingDouble( e->e.salary() )).orElseThrow());

System.out.println("\nSorting employee based on salary and his name: ");
employees.stream()
     .sorted(Comparator.comparingDouble(Employee::salary).thenComparing(Employee::name))
     .forEach(System.out::println);

employees.stream()
    .max(Comparator.comparingDouble(Employee::salary))
    .ifPresent(emp -> System.out.println("\nHighest Paid: " + emp));
	
}
}

