package FinalsActivity1;

import java.util.Arrays;

public class BALAGBAGERS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Create a Java program named GroupName using:
//			Your program must:
//			1.	Display the original array using Arrays.toString().
//			2.	Create an independent copy using Arrays.copyOf().
//			3.	Sort the copy in ascending order.
//			4.	Display the sorted copy.
//			5.	Display its values in descending order using a loop.
//			6.	Display the lowest and highest values.
//			7.	Search for 67 using Arrays.binarySearch().
//			8.	Print whether the original and sorted arrays are equal.
//			Expected output:
//			Original: [45, 12, 89, 33, 67, 21, 90, 54]
//			Ascending: [12, 21, 33, 45, 54, 67, 89, 90]
//			Descending: 90 89 67 54 45 33 21 12
//			Lowest: 12
//			Highest: 90
//			67 found at sorted index 5
//			Arrays are equal: false
		
		/*
		 * Group Name: BALAGBAGERS
		 *  1. Ocampo, Ernie 
		 *  2. Paja, Philip
		 *  3. Viesca, Zairah Mae
		 *  4. Villanueva, John Russell
		 *  5. Hamdain, Redwann 
		 *  6. Yabut, Renyer
		 *  7. Utrera, Sean John Daniel
		 * */
		

		int[] original = {45, 12, 89, 33, 67, 21, 90, 54};

		// 1. Display the original array using Arrays.toString()
		System.out.println("Original: " + Arrays.toString(original));

		// 2. Create an independent copy using Arrays.copyOf()
		int[] sorted = Arrays.copyOf(original, original.length);

		// 3. Sort the copy in ascending order
		Arrays.sort(sorted);

		// 4. Display the sorted copy
		System.out.println("Ascending: " + Arrays.toString(sorted));

		// 5. Display its values in descending order using a loop
		System.out.print("Descending:");
		for (int i = sorted.length - 1; i >= 0; i--) {
			System.out.print(" " + sorted[i]);
		}
		System.out.println();

		// 6. Display the lowest and highest values
		System.out.println("Lowest: " + sorted[0]);
		System.out.println("Highest: " + sorted[sorted.length - 1]);

		// 7. Search for 67 using Arrays.binarySearch()
		int index = Arrays.binarySearch(sorted, 67);
		System.out.println("67 found at sorted index " + index);

		// 8. Print whether the original and sorted arrays are equal
		System.out.println("Arrays are equal: " + Arrays.equals(original, sorted));

	}
}