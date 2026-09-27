package Activity3;
/*
 * Group 3 — Employee Salary Sorting System

Create parallel arrays:

String[] employeeName;
int[] employeeID;
double[] salary;

Ask the user to enter employee information.

The program must provide this menu:

==============================
EMPLOYEE MANAGEMENT SYSTEM
==============================
1. Display Employees
2. Sort by Salary - Highest to Lowest
3. Sort by Salary - Lowest to Highest
4. Sort by Employee ID
5. Search Employee ID
6. Display Salary Statistics
7. Exit
==============================

Students must keep all employee information connected when sorting.*/

import java.util.Scanner;

public class Group3 {


    // Display all employees and their info
    public static void displayEmployees(String[] employeeName, int[] employeeID, double[] salary) {
        System.out.println("\n--- EMPLOYEE LIST ---");
        for (int i = 0; i < employeeName.length; i++) {
            System.out.println("ID: " + employeeID[i] + " | Name: " + employeeName[i] + " | Salary: ₱" + salary[i]);
        }
    }

    // Bubble Sorting - sorts employee by salary, high to lowe
    public static void highLowSortSal(double[] salary, String[] employeeName, int[] employeeID) {
        for (int i = 0; i < salary.length - 1; i++) {
            for (int j = 0; j < salary.length - 1 - i; j++) {
                if (salary[j] < salary[j + 1]) {
                    swap(salary, employeeName, employeeID, j, j + 1);
                }
            }
        }
        System.out.println("\nEmployees Sorted by Salary (Highest to Lowest):");
        displayEmployees(employeeName, employeeID, salary);
    }

    // sorts employees by salary, low to high
    public static void lowHighSortSal(double[] salary, String[] employeeName, int[] employeeID) {
        for (int i = 0; i < salary.length - 1; i++) {
            for (int j = 0; j < salary.length - 1 - i; j++) {
                if (salary[j] > salary[j + 1]) {
                    swap(salary, employeeName, employeeID, j, j + 1);
                }
            }
        }
        System.out.println("\nEmployees Sorted by Salary (Lowest to Highest):");
        displayEmployees(employeeName, employeeID, salary);
    }

    // sort employees by id num
    public static void sortByID(int[] employeeID, String[] employeeName, double[] salary) {
        for (int i = 0; i < employeeID.length - 1; i++) {
            for (int j = 0; j < employeeID.length - 1 - i; j++) {
                if (employeeID[j] > employeeID[j + 1]) {
                    swap(salary, employeeName, employeeID, j, j + 1);
                }
            }
        }
        System.out.println("\nEmployees Sorted by ID:");
        displayEmployees(employeeName, employeeID, salary);
    }

    // looks for an employee by id and shows info
    public static void searchEmployeeID(int targetID, int[] employeeID, String[] employeeName, double[] salary) {
        boolean found = false;

        for (int i = 0; i < employeeID.length; i++) {
            if (employeeID[i] == targetID) {
                System.out.println("\nEmployee Found!");
                System.out.println("ID: " + employeeID[i] + " | Name: " + employeeName[i] + " | Salary: ₱" + salary[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nEmployee with ID " + targetID + " not found.");
        }
    }

    // swap 2 employee info so data stays the same after sorting/swapping
    public static void swap(double[] salary, String[] employeeName, int[] employeeID, int i, int j) {
        double tempSalary = salary[i];
        salary[i] = salary[j];
        salary[j] = tempSalary;

        String tempName = employeeName[i];
        employeeName[i] = employeeName[j];
        employeeName[j] = tempName;

        int tempID = employeeID[i];
        employeeID[i] = employeeID[j];
        employeeID[j] = tempID;
    }

    // calculates and display total, avg, high, and low salary
    public static void displaySalaryStatistics(double[] salary) {
        double total = 0;
        double highest = salary[0];
        double lowest = salary[0];

        for (int i = 0; i < salary.length; i++) {
            total += salary[i];
            if (salary[i] > highest) {
                highest = salary[i];
            }
            if (salary[i] < lowest) {
                lowest = salary[i];
            }
        }

        double average = total / salary.length;

        System.out.println("\n--- SALARY STATISTICS ---");
        System.out.println("Total Salary Payout: ₱" + String.format("%.2f", total));
        System.out.println("Average Salary: ₱" + String.format("%.2f", average));
        System.out.println("Highest Salary: ₱" + String.format("%.2f", highest));
        System.out.println("Lowest Salary: ₱" + String.format("%.2f", lowest));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ask how many to register
        int numEmployees;
        do {
            System.out.print("Enter number of employees: ");
            numEmployees = scanner.nextInt();
            scanner.nextLine();

            if (numEmployees <= 0) {
                System.out.println("Invalid input. Please enter a number greater than 0.\n");
            }
        } while (numEmployees <= 0);

        // initialize array
        String[] employeeName = new String[numEmployees];
        int[] employeeID = new int[numEmployees];
        double[] salary = new double[numEmployees];

        // loop to gather info for each employee
        System.out.println("\n--- ENTER EMPLO   YEE DETAILS ---");
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Employee " + (i + 1) + ":");

            System.out.print("Name: ");
            employeeName[i] = scanner.nextLine();

            // auto assign ID
            employeeID[i] = 1 + i;
            System.out.println("ID: " + employeeID[i]);

            // prevents negative salaries
            do {
                System.out.print("Salary: ");
                salary[i] = scanner.nextDouble();
                scanner.nextLine();

                if (salary[i] < 0) {
                    System.out.println("Invalid amount. Salary cannot be negative.");
                }
            } while (salary[i] < 0);

            System.out.println();
        }

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println(" EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Display Employees");
            System.out.println("2. Sort by Salary - Highest to Lowest");
            System.out.println("3. Sort by Salary - Lowest to Highest");
            System.out.println("4. Sort by Employee ID");
            System.out.println("5. Search Employee ID");
            System.out.println("6. Display Salary Statistics"); // i forgor
            System.out.println("7. Exit");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayEmployees(employeeName, employeeID, salary);
                    break;
                case 2:
                    highLowSortSal(salary, employeeName, employeeID);
                    break;
                case 3:
                    lowHighSortSal(salary, employeeName, employeeID);
                    break;
                case 4:
                    sortByID(employeeID, employeeName, salary);
                    break;
                case 5:
                    System.out.print("Enter Employee ID to search: ");
                    int idToFind = scanner.nextInt();
                    searchEmployeeID(idToFind, employeeID, employeeName, salary);
                    break;
                case 6:
                    displaySalaryStatistics(salary);
                    break;
                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}



