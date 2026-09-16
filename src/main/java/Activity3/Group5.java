package Activity3;
/*
 * Group 5 — Advanced Array Sorting and Search System

This group creates an interactive Sorting Laboratory.

The user enters numbers and can repeatedly perform operations.

=================================
ARRAY SORTING LABORATORY
=================================
1. Enter Array
2. Display Original Array
3. Bubble Sort
4. Selection Sort
5. Insertion Sort
6. Search Number
7. Find Duplicate Numbers
8. Find Missing Number
9. Reverse Array
10. Display Statistics
11. Exit
=================================

They must preserve the original array.

int[] original;
int[] working;

*/
import java.util.Scanner;

public class Group5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] original = null;
        int[] working = null;

        int choice;

        do {

            System.out.println("\n===============================");
            System.out.println("ARRAY SORTING LABORATORY");
            System.out.println("===============================");
            System.out.println("1. Enter Array");
            System.out.println("2. Display Original Array");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Selection Sort");
            System.out.println("5. Insertion Sort");
            System.out.println("6. Search Number");
            System.out.println("7. Find Duplicates");
            System.out.println("8. Find Missing Number");
            System.out.println("9. Reverse Array");
            System.out.println("10. Statistics");
            System.out.println("11. Exit");

            System.out.print("\nChoice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Array Size: ");
                    int size = scanner.nextInt();

                    original = new int[size];
                    working = new int[size];

                    for (int i = 0; i < size; i++) {

                        System.out.print(
                                "Number " +
                                (i + 1) +
                                ": "
                        );

                        original[i] =
                                scanner.nextInt();

                        working[i] =
                                original[i];

                    }

                    break;

                case 2:

                    if (original == null) {

                        System.out.println(
                                "Please enter an array first."
                        );

                    } else {

                        for (int number : original) {
                            System.out.print(
                                    number + " "
                            );
                        }

                    }

                    break;

                case 3:

                    // CREATE BUBBLE SORT

                    break;

                case 4:

                    // CREATE SELECTION SORT

                    break;

                case 5:

                    // CREATE INSERTION SORT

                    break;

                case 6:

                    // LINEAR SEARCH FIRST
                    // THEN BINARY SEARCH

                    break;

                case 7:

                    // FIND ALL DUPLICATES

                    break;

                case 8:

                    // FIND MISSING NUMBER
                    //
                    // Example:
                    // 1 2 3 5 6
                    //
                    // Missing = 4

                    break;

                case 9:

                    // REVERSE ARRAY WITHOUT
                    // CREATING ANOTHER ARRAY

                    break;

                case 10:

                    // DISPLAY:
                    // MINIMUM
                    // MAXIMUM
                    // SUM
                    // AVERAGE
                    // MEDIAN
                    // EVEN COUNT
                    // ODD COUNT

                    break;

            }

        } while (choice != 11);

        scanner.close();
    }
}