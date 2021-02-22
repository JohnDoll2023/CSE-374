import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {8, 3, 5, 9, 21, 6, 5, -1, 20, 0}; 
		mergeSort(arr, 0, arr.length - 1);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void mergeSort(int arr[], int index, int length) {
		if(index < length) {
			int split = ((index + length) / 2);
			mergeSort(arr, index, split);
			mergeSort(arr, split + 1, length);
			merge(arr, index, split, length);
		}
	}
	
	public static void merge(int arr[], int index, int split, int length) {
		//create sizes for new arrays
		int num1 = split - index + 1;
		int num2 = length - split;
		//create left and right array
		int[] left = new int[num1 + 1];
		int[] right = new int[num2 + 1];
		//fill left array with values from specified range from original array
		for(int i = 0; i < num1; i++) {
			left[i] = arr[index + i];
		}
		//fill right array with values from specified range from original array
		for(int i = 0; i < num2; i++) {
			right[i] = arr[split + i];
		}
		//set array values to indicate end of array
		left[num1] = Integer.MAX_VALUE;
		right[num2] = Integer.MAX_VALUE;
		//array index for left and right
		int i = 0;
		int j = 0;
		//combine left and right arrays back together
		for(int k = index; k < length; k++) {
			//if value at left array index is less than value at index of right array, then set array to value of left array, otherwise set array to value of right array
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i += 1;
			} else {
				arr[k] = right[j];
				j += 1;
			}
		}
	}
}