package MidtermExam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MidtermExamLicudine {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 0;

        while (true) {
            try {
                System.out.print("Enter number of students: ");
                n = sc.nextInt();
                sc.nextLine();

                if (n <= 0) {
                    System.out.println("Number of students must be greater than 0. Please try again.");
                    continue;
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                sc.nextLine();
            }
        }

        String[] names = new String[n];
        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.println();

            while (true) {
                try {
                    System.out.print("Student " + (i + 1) + " Name: ");
                    String nameInput = sc.nextLine().trim();

                    if (nameInput.isEmpty()) {
                        throw new IllegalArgumentException("Name cannot be empty.");
                    }

                    for (int c = 0; c < nameInput.length(); c++) {
                        char ch = nameInput.charAt(c);
                        if (Character.isDigit(ch)) {
                            throw new IllegalArgumentException("Name cannot contain numbers.");
                        }
                    }

                    names[i] = nameInput;
                    break;

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + " Please try again.");
                }
            }

            while (true) {
                try {
                    System.out.print("Grade: ");
                    grades[i] = sc.nextInt();
                    sc.nextLine();

                    if (grades[i] < 0 || grades[i] > 100) {
                        System.out.println("Grade must be between 0 and 100. Please try again.");
                        continue;
                    }
                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a whole number for the grade.");
                    sc.nextLine();
                }
            }
        }

        int highest = grades[0];
        int lowest = grades[0];
        int total = 0;
        int passed = 0;
        int failed = 0;

        for (int i = 0; i < n; i++) {

            total = total + grades[i];

            if (grades[i] > highest) {
                highest = grades[i];
            }

            if (grades[i] < lowest) {
                lowest = grades[i];
            }

            if (grades[i] >= 75) {
                passed++;
            } else {
                failed++;
            }
        }

        double average = (double) total / n;

        System.out.println();
        System.out.println("========== STUDENT RESULTS ==========");
        System.out.println();

        for (int i = 0; i < n; i++) {

            String status;

            if (grades[i] >= 75) {
                status = "PASSED";
            } else {
                status = "FAILED";
            }

            System.out.println(names[i] + "   " + grades[i] + "   " + status);
        }

        System.out.println("\nHighest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.println("Passed Students: " + passed);
        System.out.println("Failed Students: " + failed);

        sc.close();
    }
}