package FinalsActivity1;

import java.util.Arrays;

public class GroupSandrinoEgan {
	
    public static void main(String[] args) {
        // Ito yung original array na gagamitin natin based sa expected output
        int[] original = {45, 12, 89, 33, 67, 21, 90, 54};

        // 1. Print natin yung original array gamit yung Arrays.toString() para maganda format
        System.out.println("Original: " + Arrays.toString(original));

        // 2. Gawa tayo ng exact copy para hindi ma-modify yung original array pag nag-sort tayo
        int[] sortedCopy = Arrays.copyOf(original, original.length);

        // 3. Sort natin yung ginawa nating copy in ascending order (mula lowest to highest)
        Arrays.sort(sortedCopy);

        // 4. Display na natin yung naka-sort na array, lopet
        System.out.println("Ascending: " + Arrays.toString(sortedCopy));

        // 5. Para ma-display ng descending, i-loop natin yung sorted array pabalik (from last element hanggang first)
        System.out.print("Descending: ");
        for (int i = sortedCopy.length - 1; i >= 0; i--) {
            System.out.print(sortedCopy[i]); 
            if (i > 0){
            	System.out.print(" ");// Naglagay lang space sa gitna ng numbers para di masakit sa mata wahaha
            }
        }
        System.out.println(); // Mag-print lng ng empty line para pumunta sa next line after ng loop

        // 6. I-display yung lowest at highest values. (Badap si Egan)
        // Dahil na-sort na natin kanina, sure tayo na nasa index 0 yung lowest at nasa pinakadulo yung highest.
        System.out.println("Lowest: " + sortedCopy[0]);
        System.out.println("Highest: " + sortedCopy[sortedCopy.length - 1]);

        // 7. Hanapin natin saang index nakapwesto yung 67 gamit Arrays.binarySearch()
        // Reminder: Dapat naka-sort palagi yung array bago gumamit ng binary search!
        int target = 67;
        int index = Arrays.binarySearch(sortedCopy, target);
        System.out.println(target + " found at sorted index " + index);

        // 8. I-check natin kung equal pa rin ba yung original array at yung na-sort nating copy
        boolean areEqual = Arrays.equals(original, sortedCopy);
        System.out.println("Arrays are equal: " + areEqual);
    }
}