package Activity3;

/*
================================================================================
INPUT-PROCESS-OUTPUT (IPO) SYSTEM CHART SUMMARY
================================================================================
Feature / Option      | Input                  | Process                                      | Output
----------------------+------------------------+----------------------------------------------+----------------------------------
<<<<<<< Updated upstream
0. Null Array Guard   | Choice choice          | Validate original != null for choices 2-10   | Error prompt if array is null
=======
0. Null Array Guard   | Choice choice          | Validate original != null for choices 2-10    | Error prompt if array is null
>>>>>>> Stashed changes
1. Enter Array        | size, N int elements   | Allocate memory; populate original & working | Success confirmation message
2. Display Original   | Choice 2               | Traversal loop across original array         | Print space-separated elements
3. Bubble Sort        | Choice 3               | Clone original; pairwise adjacent swaps      | Print sorted working array
4. Selection Sort     | Choice 4               | Clone original; swap min elements to front   | Print sorted working array
5. Insertion Sort     | Choice 5               | Clone original; shift larger key values right| Print sorted working array
<<<<<<< Updated upstream
6. Search Number      | target int             | Linear Search (original), Binary (manual sort)| Index positions / match status
7. Find Duplicates    | Choice 7               | Traversal with visited[] frequency tracker   | List of duplicates & counts
8. Find Missing       | Choice 8               | Manual sort clone; scan adjacent gaps > 1    | List of missing integers
=======
6. Search Number      | target int             | Linear Search (original), Binary (sorted)    | Index positions / match status
7. Find Duplicates    | Choice 7               | Traversal with visited[] frequency tracker   | List of duplicates & counts
8. Find Missing       | Choice 8               | Sort clone; scan adjacent gap differences > 1| List of missing integers
>>>>>>> Stashed changes
9. Reverse Array      | Choice 9               | Clone original; in-place 2-pointer index swap| Print reversed working array
10. Statistics        | Choice 10              | Calculate min/max/sum/avg/even/odd & median  | Complete statistical report
11. Exit              | Choice 11              | Terminate do-while loop condition            | Goodbye message
================================================================================
*/

<<<<<<< Updated upstream
=======
import java.util.Arrays;
>>>>>>> Stashed changes
import java.util.Scanner;

public class Group5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] original = null;
        int[] working = null;

        int choice = 0;

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

            /*
             * CRASH PROTECTION: Non-integer input validation.
             */
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid menu number (1-11).");
                scanner.next(); 
                continue;
            }

            choice = scanner.nextInt();

            /*
             * IPO - SYSTEM NULL GUARD
<<<<<<< Updated upstream
=======
             * Input  : User menu choice (int)
             * Process: Evaluates if choice is between 2 and 10 while original array is uninitialized.
             * Output : Error message prompting array entry if original == null.
>>>>>>> Stashed changes
             */
            if (choice >= 2 && choice <= 10 && original == null) {
                System.out.println("Please enter an array first.");
                continue;
            }

            switch (choice) {

                case 1:
<<<<<<< Updated upstream
=======
                    /*
                     * IPO - OPTION 1: ENTER ARRAY
                     * Input  : Array size (int), N array elements (int[])
                     * Process: Instantiates original and working arrays of given size;
                     *          populates elements into both arrays simultaneously.
                     * Output : Confirmation message.
                     */
>>>>>>> Stashed changes
                    System.out.print("Array Size: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid size! Enter an integer.");
                        scanner.next();
                        System.out.print("Array Size: ");
                    }
                    int size = scanner.nextInt();

                    original = new int[size];
                    working = new int[size];

                    for (int i = 0; i < size; i++) {
                        System.out.print("Number " + (i + 1) + ": ");
<<<<<<< Updated upstream
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid integer entry!");
                            scanner.next();
                            System.out.print("Number " + (i + 1) + ": ");
                        }
=======
>>>>>>> Stashed changes
                        original[i] = scanner.nextInt();
                        working[i] = original[i];
                    }
                    System.out.println("Array successfully initialized!");
                    break;

                case 2:
<<<<<<< Updated upstream
=======
                    /*
                     * IPO - OPTION 2: DISPLAY ORIGINAL ARRAY
                     * Input  : Menu selection 2
                     * Process: Iterates through the original array using a for-each loop.
                     * Output : Printed list of original array elements.
                     */
>>>>>>> Stashed changes
                    System.out.print("Original Array: ");
                    displayArray(original);
                    break;

                case 3:
<<<<<<< Updated upstream
=======
                    /*
                     * IPO - OPTION 3: BUBBLE SORT
                     * Input  : Menu selection 3
                     * Process: Clones original to working. Uses nested loops to compare adjacent 
                     *          elements (working[j] > working[j+1]) and swap them until sorted.
                     * Output : Display sorted working array.
                     */
