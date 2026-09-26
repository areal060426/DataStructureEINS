package MidtermExam;

import java.util.Scanner;

public class MidtermExamGertos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 

        String[] studentNames = new String[numStudents];
        int[] grades = new int[numStudents];

        for (int i = 0; i < numStudents; i++) {
            while (true) {
                System.out.print("\nStudent " + (i + 1) + " Name: ");
                String nameInput = scanner.nextLine();

                if (nameInput.trim().isEmpty()) {
                    System.out.println("Invalid Name! Name cannot be blank or only spaces. Please try again.");
                } 
                else if (nameInput.matches("[a-zA-Z\\s]+")) {
                    studentNames[i] = nameInput;
                    break; 
                } 
                else {
                    System.out.println("Invalid Name! Names cannot contain numbers or special characters. Please try again.");
                }
            }

            System.out.print("Grade: ");
            grades[i] = scanner.nextInt();
            scanner.nextLine(); 
        }

        System.out.println("\n========== STUDENT RESULTS ==========\n");
        for (int i = 0; i < numStudents; i++) {
            String status = grades[i] >= 75 ? "PASSED" : "FAILED";
            System.out.printf("%-15s%-10d%s%n", studentNames[i], grades[i], status);
        }

        int highestGrade = findHighest(grades);
        int lowestGrade = findLowest(grades);
        double averageGrade = calculateAverage(grades);
        int passedCount = countPassed(grades);
        int failedCount = numStudents - passedCount;

        System.out.println("\nHighest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowestGrade);
        System.out.printf("Average Grade: %.2f%n", averageGrade);
        System.out.println("Passed Students: " + passedCount);
        System.out.println("Failed Students: " + failedCount);

        scanner.close();
    }

    public static int findHighest(int[] grades) {
        int highest = grades[0];
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public static int findLowest(int[] grades) {
        int lowest = grades[0];
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    public static int countPassed(int[] grades) {
        int passCount = 0;
        for (int grade : grades) {
            if (grade >= 75) {
                passCount++;
            }
        }
        return passCount;
    }
}
