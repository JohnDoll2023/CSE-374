public class RandomizedSelect {
	public static void main(String[] args) {
		int arr [] = {8, 3, 5, 9, 21, 6, 5, -1, 20, 0}; 
		int i = 10;
		System.out.println(randomizedSelect(arr, 0, arr.length - 1, i));
		
	}
	
	public static int randomizedSelect(int arr[], int index, int length, int i) {
		//if index equals the length then we have only one element left to choose
		if(index == length) {
			return arr[index];
		}
		//helper method to find pivot
		int pivot = randomizedPartition(arr, index, length);
		//how many values in the array are less than itself (k), represents how many elements in left portion including q
		int k = pivot - index + 1;
		//checks if our index equals the location where we partitioned
		if(i == k) {
			return arr[pivot];
		//checks if i is less than k, indicating that we want to work with the values less than k in our new randomized select
		} else if (i < k) {
			return randomizedSelect(arr, index, pivot - 1, i);
		} else {
			//shift over i because we need to adjust for not having as many elements k since we split the array
			return randomizedSelect(arr, pivot + 1, length, i - k);
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