>>>>>>> Stashed changes
                    working = original.clone();
                    for (int i = 0; i < working.length - 1; i++) {
                        for (int j = 0; j < working.length - 1 - i; j++) {
                            if (working[j] > working[j + 1]) {
                                int temp = working[j];
                                working[j] = working[j + 1];
                                working[j + 1] = temp;
                            }
                        }
                    }
                    System.out.print("Bubble Sorted Array: ");
                    displayArray(working);
                    break;

                case 4:
<<<<<<< Updated upstream
=======
                    /*
                     * IPO - OPTION 4: SELECTION SORT
                     * Input  : Menu selection 4
                     * Process: Clones original to working. Scans unsorted sub-array for the minimum 
                     *          element index (minIdx) and swaps it to the current outer index.
                     * Output : Display sorted working array.
                     */
>>>>>>> Stashed changes
                    working = original.clone();
                    for (int i = 0; i < working.length - 1; i++) {
                        int minIdx = i;
                        for (int j = i + 1; j < working.length; j++) {
                            if (working[j] < working[minIdx]) {
                                minIdx = j;
                            }
                        }
                        int temp = working[minIdx];
                        working[minIdx] = working[i];
                        working[i] = temp;
                    }
                    System.out.print("Selection Sorted Array: ");
                    displayArray(working);
                    break;

                case 5:
<<<<<<< Updated upstream
=======
                    /*
                     * IPO - OPTION 5: INSERTION SORT
                     * Input  : Menu selection 5
                     * Process: Clones original to working. Iterates from index 1, shifting preceding 
                     *          elements greater than target key rightward before inserting key.
                     * Output : Display sorted working array.
                     */
>>>>>>> Stashed changes
                    working = original.clone();
                    for (int i = 1; i < working.length; i++) {
                        int key = working[i];
                        int j = i - 1;
                        while (j >= 0 && working[j] > key) {
                            working[j + 1] = working[j];
                            j--;
                        }
                        working[j + 1] = key;
                    }
                    System.out.print("Insertion Sorted Array: ");
                    displayArray(working);
                    break;

                case 6:
<<<<<<< Updated upstream
                    System.out.print("Enter target number to search: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid target number!");
                        scanner.next();
                        System.out.print("Enter target number to search: ");
                    }
=======
                    /*
                     * IPO - OPTION 6: SEARCH NUMBER
                     * Input  : Target integer to search
                     * Process: 1. Performs Linear Search sequentially over original array.
                     *          2. Clones and sorts working array; executes Binary Search with 
                     *             low, high, and mid pointers.
                     * Output : Target status and matching index positions for both search types.
                     */
                    System.out.print("Enter target number to search: ");
>>>>>>> Stashed changes
                    int target = scanner.nextInt();

                    // 1. Linear Search
                    int linearIdx = -1;
                    for (int i = 0; i < original.length; i++) {
                        if (original[i] == target) {
                            linearIdx = i;
                            break;
                        }
                    }
                    System.out.println("\n--- Linear Search (Original Array) ---");
                    if (linearIdx != -1) {
                        System.out.println("Found " + target + " at index: " + linearIdx);
                    } else {
                        System.out.println("Number " + target + " not found.");
                    }

                    // 2. Binary Search
                    working = original.clone();
<<<<<<< Updated upstream
                    manualSort(working);
=======
                    Arrays.sort(working);
