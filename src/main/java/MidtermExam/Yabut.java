package MidtermExam;

import java.util.Scanner;

public class Yabut {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		// STEP 1: Ask how many students
		System.out.print("Enter number of students: ");
		int numberOfStudents = sc.nextInt();
		sc.nextLine(); // Clear the newline

		// STEP 2: Create arrays to store data
		String[] studentNames = new String[numberOfStudents];
		int[] studentGrades = new int[numberOfStudents];

		// STEP 3: Input student names and grades
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.print("\nStudent " + (i + 1) + " Name: ");
			studentNames[i] = sc.nextLine();

			System.out.print("Grade: ");
			studentGrades[i] = sc.nextInt();
			sc.nextLine(); // Clear the newline
		}

		// STEP 4 & 5: Display results AND Calculate statistics 
		System.out.println("\n========== STUDENT RESULTS ==========\n");
		
		int highestGrade = studentGrades[0];
		int lowestGrade = studentGrades[0];
		int totalGrades = 0;
		int passedCount = 0;
		int failedCount = 0;
		
		for (int i = 0; i < numberOfStudents; i++) {
			// Determine pass/fail status
			String status;
			if (studentGrades[i] >= 75) {
				status = "PASSED";
				passedCount++;
			} else {
				status = "FAILED";
				failedCount++;
			}
				// Display student result
			System.out.println(studentNames[i] + "\t\t" + studentGrades[i] + "\t\t" + status);
			
			// Calculate statistics in the SAME loop
			if (studentGrades[i] > highestGrade) {
				highestGrade = studentGrades[i];
			}
			if (studentGrades[i] < lowestGrade) {
				lowestGrade = studentGrades[i];
			}
			totalGrades += studentGrades[i];
		}
		
		double averageGrade = (double) totalGrades / numberOfStudents;

		// STEP 6: Display statistics
		System.out.println("\nHighest Grade: " + highestGrade);
		System.out.println("Lowest Grade: " + lowestGrade);
		System.out.printf("Average Grade: %.2f\n", averageGrade);
		System.out.println("Passed Students: " + passedCount);
		System.out.println("Failed Students: " + failedCount);

		sc.close();
	}
}