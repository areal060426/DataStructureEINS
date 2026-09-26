/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MidtermExam;

/**
 *
 * @author Aldrin
 */
import java.util.Scanner; 

public class MidtermExamEspaña {
        
    public static void main(String[] args) {
        
            Scanner scanner = new Scanner(System.in);
        
            System.out.println("========== STUDENT REPORT OF GRADES PROGRAM ==========");
            System.out.println("Welcome to the Student's Report of Grades Program\n");
            System.out.println("Insert Number of Students to Start.");
            int StudNo = scanner.nextInt();
            scanner.nextLine();

            String[] Names = new String[StudNo];
            int[] Grades = new int[StudNo];

            for (int i = 0; i < StudNo; i++) {
                System.out.println("Input the Names of the Students.");
                Names[i] = scanner.nextLine();

                System.out.println("Input the Grades of the Students.");
                Grades[i] = scanner.nextInt();
                scanner.nextLine();   
            }
            
            int pass = 0;
            int fail = 0;
            for (int j = 0; j < StudNo; j++) {
                if (Grades[j] >= 75) {
                    System.out.println("Student: "+Names[j]+"\nGrades: "+Grades[j]+"\nPassed.");
                    pass++;
                } else {
                    System.out.println("Student: "+Names[j]+"\nGrades: "+Grades[j]+"\nFailed.");
                    fail++;
                }
        }
            int highest = Grades[0];
            int lowest = Grades[0];
            int sum = 0;
            

            for (int k = 0; k < StudNo; k++) {
                if (Grades[k] > highest) {
                    highest = Grades[k];
                }
                if (Grades[k] < lowest) {
                    lowest = Grades[k];
                } 
            }
            for (int i = 0; i < StudNo; i++) {
                sum += Grades[i];
            }
            
            float mean = (float) sum / StudNo;
            
            System.out.println("Highest Grade: "+highest);
            System.out.println("Lowest Grade: "+lowest);
            System.out.printf("Average Grade: %.2f\n",mean);
            System.out.println("Passed Students: "+pass);
            System.out.println("Failed Students: "+fail);
    }
}
