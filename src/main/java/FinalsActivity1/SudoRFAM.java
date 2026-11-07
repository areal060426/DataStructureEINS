package FinalsActivity1;

import java.util.Arrays;

public class SudoRFAM {
	public static void main(String[] args) {
		//CANALDA, RAMOS, TINITIGAN, DARIO, CAMERING, MARCELLANA, SANTOS, LICUDINE
		
		// TODO Auto-generated method stub
        // Initialize the original array with the values from the expected output
        int[] original = {45, 12, 89, 33, 67, 21, 90, 54};

        // 1. Display the original array using Arrays.toString()
        System.out.println("Original: " + Arrays.toString(original));

        // 2. Create an independent copy using Arrays.copyOf()
        int[] sortedCopy = Arrays.copyOf(original, original.length);
        System.out.println("SortedCopy: " + Arrays.toString(sortedCopy));
        // 3. Sort the copy in ascending order
        Arrays.sort(sortedCopy);

        // 4. Display the sorted copy
        System.out.println("Ascending: " + Arrays.toString(sortedCopy));
        // 5. Display its values in descending order using a loop
        System.out.print("Descending: ");
        for (int i = sortedCopy.length - 1; i >= 0; i--) {
        	System.out.print(sortedCopy[i]);
        	if(i >= 0) {
        		System.out.print(" ");
        	}
        }
        System.out.println(); // Move to the next line

        // 6. Display the lowest and highest values
        System.out.println("Lowest: " + sortedCopy[0]);
        System.out.println("Highest: " + sortedCopy[sortedCopy.length - 1]);

        // 7. Search for 67 using Arrays.binarySearch()
        int index = Arrays.binarySearch(sortedCopy, 67);
        System.out.println("67 found at sorted index " + index);

        // 8. Print whether the original and sorted arrays are equal
        boolean areEqual = Arrays.equals(original, sortedCopy);
        System.out.println("Arrays are equal: " + areEqual);
        
        
//			Original: [45, 12, 89, 33, 67, 21, 90, 54]
//			Ascending: [12, 21, 33, 45, 54, 67, 89, 90]
//			Descending: 90 89 67 54 45 33 21 12
//			Lowest: 12
//			Highest: 90
//			67 found at sorted index 5
//			Arrays are equal: false
	}	

}
