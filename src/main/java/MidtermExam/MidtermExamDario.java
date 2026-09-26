package MidtermExam;

import java.util.Scanner;

public class MidtermExamDario {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

       
        String[] names = new String[n];
        int[] grades = new int[n];

       
        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.print("Student " + (i + 1) + " Name: ");
            names[i] = scanner.nextLine();

            System.out.print("Grade: ");
            grades[i] = scanner.nextInt();
            scanner.nextLine(); 
        }

        
        int highest = grades[0];
        int lowest = grades[0];
        int sum = 0;
        int passedCount = 0;
        int failedCount = 0;

        for (int i = 0; i < n; i++) {
            int grade = grades[i];

            if (grade > highest) {
                highest = grade;
            }
            if (grade < lowest) {
                lowest = grade;
            }

            sum += grade;

            if (grade >= 75) {
                passedCount++;
            } else {
                failedCount++;
            }
        }

        double average = (double) sum / n;

        
        System.out.println("\n========== STUDENT RESULTS ==========\n");
        for (int i = 0; i < n; i++) {
            String status = (grades[i] >= 75) ? "PASSED" : "FAILED";
            System.out.printf("%-10s %-7d %s%n", names[i], grades[i], status);
        }

        System.out.println();
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.println("Passed Students: " + passedCount);
        System.out.println("Failed Students: " + failedCount);

        scanner.close();
    }
}