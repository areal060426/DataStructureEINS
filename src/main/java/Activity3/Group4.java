package Activity3;

import java.util.Scanner;
/*
 * Group 4 — 2D Array Grade Management System


Use a 2D array.

Example:

double[][] grades;

Rows = students
Columns = subjects

Example:

              Java   Database   Networking
Student 1      90       85          88
Student 2      75       92          80
Student 3      88       91          94

The program must:

Ask number of students.
Ask number of subjects.
Input student names.
Input grades.
Compute average of every student.
Compute average of every subject.
Sort students based on overall average.
Determine Top 1, Top 2, and Top 3.
Determine highest grade per subject.
Determine lowest grade per subject.
Display students who failed any subject.

*/
public class Group4 {

    Scanner sc = new Scanner(System.in);

    int n, m;
    String[] names;
    String[] subj;
    double[][] grades;
    double[] avg;
    double[] subAvg;
    boolean hasData = false;

    public static void main(String[] args) {
        Group4 g = new Group4();
        g.start();
    }

    void start() {
        inputData();
        showAverages();
        sortStudents();
        topThree();
        highestPerSubject();
        lowestPerSubject();
        failedStudents();
        sc.close();
    }

    int getInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Not a number, try again: ");
            }
        }
    }

    double getDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Not a number, try again: ");
            }
        }
    }

    void inputData() {
        System.out.print("Number of students: ");
        n = getInt();
        System.out.print("Number of subjects: ");
        m = getInt();

        names = new String[n];
        subj = new String[m];
        grades = new double[n][m];

        for (int j = 0; j < m; j++) {
            System.out.print("Subject " + (j + 1) + " name: ");
            subj[j] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + " name: ");
            names[i] = sc.nextLine();
            for (int j = 0; j < m; j++) {
                System.out.print(names[i] + " grade in " + subj[j] + ": ");
                grades[i][j] = getDouble();
            }
        }

        avg = null;
        subAvg = null;
        hasData = true;
        System.out.println("Data saved.\n");
    }

    void showAverages() {
        avg = new double[n];
        System.out.println("--- Student averages ---");
        for (int i = 0; i < n; i++) {
            double sum = 0;
            for (int j = 0; j < m; j++) sum += grades[i][j];
            avg[i] = sum / m;
            System.out.println(names[i] + " average: " + avg[i]);
        }

        subAvg = new double[m];
        System.out.println("--- Subject averages ---");
        for (int j = 0; j < m; j++) {
            double sum = 0;
            for (int i = 0; i < n; i++) sum += grades[i][j];
            subAvg[j] = sum / n;
            System.out.println(subj[j] + " average: " + subAvg[j]);
        }
        System.out.println();
    }

    void sort() {
        if (avg == null) showAverages();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (avg[j] < avg[j + 1]) {
                    double tempAvg = avg[j];
                    avg[j] = avg[j + 1];
                    avg[j + 1] = tempAvg;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;

                    double[] tempRow = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempRow;
                }
            }
        }
    }

    void sortStudents() {
        sort();
        System.out.println("Ranking:");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + names[i] + " - " + avg[i]);
        }
        System.out.println();
    }

    void topThree() {
        sort();
        int top = Math.min(3, n);
        for (int i = 0; i < top; i++) {
            System.out.println("Top " + (i + 1) + ": " + names[i] + " (" + avg[i] + ")");
        }
        System.out.println();
    }

    void highestPerSubject() {
        for (int j = 0; j < m; j++) {
            double max = grades[0][j];
            int idx = 0;
            for (int i = 1; i < n; i++) {
                if (grades[i][j] > max) {
                    max = grades[i][j];
                    idx = i;
                }
            }
            System.out.println(subj[j] + " highest: " + max + " (" + names[idx] + ")");
        }
        System.out.println();
    }

    void lowestPerSubject() {
        for (int j = 0; j < m; j++) {
            double min = grades[0][j];
            int idx = 0;
            for (int i = 1; i < n; i++) {
                if (grades[i][j] < min) {
                    min = grades[i][j];
                    idx = i;
                }
            }
            System.out.println(subj[j] + " lowest: " + min + " (" + names[idx] + ")");
        }
        System.out.println();
    }

    void failedStudents() {
        boolean noneFailed = true;
        for (int i = 0; i < n; i++) {
            String fail = "";
            for (int j = 0; j < m; j++) {
                if (grades[i][j] < 75) {
                    fail = fail + subj[j] + " ";
                }
            }
            if (!fail.equals("")) {
                System.out.println(names[i] + " failed: " + fail);
                noneFailed = false;
            }
        }
        if (noneFailed) System.out.println("No one failed.");
        System.out.println();
    }
}
