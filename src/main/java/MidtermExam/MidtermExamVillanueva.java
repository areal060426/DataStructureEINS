package MidtermExam;

import java.util.*;

public class MidtermExamVillanueva {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("How many students? ");
		int size = scanner.nextInt();
		
		String[] names = new String[size];
		double [] grades = new double[size];
		
		int studentcount = 1;
		
		//GET NAMES AND GRADES
		for (int i = 0; i < size; i++) {
			System.out.print("Enter Student " + studentcount + " Name: ");
			names[i] = scanner.next();
			
			System.out.print("Enter Grade: ");
			grades[i] =  scanner.nextDouble();
			studentcount++;
		}
		
		System.out.println(" ");
		
	    double highest = grades[0];
	    double lowest = grades[0];
	    double totalgrades = 0;
		
	    int passed = 0;
	    int failed = 0;
	    
	    //CHECKS GRADES
		for (int i = 0; i < size; i++) {
			
			if (grades[i] > highest) {
				highest = grades[i]; //Replaces the value in highest taken from grades
			}
			if (grades[i] < lowest) {
				lowest = grades[i];
			}
			
			totalgrades += grades[i];
			
			
			if (grades[i] >= 75) {
				passed++;
	
			}
			else {
				failed++;
			
			}
					
			
		}
		
		double average = totalgrades / size;
		
		System.out.println("\n========== STUDENT RESULTS ==========");
		
		//PRINT NAME GRADE AND STATUS
		for (int i = 0; i < size; i++) {
			
			if (grades[i] >= 75) {
				System.out.println(names[i] + " - " + grades[i] + " - PASSED" );
	
			}
			else {
				System.out.println(names[i] + " - " + grades[i] + " - FAILED" );
			}


		}
		System.out.println("Highest Grade: " + highest);
		System.out.println("Lowest Grade: " + lowest);
		System.out.println("Average Grade: " + average);
		System.out.println("Passed Students: " + passed);
		System.out.println("Failed Students: " + failed);
		
	}

}
