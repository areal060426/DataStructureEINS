package MidtermExam;
import java.util.Scanner;

public class MidtermExamTinitigan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        String[] names = new String[n];
        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.print("Student " + (i + 1) + " Name: ");
            names[i] = sc.nextLine().trim();

            System.out.print("Grade: ");
            grades[i] = Integer.parseInt(sc.nextLine().trim());
        }

        System.out.println();
        System.out.println("========== STUDENT RESULTS ==========");
        System.out.println();

        int highest = grades[0];
        int lowest = grades[0];
        int total = 0;
        int passed = 0;
        int failed = 0;

        for (int i = 0; i < n; i++) {
            String status = (grades[i] >= 75) ? "PASSED" : "FAILED";
            System.out.printf("%-10s %-7d %s%n", names[i], grades[i], status);

            if (grades[i] > highest) highest = grades[i];
            if (grades[i] < lowest) lowest = grades[i];
            total += grades[i];

            if (grades[i] >= 75) {
                passed++;
            } else {
                failed++;
            }
        }

        double average = (double) total / n;

        System.out.println();
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.println("Passed Students: " + passed);
        System.out.println("Failed Students: " + failed);

        sc.close();
    }
}
