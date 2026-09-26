package MidtermExam;
//MIDTERM EXAM OCAMPO
import java.util.Scanner;

public class MidtermExamOcampo {

	 public static void main(String[] args) {

	        Scanner input = new Scanner(System.in);

	        // Ask for number of students
	        int numberOfStudents;

	        while (true) {
	            System.out.print("Enter number of students: ");

	            if (input.hasNextInt()) {
	                numberOfStudents = input.nextInt();
	                input.nextLine();

	                if (numberOfStudents > 0) {
	                    break;
	                } else {
	                    System.out.println("Invalid number. Please enter a number greater than 0.");
	                }

	            } else {
	                System.out.println("Invalid input. Please enter numbers only.");
	                input.nextLine();
	            }
	        }

	        // Create arrays
	        String[] names = new String[numberOfStudents];
	        int[] grades = new int[numberOfStudents];

	        // Input names and grades
	        for (int i = 0; i < numberOfStudents; i++) {

	            // Input name
	            while (true) {
	                System.out.print("\nStudent " + (i + 1) + " Name: ");
	                String name = input.nextLine();

	                if (name.matches("[a-zA-Z ]+")) {
	                    names[i] = name;
	                    break;
	                } else {
	                    System.out.println("Invalid name. Please enter letters only.");
	                }
	            }

	            // Input grade
	            while (true) {
	                System.out.print("Grade: ");

	                if (input.hasNextInt()) {
	                    int grade = input.nextInt();

	                    if (grade >= 0 && grade <= 100) {
	                        grades[i] = grade;
	                        input.nextLine();
	                        break;
	                    } else {
	                        System.out.println("Invalid grade. Please enter 0-100.");
	                    }

	                } else {
	                    System.out.println("Invalid grade. Please enter numbers only.");
	                    input.nextLine();
	                }
	            }
	        }

	        // Variables for calculations
	        int highest = grades[0];
	        int lowest = grades[0];
	        int total = 0;
	        int passed = 0;
	        int failed = 0;

	        // Calculate results
	        for (int i = 0; i < numberOfStudents; i++) {

	            total = total + grades[i];

	            if (grades[i] > highest) {
	                highest = grades[i];
	            }

	            if (grades[i] < lowest) {
	                lowest = grades[i];
	            }

	            if (grades[i] >= 75) {
	                passed++;
	            } else {
	                failed++;
	            }
	        }

	        double average = (double) total / numberOfStudents;

	        // Display results
	        System.out.println("\n========== STUDENT RESULTS ==========");

	        for (int i = 0; i < numberOfStudents; i++) {

	            if (grades[i] >= 75) {
	                System.out.println(names[i] + "\t" + grades[i] + "\tPASSED");
	            } else {
	                System.out.println(names[i] + "\t" + grades[i] + "\tFAILED");
	            }
	        }

	        System.out.println("\nHighest Grade: " + highest);
	        System.out.println("Lowest Grade: " + lowest);
	        System.out.printf("Average Grade: %.2f\n", average);
	        System.out.println("Passed Students: " + passed);
	        System.out.println("Failed Students: " + failed);

	        input.close();
	    }
	}
	
