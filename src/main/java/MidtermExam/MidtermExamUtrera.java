package MidtermExam;

import java.util.Scanner;

public class MidtermExamUtrera {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.print("Student " + (i + 1) + " Name: ");
            names[i] = sc.next();

            System.out.print("Grade: ");
            grades[i] = sc.nextInt();
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
            String status;
            if (grades[i] >= 75) {
                status = "PASSED";
                passed = passed + 1;
            } else {
                status = "FAILED";
                failed = failed + 1;
            }

            System.out.println(names[i] + "\t" + grades[i] + "\t" + status);

            if (grades[i] > highest) {
                highest = grades[i];
            }
            if (grades[i] < lowest) {
                lowest = grades[i];
            }

            total = total + grades[i];
        }

        double average = (double) total / n;

        System.out.println();
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.println("Average Grade: " + average);
        System.out.println("Passed Students: " + passed);
        System.out.println("Failed Students: " + failed);

        sc.close();
    }
}