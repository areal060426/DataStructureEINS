package MidtermExam;

import java.util.Scanner;

public class MidtermExamPaja {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numStudents = 0;
        boolean validCount = false;

        while (!validCount) {
            System.out.print("Enter number of students: ");
            if (input.hasNextInt()) {
                numStudents = input.nextInt();
                if (numStudents > 0) {
                    validCount = true;
                } 
                else {
                    System.out.println("Number of students must be greater than 0. Try again.");
                }
            } 
            else {
                System.out.println("Invalid input. Please enter a whole number.");
                input.next();
            }
        }
        input.nextLine();

        String[] names = new String[numStudents];
        int[] grades = new int[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println();
            System.out.print("Student " + (i + 1) + " Name: ");

            String name = input.nextLine().trim();
            while (name.isEmpty()) {
                System.out.print("Name cannot be empty. Enter Student " + (i + 1) + " Name: ");
                name = input.nextLine().trim();
            }

            names[i] = name;

            System.out.print("Grade: ");
            boolean validGrade = false;
            int grade = 0;
            while (!validGrade) {
                if (input.hasNextInt()) {
                    grade = input.nextInt();
                    if (grade >= 0 && grade <= 100) {
                        validGrade = true;
                    }
                    else {
                        System.out.print("Grade must be between 0 and 100. Enter Grade: ");
                    }
                }
                else {
                    System.out.print("Invalid input. Enter a whole number for Grade: ");
                    input.next(); 
                }
            }
            input.nextLine();
            grades[i] = grade;
        }

        System.out.println("\n========== STUDENT RESULTS ==========\n");

        int highest = grades[0];
        int lowest = grades[0];
        int sum = 0;
        int passedCount = 0;
        int failedCount = 0;

        for (int i = 0; i < numStudents; i++) {
            String status = (grades[i] >= 75) ? "PASSED" : "FAILED";
            System.out.printf("%-10s %-7d %s%n", names[i], grades[i], status);

            if (grades[i] > highest) highest = grades[i];
            if (grades[i] < lowest) lowest = grades[i];
            sum += grades[i];

            if (grades[i] >= 75) {
                passedCount++;
            }
            else {
                failedCount++;
            }
        }

        double average = (double) sum / numStudents;

        System.out.println();
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.println("Passed Students: " + passedCount);
        System.out.println("Failed Students: " + failedCount);

        input.close();
    }
}