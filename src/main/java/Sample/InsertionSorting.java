package Sample;

public class InsertionSorting {
	 public static void main(String[] args) {

	        int[] numbers = {12, 11, 13, 5, 6};

	        for (int i = 1; i < numbers.length; i++) {

	            int key = numbers[i];
	            int j = i - 1;

	            while (j >= 0 && numbers[j] > key) {

	                numbers[j + 1] = numbers[j];
	                j--;
	            }

	            numbers[j + 1] = key;
	        }

	        System.out.println("Sorted Array:");

	        for (int number : numbers) {
	            System.out.print(number + " ");
	        }
	    }
}
