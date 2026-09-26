package MidtermExam;

import java.util.Scanner;

public class MidtermExamMarcellana {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of students: ");
        int count = scanner.nextInt();
        scanner.nextLine(); 


        String[] names = new String[count];
        int[] grades = new int[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            names[i] = scanner.nextLine();

            System.out.print("Enter grade for " + names[i] + ": ");
            grades[i] = scanner.nextInt();
            scanner.nextLine(); 
        }

        
        int highest = grades[0];
        int lowest = grades[0];
        int sum = 0;
        int passedCount = 0;
        int failedCount = 0;

       
        System.out.println("\n =-=-= STUDENT GRADES =-=-=");
        for (int i = 0; i < count; i++) {
            
            String status;
            if (grades[i] >= 75) {
                status = "PASSED";
                passedCount++;
            } else {
                status = "FAILED";
                failedCount++;
            }

            
            System.out.println(names[i] + ": " + grades[i] + " - " + status);

           
            if (grades[i] > highest) {
                highest = grades[i];
            }
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
            
            sum += grades[i];
        }

       
        double average = (double) sum / count;

        System.out.println("\n =-=-= SUMMARY =-=-=");
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.println("Average Grade: " + average);
        System.out.println("Passed Students: " + passedCount);
        System.out.println("Failed Students: " + failedCount);

        scanner.close();
    }
}