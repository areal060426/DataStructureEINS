package Sample;

public class HeapSort {
	 public static void sort(int[] array) {

	        int n = array.length;

	        // Build max heap
	        for (int i = n / 2 - 1; i >= 0; i--) {
	            heapify(array, n, i);
	        }

	        // Extract elements
	        for (int i = n - 1; i > 0; i--) {

	            int temp = array[0];
	            array[0] = array[i];
	            array[i] = temp;

	            heapify(array, i, 0);
	        }
	    }

	    public static void heapify(int[] array, int n, int i) {

	        int largest = i;

	        int left = 2 * i + 1;
	        int right = 2 * i + 2;

	        if (left < n && array[left] > array[largest]) {
	            largest = left;
	        }

	        if (right < n && array[right] > array[largest]) {
	            largest = right;
	        }

	        if (largest != i) {

	            int temp = array[i];
	            array[i] = array[largest];
	            array[largest] = temp;

	            heapify(array, n, largest);
	        }
	    }

	    public static void main(String[] args) {

	        int[] numbers = {12, 11, 13, 5, 6, 7};

	        sort(numbers);

	        System.out.println("Sorted Array:");

	        for (int number : numbers) {
	            System.out.print(number + " ");
	        }
	    }
}
