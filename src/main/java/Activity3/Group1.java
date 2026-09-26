package Activity3;

import java.util.Scanner;

/*
Group 1 — Student Ranking System

Difficulty: Hard

Create a system that asks for the number of students, their names, and grades. Sort the students from highest to lowest grade, while keeping the correct name connected to each grade.

Additional requirements:

Display original records.
Display sorted ranking.
Display highest and lowest grade.
Compute average grade.
Display students above average.
Handle students with equal grades.


*/


public class Group1 {

    static String[] names;
    static double[] grades;
    static String[] sortedNames;
    static double[] sortedGrades;
    static int studentCount;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loadStudentData();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readMenuChoice();

            switch (choice) {
                case 1:
                    displayOriginalRecords();
                    break;
                case 2:
                    performSortAndStore();
                    displaySortedRanking();
                    break;
                case 3:
                    displayHighestAndLowest();
                    break;
                case 4:
                    displayAverage();
                    break;
                case 5:
                    displayAboveAverage();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:

                    System.out.println("Invalid option. Please choose a number from 1 to 6.\n");
                    break;
            }
        }

        scanner.close();
    }


    static void loadStudentData() {
        int n = 0;
        boolean validCount = false;

        while (!validCount) {
            System.out.print("Enter the number of students: ");
            String input = scanner.nextLine().trim();
            try {
                n = Integer.parseInt(input);
                if (n <= 0) {
                    System.out.println("Please enter a number greater than 0.");
                } else {
                    validCount = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }

        studentCount = n;
        names = new String[n];
        grades = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");

            String name = "";
            while (name.isEmpty()) {
                System.out.print("Enter name: ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty. Try again.");
                }
            }
            names[i] = name;

            boolean validGrade = false;
            double grade = 0;
            while (!validGrade) {
                System.out.print("Enter grade for " + name + " (0-100): ");
                String gradeInput = scanner.nextLine().trim();
                try {
                    grade = Double.parseDouble(gradeInput);
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                    } else {
                        validGrade = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric grade.");
                }
            }
            grades[i] = grade;
        }

        System.out.println("\nAll student records have been entered successfully.\n");
    }

    static void printMenu() {
        System.out.println("========== STUDENT RANKING MENU ==========");
        System.out.println("1. Display original records");
        System.out.println("2. Sort and display ranking (highest to lowest)");
        System.out.println("3. Display highest and lowest grade");
        System.out.println("4. Display average grade");
        System.out.println("5. Display students above average");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    static int readMenuChoice() {
        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void displayOriginalRecords() {
        System.out.println("\n----- ORIGINAL RECORDS (input order) -----");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%d. %-15s %.2f%n", (i + 1), names[i], grades[i]);
        }
        System.out.println();
    }


    static void performSortAndStore() {

        sortedNames = new String[studentCount];
        sortedGrades = new double[studentCount];
        for (int i = 0; i < studentCount; i++) {
            sortedNames[i] = names[i];
            sortedGrades[i] = grades[i];
        }

        for (int pass = 0; pass < studentCount - 1; pass++) {
            for (int j = 0; j < studentCount - 1 - pass; j++) {
                if (sortedGrades[j] < sortedGrades[j + 1]) {

                    double tempGrade = sortedGrades[j];
                    sortedGrades[j] = sortedGrades[j + 1];
                    sortedGrades[j + 1] = tempGrade;

                    String tempName = sortedNames[j];
                    sortedNames[j] = sortedNames[j + 1];
                    sortedNames[j + 1] = tempName;
                }
            }
        }
    }

    static void displaySortedRanking() {
        System.out.println("\n----- STUDENT RANKING (highest to lowest) -----");
        int rank = 1;
        for (int i = 0; i < studentCount; i++) {

            if (i > 0 && sortedGrades[i] == sortedGrades[i - 1]) {
                System.out.printf("(tie) %-15s %.2f%n", sortedNames[i], sortedGrades[i]);
            } else {
                System.out.printf("%d. %-15s %.2f%n", rank, sortedNames[i], sortedGrades[i]);
            }
            rank++;
        }
        System.out.println();
    }

    static void displayHighestAndLowest() {

        double highest = grades[0];
        double lowest = grades[0];

        for (int i = 1; i < studentCount; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }

        String highestNames = collectNamesWithGrade(highest);
        String lowestNames = collectNamesWithGrade(lowest);

        System.out.println("\n----- HIGHEST / LOWEST -----");
        System.out.printf("Highest grade: %s with %.2f%n", highestNames, highest);
        System.out.printf("Lowest grade:  %s with %.2f%n%n", lowestNames, lowest);
    }


    static String collectNamesWithGrade(double targetGrade) {
        String result = "";
        for (int i = 0; i < studentCount; i++) {
            if (grades[i] == targetGrade) {
                if (result.isEmpty()) {
                    result = names[i];
                } else {
                    result += ", " + names[i];
                }
            }
        }
        return result;
    }

    static double computeAverage() {
        double sum = 0;
        for (int i = 0; i < studentCount; i++) {
            sum += grades[i];
        }
        return sum / studentCount;
    }

    static void displayAverage() {
        double average = computeAverage();
        System.out.printf("%nAverage grade of the class: %.2f%n%n", average);
    }

    static void displayAboveAverage() {
        double average = computeAverage();
        System.out.printf("%n----- STUDENTS ABOVE AVERAGE (%.2f) -----%n", average);

        boolean anyAbove = false;
        for (int i = 0; i < studentCount; i++) {
            if (grades[i] > average) {
                System.out.printf("%-15s %.2f%n", names[i], grades[i]);
                anyAbove = true;
            }
        }

        if (!anyAbove) {
            System.out.println("No students scored above the average.");
        }
        System.out.println();
    }



}
