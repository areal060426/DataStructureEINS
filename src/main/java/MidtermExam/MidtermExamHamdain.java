package MidtermExam;

import java.util.Scanner;

public class MidtermExamHamdain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int numStudents = 0;
        while (true) {
            System.out.print("Enter number of students: ");
            if (scanner.hasNextInt()) {
                numStudents = scanner.nextInt();
                scanner.nextLine(); 
                if (numStudents > 0) {
                    break;
                } else {
                    System.out.println("Error: Must be at least 1 student.");
                }
            } else {
                System.out.println("Invalid input! Please enter a whole number only.");
                scanner.next(); 
            }
        }

        
        String[] names = new String[numStudents];
        int[] grades = new int[numStudents];

        
        for (int i = 0; i < numStudents; i++) {
            
            while (true) {
                System.out.print("\nStudent " + (i + 1) + " Name: ");
                names[i] = scanner.nextLine().trim();
                
                if (names[i].isEmpty()) {
                    System.out.println("Error: Name cannot be blank.");
                } else if (!names[i].matches("[a-zA-Z\\s]+")) {
                    System.out.println("Error: Name must contain letters only (no numbers or symbols).");
                } else {
                    break;
                }
            }
            
            
            while (true) {
                System.out.print("Grade (0-100): ");
                if (scanner.hasNextInt()) {
                    grades[i] = scanner.nextInt();
                    scanner.nextLine(); 
                    if (grades[i] >= 0 && grades[i] <= 100) {
                        break;
                    } else {
                        System.out.println("Error: Grade must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a numeric grade.");
                    scanner.next(); 
                }
            }
        }

        
        System.out.println("\n========== STUDENT RESULTS ==========\n");

        int highest = grades[0];
        int lowest = grades[0];
        int totalSum = 0;
        int passedCount = 0;
        int failedCount = 0;

        for (int i = 0; i < numStudents; i++) {
            String status = "";
            if (grades[i] >= 75) {
                status = "PASSED";
                passedCount++;
            } else {
                status = "FAILED";
                failedCount++;
            }

            if (grades[i] > highest) {
                highest = grades[i];
            }
            if (grades[i] < lowest) {
                lowest = grades[i];
            }

            totalSum += grades[i];

            System.out.printf("%-10s %-5d %-6s\n", names[i], grades[i], status);
        }

        double average = (double) totalSum / numStudents;

        
        System.out.println("\nHighest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Passed Students: " + passedCount);
        System.out.println("Failed Students: " + failedCount);

        scanner.close();
    }
}

