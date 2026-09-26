package MidtermExam;
import java.util.Scanner;

public class MidtermExamBallero {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("ENTER NUMBER OF STUDENTS : ");
		int numStudents = Integer.parseInt(scanner.nextLine().trim());
		
		String[] names = new String[numStudents];
		int [] grades = new int[numStudents];
		
		for (int i = 0; i < numStudents; i++) {
		System.out.println();
		System.out.print("Student " + (i + 1) + " Name : ");
		names[i] = scanner.nextLine().trim();
		
		System.out.print("Grade: ");
		grades [i] = Integer.parseInt(scanner.nextLine().trim());
		
	}
	
	System.out.println();
	System.out.println("=====STUDENT RESULTS=====");
	
	int highest = grades [0];
	int lowest = grades [0];
	int sum = 0;
	int passedCount = 0;
	int failedCount = 0;
	
	for (int i = 0; i <numStudents; i++) {
		int grade = grades [i];
		
		String status = (grade >= 75) ? "PASSED" : "FAILED";
		
		System.out.printf("%-10s %-7d %s%n", names [i], grade, status);
		
		if (grade > highest) highest = grade;
		if (grade < lowest) lowest = grade;
		sum += grade;
		
		if (grade >=75) {
			passedCount++;
		} else {
			failedCount++;
		}
	}
	
	double average = (double) sum / numStudents;
	
	//OUTPUT STATISTICS SUMMARY

	System.out.println();
	System.out.println("HIGHEST GRADE: " + highest);
	System.out.println("LOWEST GRADE: " + lowest);
	System.out.printf("AVERAGE GRADE: %.2f%n", average);
	System.out.println("PASSED STUDENTS: " + passedCount);
	System.out.println("FAILED STUDENTS: " + failedCount);
	
	scanner.close();
	
	}

}
