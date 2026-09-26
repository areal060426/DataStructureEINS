package MidtermExam;

import java.util.Scanner;

public class MidtermExamMakasakit {
    
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        
        while (!inputReader.hasNextInt()) {
            System.out.println("Numbers only please.");
            System.out.print("Enter number of students: ");
            inputReader.next(); 
        }
        
        int totalStudents = inputReader.nextInt();
        inputReader.nextLine(); 

        String[] namesArray = new String[totalStudents];
        int[] gradesArray = new int[totalStudents];

        for (int index = 0; index < totalStudents; index++) {
            System.out.println();
            System.out.print("Student " + (index + 1) + " Name: ");
            String tempName = inputReader.nextLine();
            
            while (!tempName.matches("[a-zA-Z ]+")) {
                System.out.println("Please input letters only, not numbers or symbols.");
                System.out.print("Student " + (index + 1) + " Name: ");
                tempName = inputReader.nextLine();
            }
            namesArray[index] = tempName;

            System.out.print("Grade: ");
            
            while (!inputReader.hasNextInt()) {
                System.out.println("Numbers only please.");
                System.out.print("Grade: ");
                inputReader.next(); 
            }
            
            gradesArray[index] = inputReader.nextInt();
            inputReader.nextLine(); 
        }

        System.out.println();
        System.out.println("========== STUDENT RESULTS ==========");
        System.out.println();

        int highestScore = gradesArray[0];
        int lowestScore = gradesArray[0];
        double totalScoreSum = 0;
        int passTally = 0;
        int failTally = 0;

        for (int i = 0; i < totalStudents; i++) {
            String currentName = namesArray[i];
            int currentGrade = gradesArray[i];

            String status = "";
            if (currentGrade >= 75) {
                status = "PASSED";
                passTally = passTally + 1;
            } else {
                status = "FAILED";
                failTally = failTally + 1;
            }

            System.out.printf("%-10s %-7d %s%n", currentName, currentGrade, status);

            if (currentGrade > highestScore) {
                highestScore = currentGrade;
            }

            if (currentGrade < lowestScore) {
                lowestScore = currentGrade;
            }

            totalScoreSum = totalScoreSum + currentGrade;
        }

        double averageScore = totalScoreSum * Math.pow(totalStudents, -1);

        System.out.println();
        System.out.println("Highest Grade: " + highestScore);
        System.out.println("Lowest Grade: " + lowestScore);
        System.out.printf("Average Grade: %.2f%n", averageScore); 
        System.out.println("Passed Students: " + passTally);
        System.out.println("Failed Students: " + failTally);

        inputReader.close();
    }
}