package MidtermExam;
import java.util.Scanner;
//MidtermExam RafaeL Jr. Canalda
public class MidtermExamCanalda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = 0;
        
       
        System.out.print("Enter number of students: ");
        while (true) {
            if (scanner.hasNextInt()) {
                numStudents = scanner.nextInt();
                scanner.nextLine(); 
                
             // Input validation for number of students
                if (numStudents > 0) {
                    break; // Exit loop if valid
                } else {
                    System.out.print("Number of students must be greater than 0. Try again: ");
                }
            } else {
                System.out.print("Invalid input. Please enter a whole number: ");
                scanner.nextLine(); 
            }
        }

        // Initialize arrays
        String[] names = new String[numStudents];
        int[] grades = new int[numStudents];

        // Gather Inputs
        for (int i = 0; i < numStudents; i++) {
            // Input validation for names (letters and spaces only)
            System.out.print("\nStudent " + (i + 1) + " Name: ");
            while (true) {
                String inputName = scanner.nextLine().trim();
                if (!inputName.isEmpty() && inputName.matches("^[a-zA-Z\\s]+$")) {
                    names[i] = inputName;
                    break;
                } else {
                    System.out.print("Invalid input. Please enter letters only for the name: ");
                }
            }
            
            // Input validation for grades
            System.out.print("Grade: ");
            while (true) {
                if (scanner.hasNextInt()) {
                    grades[i] = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (grades[i] >= 0 && grades[i] <= 100) {
                        break; // Exit loop if valid
                    } else {
                        System.out.print("Grade must be between 0 and 100. Try again: ");
                    }
                } else {
                    System.out.print("Invalid input. Please enter a number: ");
                    scanner.nextLine();
                }
            }
        }

        System.out.println("\n|==========> STUDENT RESULTS <==========|\n");

        int highest = grades[0];
        int lowest = grades[0];
        double sum = 0;
        int passed = 0;
        int failed = 0;

        for (int i = 0; i < numStudents; i++) {
            String status;
            if (grades[i] >= 75) {
                status = "PASSED";
                passed++;
            } else {
                status = "FAILED";
                failed++;
            }

            System.out.printf("%s %d %s\n", names[i], grades[i], status);

            if (grades[i] > highest) {
                highest = grades[i];
            }
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
            sum += grades[i];
        }

        double average = sum / numStudents;

        System.out.println("\nHighest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Passed Students: " + passed);
        System.out.println("Failed Students: " + failed);

        scanner.close();
    }
}
