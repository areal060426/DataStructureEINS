package MidtermExam;

import java.util.Scanner;

public class MidtermExamEspijon {

    static Scanner scanner = new Scanner(System.in);
    static String[] names;
    static int[] grades;

    public static void main(String[] args) {
        int total = getStudentCount();

        names = new String[total];
        grades = new int[total];

        int idx = 0;
        while (idx < total) {
            System.out.println();


            String name = "";


            while (name.isEmpty()){

                System.out.print("Student " + (idx + 1) + " Name: ");
                name = scanner.nextLine().trim();
            }

            names[idx] = name;


            grades[idx] = gradeValidator(); //will just call the gradeValidator

            idx++;
        }

        System.out.println();
        System.out.println("------ STUDENT RESULTS ------");
        System.out.println();

        int highest = grades[0];
        int lowest =  grades[0];
        int sum = 0;
        int passed = 0;
        int failed = 0;

        idx = 0;
        while (idx < total) {
            int grade = grades[idx];
            String status = isPassing(grade) ? "PASSED" : "FAILED";

            if (isPassing(grade)) {
                passed++;
            } else {
                failed++;
            }

            if (grade > highest) {
                highest = grade;
            }
            if (grade < lowest) {
                lowest = grade;
            }
            sum += grade;

            System.out.printf("%-10s %-10d %s%n", names[idx], grade, status);
            idx++;
        }

        double average = (double) sum / total;

        System.out.println();
        System.out.println("Highest Student Grade: " + highest);
        System.out.println("Lowest Student Grade: " + lowest);
        System.out.printf("Computed Grade Average : %.2f%n", average);

        System.out.println();

        System.out.println("------ NO. OF STUDENTS ------");
        System.out.println("No. of Passed Students: " + passed);
        System.out.println("No. of Failed Students: " + failed);


        scanner.close();
    }

    static int getStudentCount() {
        int total = -1;
        boolean isValid = false;

        while (!isValid) {
            System.out.print("Enter number of students: ");
            try {
                total = Integer.parseInt(scanner.nextLine().trim());

                if (total > 0) {
                    isValid = true;
                } else {
                    System.out.println("Please Enter a number greater than 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please Enter a valid number");
            }
        }

        return total;
    }

    static boolean isPassing(int grade) {
        return grade >= 75;
    }

    static int gradeValidator() {
        int grade = -1;
        boolean isValid = false;

        while (!isValid){
            System.out.print("Grade: ");
            try {
                grade = Integer.parseInt(scanner.nextLine().trim());


                if (grade >= 0 && grade <= 100){
                    isValid = true;
                } else {
                    System.out.println("Please enter a valid grade between 0 and 100");

                }
            } catch (NumberFormatException e){
                System.out.println("Please Enter a valid number");
            }
        }

        return grade;

    }


}