package MidtermExam;

import java.util.Scanner;

public class MidtermExamViesca {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of Students: ");

        while (!input.hasNextInt()) {

            System.out.println("Invalid input! Please enter a number.");
            input.next();

            System.out.print("Enter number of students: ");
        }

        int numOfStudents = input.nextInt();
        input.nextLine();

        while (numOfStudents <= 0) {

            System.out.println("Invalid input! Number of students must be greater than 0.");
            System.out.print("Enter number of students: ");

            while (!input.hasNextInt()) {

                System.out.println("Invalid input! Please enter a number.");
                input.next();

                System.out.print("Enter number of students: ");
            }

            numOfStudents = input.nextInt();
            input.nextLine();
        }

        String[] names = new String[numOfStudents];
        int[] grades = new int[numOfStudents];

        for (int i = 0; i < numOfStudents; i++) {

            while (true) {

                System.out.print("\nStudent " + (i + 1) + " Name: ");
                String name = input.nextLine();

                if (name.matches("[a-zA-Z ]+")) {

                    names[i] = name;
                    break;

                } else {

                    System.out.println("Invalid input! Name should contain letters only.");
                }
            }

            // Input grade
            while (true) {

                System.out.print("Grade: ");

                if (input.hasNextInt()) {

                    grades[i] = input.nextInt();
                    input.nextLine();
                    break;

                } else {

                    System.out.println("Invalid input! Please enter a number.");
                    input.nextLine();
                }
            }
        }

        // Variables
        int highest = grades[0];
        int lowest = grades[0];
        int total = 0;
        int passed = 0;
        int failed = 0;

        // Calculate results
        for (int i = 0; i < numOfStudents; i++) {

            total += grades[i];

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

        double average = (double) total / numOfStudents;

        // Display results
        System.out.println("\n=== STUDENT RESULTS ===");

        for (int i = 0; i < numOfStudents; i++) {

            if (grades[i] >= 75) {

                System.out.println(names[i] + "      " + grades[i] + "      PASSED");

            } else {

                System.out.println(names[i] + "      " + grades[i] + "      FAILED");
            }
        }

        System.out.println("\nHighest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.println("Passed Students: " + passed);
        System.out.println("Failed Students: " + failed);

        input.close();
    }
}
