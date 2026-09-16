package Sample;

public class SelectionSorting {
	 public static void main(String[] args) {

	        int[] numbers = {64, 25, 12, 22, 11};

	        for (int i = 0; i < numbers.length - 1; i++) {

	            int minimumIndex = i;

	            for (int j = i + 1; j < numbers.length; j++) {

	                if (numbers[j] < numbers[minimumIndex]) {
	                    minimumIndex = j;
	                }
	            }

	            int temp = numbers[minimumIndex];
	            numbers[minimumIndex] = numbers[i];
	            numbers[i] = temp;
	        }

	        System.out.println("Sorted Array:");

	        for (int number : numbers) {
	            System.out.print(number + " ");
	        }
	    }
}
