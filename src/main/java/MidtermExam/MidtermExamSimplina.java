package MidtermExam;

//DAREN L. SIMPLINA

import java.util.Scanner;
public class MidtermExamSimplina {
	

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

     
        System.out.print("Enter number of students: ");
        int numberOfStudents = input.nextInt();
        input.nextLine();

       
        String[] names = new String[numberOfStudents];
        int[] grades = new int[numberOfStudents];

      
        for (int i = 0; i < numberOfStudents; i++) {

            System.out.print("\nStudent " + (i + 1) + " Name: ");
            names[i] = input.nextLine();

            System.out.print("Grade: ");
            grades[i] = input.nextInt();
            input.nextLine();
        }

    
        int highest = grades[0];
        int lowest = grades[0];
        int total = 0;
        int passed = 0;
        int failed = 0;

      
        for (int i = 0; i < numberOfStudents; i++) {

          
            if (grades[i] > highest) {
                highest = grades[i];
            }

         
            if (grades[i] < lowest) {
                lowest = grades[i];
            }

         
            total += grades[i];

         
            if (grades[i] >= 75) {
                passed++;
            } else {
                failed++;
            }
        }

      
        double average = (double) total / numberOfStudents;

        System.out.println();
        System.out.println("========== STUDENT RESULTS ==========");

        for (int i = 0; i < numberOfStudents; i++) {

            if (grades[i] >= 75) {
                System.out.printf("%-10s %d      PASSED%n",
                        names[i], grades[i]);
            } else {
                System.out.printf("%-10s %d      FAILED%n",
                        names[i], grades[i]);
            }
        }

  
        System.out.println();
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.println("Passed Students: " + passed);
        System.out.println("Failed Students: " + failed);

        input.close();
    }
}