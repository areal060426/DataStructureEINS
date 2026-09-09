// MergeSort
package Sample;

public class AdvanceSorting {
	  public static void mergeSort(int[] array, int left, int right) {

	        if (left < right) {

	            int middle = (left + right) / 2;

	            mergeSort(array, left, middle);
	            mergeSort(array, middle + 1, right);

	            merge(array, left, middle, right);
	        }
	    }

	    public static void merge(int[] array, int left, int middle, int right) {

	        int n1 = middle - left + 1;
	        int n2 = right - middle;

	        int[] leftArray = new int[n1];
	        int[] rightArray = new int[n2];

	        for (int i = 0; i < n1; i++) {
	            leftArray[i] = array[left + i];
	        }

	        for (int j = 0; j < n2; j++) {
	            rightArray[j] = array[middle + 1 + j];
	        }

	        int i = 0;
	        int j = 0;
	        int k = left;

	        while (i < n1 && j < n2) {

	            if (leftArray[i] <= rightArray[j]) {

	                array[k] = leftArray[i];
	                i++;

	            } else {

	                array[k] = rightArray[j];
	                j++;
	            }

	            k++;
	        }

	        while (i < n1) {

	            array[k] = leftArray[i];

	            i++;
	            k++;
	        }

	        while (j < n2) {

	            array[k] = rightArray[j];

	            j++;
	            k++;
	        }
	    }

	    public static void main(String[] args) {

	        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

	        mergeSort(numbers, 0, numbers.length - 1);

	        System.out.println("Sorted Array:");

	        for (int number : numbers) {
	            System.out.print(number + " ");
	        }
	    }
}
