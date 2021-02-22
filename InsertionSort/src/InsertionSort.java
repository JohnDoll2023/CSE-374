public class InsertionSort {

	public static void main(String[] args) {
		int arr [] = {8, 3, 5, 9, 21, 6, 5, -1, 20, 0}; 
		insertionSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void insertionSort(int arr[]) {
		//create loop to check every point in the array
		for(int i = 1; i < arr.length; i++) {
			//set key to current location in array
			int key = arr[i];
			//set iterator to one less than current value
			int j = i - 1;
			//loop through all values to the left of key while already sorted values are greater than the key
			while(j >= 0 && arr[j] > key) {
				//swap key and value to left of key
				arr[j + 1] = arr[j];
				j -= 1;
				arr[j + 1] = key;
			}
		}
	}
}