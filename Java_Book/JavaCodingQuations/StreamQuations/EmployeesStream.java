import java.util.*;
import java.util.stream.*;

public  class EmployeesStream{

public static void main(String[] a){
List<Employee>  list=List.of(new Employee(1,"Ravi",1200.0,34),new Employee(2,"Mani",3400,24),new Employee(3,"Srikanth",40090,45));

  // Top 3 highest-paid employees
List<Employee> top3 = list.stream()
    .sorted(Comparator.comparing(Employee::salary).reversed())
    .limit(3)          // take first 3 elements
    .toList();

System.out.println("Highest paid top three:");
top3.forEach(System.out::println);


// Skip first 2 employees
List<Employee> skipped = list.stream()
    .skip(2)           // ignore first 2
    .toList();

System.out.println("Skipped first three: ");
skipped.forEach(System.out::println);

// Sum of salaries using primitive streams
double total = list.stream()
    .mapToDouble(Employee::salary)  // Employee -> double
    .sum();
System.out.println("Sum of all salaries: "+total);

// Average salary
double avg = list.stream()
    .mapToDouble(Employee::salary)
    .average()
    .orElse(0);
System.out.println("Employee salary average: "+avg);


// Convert DoubleStream to Stream<Double>
Stream<Double> objectStream = list.stream()
    .mapToDouble(Employee::salary)
    .boxed();        // primitive -> object

// Convert Stream<Double> to DoubleStream
DoubleStream primitiveStream = objectStream
    .mapToDouble(Double::doubleValue); // object -> primitive

}


}
