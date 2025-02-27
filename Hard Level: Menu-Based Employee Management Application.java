//Employee Class (Employee.java):

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String designation;
    private double salary;

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
        System.out.println("-------------------------");
    }
}


//Main Application (EmployeeManagementApp.java):
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementApp {
    private static final String FILE_NAME = "employees.dat";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();
        
        // Load existing employees
        employeeList = loadEmployees();
        
        while (true) {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            
            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Designation: ");
                    String designation = scanner.nextLine();
                    
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    
                    Employee employee = new Employee(id, name, designation, salary);
                    employeeList.add(employee);
                    
                    // Save to file
                    saveEmployees(employeeList);
                    System.out.println("Employee added successfully!");
                    break;
                
                case 2:
                    // Display All Employees
                    System.out.println("\n===== Employee Details =====");
                    if (employeeList.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee emp : employeeList) {
                            emp.displayDetails();
                        }
                    }
                    break;
                
                case 3:
                    // Exit
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    // Method to save employees to file
    private static void saveEmployees(List<Employee> employeeList) {
        try (FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(employeeList);
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    // Method to load employees from file
    private static List<Employee> loadEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        
        try (FileInputStream fileIn = new FileInputStream(FILE_NAME);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            employeeList = (List<Employee>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No existing employee records found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
        
        return employeeList;
    }
}
