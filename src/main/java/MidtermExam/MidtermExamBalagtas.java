package MidtermExam;

import java.util.Scanner;

public class MidtermExamBalagtas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int totalStudents = input.nextInt();
        input.nextLine(); 

        System.out.println();

        String[] studentNames = new String[totalStudents];
        int[] studentGrades = new int[totalStudents];

        for (int i = 0; i < totalStudents; i++) {
            System.out.print("Student " + (i + 1) + " Name: ");
            studentNames[i] = input.nextLine();

            System.out.print("Grade: ");
            studentGrades[i] = input.nextInt();
            input.nextLine(); 

            System.out.println();
        }

        int maxGrade = studentGrades[0];
        int minGrade = studentGrades[0];
        double sum = 0;
        int passCount = 0;
        int failCount = 0;

        System.out.println("========== STUDENT RESULTS ==========");

        for (int i = 0; i < totalStudents; i++) {
            int currentGrade = studentGrades[i];
            String result;

            if (currentGrade >= 75) {
                result = "PASSED";
                passCount++;
            } else {
                result = "FAILED";
                failCount++;
            }

            if (currentGrade > maxGrade) {
                maxGrade = currentGrade;
            }
            
            if (currentGrade < minGrade) {
                minGrade = currentGrade;
            }

            sum += currentGrade;

            System.out.println(studentNames[i] + "\t\t" + currentGrade + "\t" + result);
        }

        double avgGrade = sum / totalStudents;

        System.out.println();
        System.out.println("Highest Grade: " + maxGrade);
        System.out.println("Lowest Grade: " + minGrade);
        System.out.println("Average Grade: " + String.format("%.2f", avgGrade));
        System.out.println("Passed Students: " + passCount);
        System.out.println("Failed Students: " + failCount);

        input.close();
    }
}
