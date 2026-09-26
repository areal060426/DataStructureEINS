package MidtermExam;
import java.util.Scanner;

public class MidtermExamResurreccion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] names = new String[n];
        int[] grades = new int[n];

        // Input student names and grades
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " Name: ");
            names[i] = sc.nextLine();
            System.out.print("Grade: ");
            grades[i] = sc.nextInt();
            sc.nextLine(); // consume newline
        }

        System.out.println("\n========== STUDENT RESULTS ==========");
        int highest = grades[0];
        int lowest = grades[0];
        int sum = 0;
        int passed = 0;
        int failed = 0;

        // Display students and compute stats
        for (int i = 0; i < n; i++) {
            String status = (grades[i] >= 75) ? "PASSED" : "FAILED";
            System.out.printf("%-10s %3d   %s\n", names[i], grades[i], status);

            if (grades[i] > highest) highest = grades[i];
            if (grades[i] < lowest) lowest = grades[i];
            sum += grades[i];
            if (grades[i] >= 75) passed++;
            else failed++;
        }

        double average = (double) sum / n;

        // Display results
        System.out.println("\nHighest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Passed Students: " + passed);
        System.out.println("Failed Students: " + failed);

        sc.close();
    }
}

