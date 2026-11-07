/* Member:
   Resurreccion, Zyra Mae
   Cuizon, Darlene Kharell
   Espijon, Arjay Lexiel G.
   Ballero, Huearold Cane
*/

package FinalsActivity1;

import java.util.Arrays;

public class charityMatch {

    public static void main(String[] args) {
        int[] original = {45, 12, 89, 33, 67, 21, 90, 54};

        // 1.	Display the original array using Arrays.toString().
        System.out.println("Original: " + Arrays.toString(original));

        // 2. Create an independent copy using Arrays.copyOf().
        int[] sorted = Arrays.copyOf(original, original.length);

        // 3. Sort the copy in ascending order.
        Arrays.sort(sorted);

        // 4. Display the sorted copy
        System.out.println("Ascending: " + Arrays.toString(sorted));

        // 5. Display its values in descending order using a loop.
        System.out.print("Descending: ");
        for (int i = sorted.length - 1; i >= 0; i--) {
            System.out.print(sorted[i] + " ");
        }
        System.out.println();

        // 6. Display the lowest and highest values.
        System.out.println("Lowest: " + sorted[0]);
        System.out.println("Highest: " + sorted[sorted.length - 1]);

        // 7. Search for 67 using Arrays.binarySearch().
        int index = Arrays.binarySearch(sorted, 67);
        System.out.println("67 found at sorted index " + index);

        // 8. Print whether the original and sorted arrays are equal.
        System.out.println("Arrays are equal: " + Arrays.equals(original, sorted));
    }
}