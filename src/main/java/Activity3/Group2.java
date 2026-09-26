package Activity3;

	import java.util.Scanner;

	public class Group2 {
		/*
		 * Group Members:
		 * Ocampo, Ernie 
		 * Paja, Philip
		 * Viesca, Zairah Mae
		 * Villanueva, John Russell
		 * Hamdain, Redwann 
		 * Yabut, Renyer
		 * Utrera, Sean John Daniel
		 * */
		/*
		 * Group 2 — Number Analyzer and Sorting Laboratory

		The user enters 10–20 integers.

		The program must:

		Display original numbers.
		Sort ascending using Bubble Sort.
		Sort descending using Selection Sort.
		Find largest and smallest.
		Find second largest and second smallest.
		Count even and odd numbers.
		Count duplicate values.
		Remove duplicates when displaying unique numbers.
		Search for a value entered by the user.
		The program must reject an array size lower than 10 or higher than 20.
		*/
		
	    public static void main(String[] args) {

	    	Scanner input = new Scanner(System.in);

	    	int size;

	    	do {
	    	    System.out.print("Enter number of integers (10-20): ");

	    	    if (input.hasNextInt()) {
	    	        size = input.nextInt();

	    	        if (size < 10 || size > 20) {
	    	            System.out.println("Invalid size. Please enter 10-20.");
	    	        }

	    	    } else {
	    	        System.out.println("Invalid input. Please enter a number from 10-20.");
	    	        input.next(); 
	    	        size = 0;
	    	    }

	    	} while (size < 10 || size > 20);

	    	int[] numbers = new int[size];

	    	// Enter numbers
	    	for (int i = 0; i < size; i++) {

	    	    System.out.print("Enter number " + (i + 1) + ": ");

	    	    if (input.hasNextInt()) {
	    	        numbers[i] = input.nextInt();
	    	    } else {
	    	        System.out.println("Invalid input. Please enter a number.");
	    	        input.next();
	    	        i--; 
	    	    }
	    	}

	        // Display original numbers
	        System.out.println("\nOriginal Numbers:");
	        for (int i = 0; i < size; i++) {
	            System.out.print(numbers[i] + " ");
	        }

	        // Bubble Sort - Ascending
	        int[] ascending = new int[size];

	        for (int i = 0; i < size; i++) {
	            ascending[i] = numbers[i];
	        }

	        for (int i = 0; i < size - 1; i++) {
	            for (int j = 0; j < size - 1 - i; j++) {

	                if (ascending[j] > ascending[j + 1]) {

	                    int temp = ascending[j];
	                    ascending[j] = ascending[j + 1];
	                    ascending[j + 1] = temp;
	                }
	            }
	        }

	        System.out.println("\n\nAscending Order (Bubble Sort):");
	        for (int i = 0; i < size; i++) {
	            System.out.print(ascending[i] + " ");
	        }

	        // Selection Sort - Descending
	        int[] descending = new int[size];

	        for (int i = 0; i < size; i++) {
	            descending[i] = numbers[i];
	        }

	        for (int i = 0; i < size - 1; i++) {

	            int largest = i;

	            for (int j = i + 1; j < size; j++) {

	                if (descending[j] > descending[largest]) {
	                    largest = j;
	                }
	            }

	            int temp = descending[i];
	            descending[i] = descending[largest];
	            descending[largest] = temp;
	        }

	        System.out.println("\n\nDescending Order (Selection Sort):");
	        for (int i = 0; i < size; i++) {
	            System.out.print(descending[i] + " ");
	        }

	        // Largest and Smallest
	        int largest = numbers[0];
	        int smallest = numbers[0];

	        for (int i = 1; i < size; i++) {

	            if (numbers[i] > largest) {
	                largest = numbers[i];
	            }

	            if (numbers[i] < smallest) {
	                smallest = numbers[i];
	            }
	        }

	        System.out.println("\n\nLargest: " + largest);
	        System.out.println("Smallest: " + smallest);

	        // Second Largest
	        int secondLargest = smallest;

	        for (int i = 0; i < size; i++) {

	            if (numbers[i] > secondLargest && numbers[i] < largest) {
	                secondLargest = numbers[i];
	            }
	        }

	        // Second Smallest
	        int secondSmallest = largest;

	        for (int i = 0; i < size; i++) {

	            if (numbers[i] < secondSmallest && numbers[i] > smallest) {
	                secondSmallest = numbers[i];
	            }
	        }

	        System.out.println("Second Largest: " + secondLargest);
	        System.out.println("Second Smallest: " + secondSmallest);

	        // Count even and odd
	        int even = 0;
	        int odd = 0;

	        for (int i = 0; i < size; i++) {

	            if (numbers[i] % 2 == 0) {
	                even++;
	            } else {
	                odd++;
	            }
	        }

	        System.out.println("\nEven Numbers: " + even);
	        System.out.println("Odd Numbers: " + odd);

	        // Count duplicate values
	        int duplicate = 0;

	        for (int i = 0; i < size; i++) {

	            for (int j = i + 1; j < size; j++) {

	                if (numbers[i] == numbers[j]) {
	                    duplicate++;
	                    break;
	                }
	            }
	        }

	        System.out.println("Duplicate Values: " + duplicate);

	        // Display unique numbers
	        System.out.println("\nUnique Numbers:");

	        for (int i = 0; i < size; i++) {

	            boolean alreadyDisplayed = false;

	            for (int j = 0; j < i; j++) {

	                if (numbers[i] == numbers[j]) {
	                    alreadyDisplayed = true;
	                }
	            }

	            if (alreadyDisplayed == false) {
	                System.out.print(numbers[i] + " ");
	            }
	        }

	        boolean found = false;

	        while (found == false) {

	            System.out.print("\n\nEnter a number to search: ");

	            if (input.hasNextInt()) {
	                int search = input.nextInt();
	                for (int i = 0; i < size; i++) {
	                    if (numbers[i] == search) {
	                        found = true;
	                        break;
	                    }
	                }

	                if (found == true) {
	                    System.out.println("Value found!");
	                } else {
	                    System.out.println("Value not found. Please try again.");
	                }
	                
	            } else {

	                System.out.println("Invalid input. Please enter a number.");
	                input.next(); 

	            }
	        }

	        input.close();

	    }
	}
