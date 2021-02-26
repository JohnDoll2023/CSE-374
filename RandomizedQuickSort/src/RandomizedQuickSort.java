public class RandomizedQuickSort {
	
	public static void main(String[] args) {
		int arr [] = {8, 3, 5, 9, 21, 6, 5, -1, 20, 0}; 
		quickSort(arr, 0, arr.length - 1);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void quickSort(int arr[], int index, int length) {
		//check if our index has reached the end of the array
		if(index < length) {
			//partition the array
			int split = randomizedPartition(arr, index, length);
			quickSort(arr, index, split - 1);
			quickSort(arr, split + 1, length);
		}
	}
	
	public static int randomizedPartition(int arr[], int index, int length) {
		// gets random location to be pivot
		int randomLocation = (int)(Math.random()*(length - index + 1) + index);
		// swaps this with the last value
		int temp = arr[length];
		arr[length] = arr[randomLocation];
		arr[randomLocation] = temp;
		// partitions 
		return partition(arr, index, length);
	}
	
	public static int partition(int arr[], int index, int length) {	
		//set a our comparison value that all numbers to the left will be less than
		int key = arr[length];
		//location of last value that is lower than our key
		int i = index - 1;
		//loop that iterates through given section of array sending lower values to the left of the key and higher to the right
		for(int j = index; j < length; j++) {
			//checks if value is less than the key
			if(arr[j] <= key) {
				//increments i since the location of our lowest value has moved up one
				i += 1;
				//swap num at i with num at j
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		//swap num at i+1 with our key value since we know the value at i is our last value that is less than our key
		int temp = arr[i + 1];
		arr[i + 1] = arr[length];
		arr[length] = temp;
		return i + 1;
	}
}