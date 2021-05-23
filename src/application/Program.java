package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employee = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		System.out.println();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Emplyoee #" + i + ":");
			
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			while (hasId(employee, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			String name = sc.next();
			sc.nextLine();
			
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			employee.add(new Employee(id, name, salary));				
			
			System.out.println();
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		
		Employee emp = employee.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			
			emp.increaseSalary(percent);
		}
		
		System.out.println();

		System.out.println("List of employees:");
		for (Employee x : employee) {
			System.out.println(x);
		}
		
		sc.close();
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee test = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return test != null;
	}

}
