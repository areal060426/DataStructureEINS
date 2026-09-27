package MidtermExam;

import java.util.Scanner;

public class MidtermExamCamering

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // 1. Ask the user how many students will be entered
        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();
        input.nextLine(); // Clear the buffer line after reading an integer

        // 2 & 3. Store the student names in a String[] array and grades in an int[] array
        String[] names = new String[numStudents];
        int[] grades = new int[numStudents];

        // 4. Ask the user to enter each student's name and grade
        for (int i = 0; i < numStudents; i++) {
            System.out.println(); // Prints a blank line to match sample input spacing
            System.out.println("Student " + (i + 1));
            System.out.print("Name: ");
            names[i] = input.nextLine();
            System.out.print("Grade: ");
            grades[i] = input.nextInt();
            input.nextLine(); // Clear the buffer line after reading an integer
        }

        // Variables for tracking summary data
        int totalGrade = 0;
        int passedCount = 0;
        int failedCount = 0;
        
        // Initialize highest and lowest with the very first student's grade
        int highestGrade = grades[0];
        int lowestGrade = grades[0];

        // 5. Display all students and their grades
        System.out.println("\n========== STUDENT RESULTS ==========");
        for (int i = 0; i < numStudents; i++) {
            
            // 7. A grade of 75 or higher is PASSED; below 75 is FAILED
            String status;
            if (grades[i] >= 75) {
                status = "PASSED";
                passedCount = passedCount + 1;
            } else {
                status = "FAILED";
                failedCount = failedCount + 1;
            }

            // Print student row matching formatting requirements
            System.out.println(names[i] + "\t" + grades[i] + "\t" + status);

            // Accumulate total sum for the average calculation
            totalGrade = totalGrade + grades[i];

            // 6. Determine Highest and Lowest grades
            if (grades[i] > highestGrade) {
                highestGrade = grades[i];
            }
            if (grades[i] < lowestGrade) {
                lowestGrade = grades[i];
            }
        }

        // Calculate average grade using double casting for precise decimal division
        double averageGrade = (double) totalGrade / numStudents;

        // Display final statistics summary block
        System.out.println();
        System.out.println("Highest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowestGrade);
        System.out.printf("Average Grade: %.2f\n", averageGrade); // Formats to exactly two decimal places
        System.out.println("Passed Students: " + passedCount);
        System.out.println("Failed Students: " + failedCount);

        input.close();
    }
}
