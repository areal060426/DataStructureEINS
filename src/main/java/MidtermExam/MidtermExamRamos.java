package MidtermExam;

import java.util.Scanner;

public class MidtermExamRamos {

        // RAMOS, AL-JUMONG M.
        // II-EINS

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);


            int numStudents;
            do {
                System.out.print("Enter number of students: ");
                numStudents = sc.nextInt();
                sc.nextLine();

                // Simple validation for amount of students
                if (numStudents <= 0) {
                    System.out.println("Invalid input. Please enter a number greater than 0.\n");
                }
            } while (numStudents <= 0);

            System.out.println();

            String[] names = new String[numStudents];
            int[] grades = new int[numStudents];

            for (int i = 0; i < numStudents; i++) {
                System.out.print("Student " + (i + 1) + " Name: ");
                names[i] = sc.nextLine();

                do {
                    System.out.print("Grade: ");
                    grades[i] = sc.nextInt();
                    sc.nextLine();

                    // Simple validation for grades
                    if (grades[i] < 0 || grades[i] > 100) {
                        System.out.println("Invalid grade. Please enter a number between 0 and 100.");
                    }
                } while (grades[i] < 0 || grades[i] > 100);

                System.out.println();
            }
            System.out.println("========== STUDENT RESULTS ==========\n");

            int high = grades[0];
            int low = grades[0];
            double sum = 0;
            int passCount = 0;
            int failCount = 0;

            for (int i = 0; i < numStudents; i++) {
                String status;
                if (grades[i] >= 75) {
                    status = "PASSED";
                    passCount++;
                } else {
                    status = "FAILED";
                    failCount++;
                }

                System.out.printf("%-15s %-7d %s\n", names[i], grades[i], status);

                if (grades[i] > high) {
                    high = grades[i];
                }
                if (grades[i] < low) {
                    low = grades[i];
                }

                sum += grades[i];
            }

            double average = sum / numStudents;

            System.out.println("\nHighest Grade: " + high);
            System.out.println("Lowest Grade: " + low);
            System.out.printf("Average Grade: %.2f\n", average);
            System.out.println("Passed Students: " + passCount);
            System.out.println("Failed Students: " + failCount);

            sc.close();
        }
    }