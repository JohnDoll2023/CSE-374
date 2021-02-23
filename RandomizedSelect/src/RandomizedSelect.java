public class RandomizedSelect {
	public static void main(String[] args) {
		int arr [] = {8, 3, 5, 9, 21, 6, 5, -1, 20, 0}; 
		int i = 2;
		System.out.println(randomizedSelect(arr, 0, arr.length - 1, i));
		
	}
	
	public static int randomizedSelect(int arr[], int index, int length, int i) {
		//if index equals the length then we have only one element left to choose
		if(index == length) {
			return arr[index];
		}
		//helper method
		int q = randomizedPartition(arr, index, length);
		//creates point to see if we have our index
		int k = q - index + 1;
		//checks if our index equals the location where we partioned
		if(i == k) {
			return arr[q];
		//checks if i is less than k, indicating that we want to work with the values less than k in our new randomized select
		} else if (i < k) {
			return randomizedSelect(arr, index, q - 1, i);
		} else {
			return randomizedSelect(arr, q + 1, length, i - k);
		}
	}
	
	public static int randomizedPartition(int arr[], int index, int length) {
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