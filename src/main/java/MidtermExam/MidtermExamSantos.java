package MidtermExam;
import java.util.Scanner;

public class MidtermExamSantos {
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

        int highest = grades[0];
        int lowest = grades[0];
        int sum = 0;
        int passedCount = 0;
        int failedCount = 0;

        for (int i = 0; i < n; i++) {
            if (grades[i] > highest) highest = grades[i];
            if (grades[i] < lowest) lowest = grades[i];
            sum += grades[i];

            if (grades[i] >= 75) {
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

        sc.close();
    }
}