>>>>>>> Stashed changes

                    int low = 0, high = working.length - 1;
                    int binaryIdx = -1;
                    while (low <= high) {
                        int mid = low + (high - low) / 2;
                        if (working[mid] == target) {
                            binaryIdx = mid;
                            break;
                        }
                        if (working[mid] < target) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                    System.out.println("\n--- Binary Search (Sorted Array) ---");
                    System.out.print("Sorted Array: ");
                    displayArray(working);
                    if (binaryIdx != -1) {
                        System.out.println("Found " + target + " at sorted index: " + binaryIdx);
                    } else {
                        System.out.println("Number " + target + " not found.");
                    }
                    break;

                case 7:
<<<<<<< Updated upstream
=======
                    /*
                     * IPO - OPTION 7: FIND DUPLICATES
                     * Input  : Menu selection 7
                     * Process: Initializes boolean[] visited array. Counts occurrence frequency 
                     *          for unvisited numbers across original array elements.
                     * Output : Formatted list of duplicate numbers and their counts.
                     */
>>>>>>> Stashed changes
                    boolean[] visited = new boolean[original.length];
                    boolean duplicateFound = false;

                    System.out.println("Duplicate Numbers:");
                    for (int i = 0; i < original.length; i++) {
                        if (visited[i]) continue;

                        int count = 1;
                        for (int j = i + 1; j < original.length; j++) {
                            if (original[i] == original[j]) {
                                visited[j] = true;
                                count++;
                            }
                        }

                        if (count > 1) {
                            System.out.println("- " + original[i] + " occurs " + count + " times");
                            duplicateFound = true;
                        }
                    }

                    if (!duplicateFound) {
                        System.out.println("No duplicates found.");
                    }
                    break;

                case 8:
<<<<<<< Updated upstream
                    working = original.clone();
                    manualSort(working);
=======
                    /*
                     * IPO - OPTION 8: FIND MISSING NUMBER
                     * Input  : Menu selection 8
                     * Process: Clones and sorts working array. Scans adjacent elements for index 
                     *          gaps where (working[i+1] - working[i] > 1).
                     * Output : Numerical sequence range and list of missing values.
                     */
                    working = original.clone();
                    Arrays.sort(working);
>>>>>>> Stashed changes

                    boolean missingFound = false;
                    System.out.print("Missing Number(s) in range [" + working[0] + " to " + working[working.length - 1] + "]: ");
                    
                    for (int i = 0; i < working.length - 1; i++) {
                        int diff = working[i + 1] - working[i];
                        if (diff > 1) {
                            for (int m = working[i] + 1; m < working[i + 1]; m++) {
                                System.out.print(m + " ");
                                missingFound = true;
                            }
                        }
                    }

                    if (!missingFound) {
                        System.out.print("None (Sequence is continuous)");
                    }
                    System.out.println();
                    break;

                case 9:
<<<<<<< Updated upstream
=======
                    /*
                     * IPO - OPTION 9: REVERSE ARRAY
                     * Input  : Menu selection 9
                     * Process: Clones original into working. Executes an in-place two-pointer swap 
                     *          loop up to index (working.length / 2) without extra arrays.
                     * Output : Display reversed working array.
                     */
>>>>>>> Stashed changes
                    working = original.clone();
                    for (int i = 0; i < working.length / 2; i++) {
                        int temp = working[i];
                        working[i] = working[working.length - 1 - i];
                        working[working.length - 1 - i] = temp;
                    }
                    System.out.print("Reversed Array: ");
                    displayArray(working);
                    break;

                case 10:
<<<<<<< Updated upstream
=======
                    /*
                     * IPO - OPTION 10: STATISTICS
                     * Input  : Menu selection 10
                     * Process: 1. Single-pass loop on original to compute min, max, sum, even/odd counts.
                     *          2. Computes average = sum / length.
                     *          3. Sorts clone to calculate median based on even/odd length rules.
                     * Output : Summary table displaying min, max, sum, average, median, even/odd counts.
                     */
>>>>>>> Stashed changes
                    int min = original[0];
                    int max = original[0];
                    int sum = 0;
                    int evenCount = 0;
                    int oddCount = 0;

                    for (int num : original) {
                        if (num < min) min = num;
                        if (num > max) max = num;
                        sum += num;
                        if (num % 2 == 0) evenCount++;
                        else oddCount++;
                    }

                    double average = (double) sum / original.length;

<<<<<<< Updated upstream
                    working = original.clone();
                    manualSort(working);
=======
                    // Median Calculation
                    working = original.clone();
                    Arrays.sort(working);
>>>>>>> Stashed changes
                    double median;
                    int n = working.length;
                    if (n % 2 == 0) {
                        median = (working[n / 2 - 1] + working[n / 2]) / 2.0;
                    } else {
                        median = working[n / 2];
                    }

                    System.out.println("\n--- ARRAY STATISTICS ---");
                    System.out.println("Minimum    : " + min);
                    System.out.println("Maximum    : " + max);
                    System.out.println("Sum        : " + sum);
                    System.out.printf("Average    : %.2f\n", average);
                    System.out.println("Median     : " + median);
                    System.out.println("Even Count : " + evenCount);
                    System.out.println("Odd Count  : " + oddCount);
                    break;

                case 11:
<<<<<<< Updated upstream
=======
                    /*
                     * IPO - OPTION 11: EXIT
                     * Input  : Menu selection 11
                     * Process: Evaluates do-while condition (choice != 11) to false.
                     * Output : Termination message.
                     */
>>>>>>> Stashed changes
                    System.out.println("Exiting Array Sorting Laboratory. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose from 1 to 11.");
            }

        } while (choice != 11);

        scanner.close();
    }

<<<<<<< Updated upstream
    private static void manualSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

=======
    /*
     * IPO - HELPER METHOD: displayArray
     * Input  : int[] arr
     * Process: Iterates and formats array elements.
     * Output : Prints space-separated numbers to standard output.
     */
>>>>>>> Stashed changes
    private static void displayArray(int[] arr) {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}