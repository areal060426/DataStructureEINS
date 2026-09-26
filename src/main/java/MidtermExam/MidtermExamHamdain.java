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
                scanner.next(); // Clear invalid token
            }
        }

        // 2 & 3. Create parallel arrays
        String[] names = new String[numStudents];
        int[] grades = new int[numStudents];

        // 4. Ask for names and grades with validation
        for (int i = 0; i < numStudents; i++) {
            // Name validation (cannot be blank, no numbers, no symbols)
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
            
            // Grade validation (must be a number between 0 and 100)
            while (true) {
                System.out.print("Grade (0-100): ");
                if (scanner.hasNextInt()) {
                    grades[i] = scanner.nextInt();
                    scanner.nextLine(); // Clear newline buffer
                    if (grades[i] >= 0 && grades[i] <= 100) {
                        break;
                    } else {
                        System.out.println("Error: Grade must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a numeric grade.");
                    scanner.next(); // Clear invalid token
                }
            }
        }

        // 5. Display all students and results
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

        // 6. Display summary statistics
        System.out.println("\nHighest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Passed Students: " + passedCount);
        System.out.println("Failed Students: " + failedCount);

        scanner.close();
    }
}

