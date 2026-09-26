package MidtermExam;

import java.util.Scanner;

public class Sandrino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 1. Ask the user how many students will be entered, para malopet
        System.out.print("Enter number of students: ");
    int numStudents = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character

    // 2 & 3. Store names in String[] and grades in int[]
    String[] names = new String[numStudents];
    int[] grades = new int[numStudents];

    // Variables to keep track of statistics, statistics ba :DD
    int highest = 0;
    int lowest = 100;
    double sum = 0;
    int passedCount = 0;
    int failedCount = 0;

    // 4. Ask the user to enter each student's name and grade
    for (int i = 0; i < numStudents; i++) {
        System.out.print("\nStudent " + (i + 1) + " Name: ");
        names[i] = scanner.nextLine();
        
        System.out.print("Grade: ");
        grades[i] = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Initialize highest and lowest with the first student's grade
        if (i == 0) {
            highest = grades[i];
            lowest = grades[i];
        } else {
            if (grades[i] > highest) highest = grades[i];
            if (grades[i] < lowest) lowest = grades[i];
        }
        
        // Add to sum para ma kuha ung average calculation
        sum += grades[i];

        // 7. Check if passed or failed
        if (grades[i] >= 75) {
            passedCount++;
        } else {
            failedCount++;
        }
    }

    // 5 & 6. Display all students, their grades, and the statistics
    System.out.println("\n========== STUDENT RESULTS ==========\n");
    
    for (int i = 0; i < numStudents; i++) {
        String status = (grades[i] >= 75) ? "PASSED" : "FAILED";
        // %-10s ensures the name takes up 10 characters left-aligned, %-7d for the grade
        System.out.printf("%-10s %-7d %s\n", names[i], grades[i], status);
    }

    double average = sum / numStudents;

    System.out.println("\nHighest Grade: " + highest);
    System.out.println("Lowest Grade: " + lowest);
    System.out.printf("Average Grade: %.2f\n", average);
    System.out.println("Passed Students: " + passedCount);
    System.out.println("Failed Students: " + failedCount);

    scanner.close();
}
}