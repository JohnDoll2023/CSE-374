public class SelectionSort {
	public static void main(String [] args) {
		int arr [] = {8, 3, 5, 9, 21, 6, 5, -1, 20, 0}; 
		selectionSort(arr);
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void selectionSort(int arr[]) {
		//begins check for every value in array
		for(int i = 0; i < arr.length; i++) {
			//sets minimum value index to i 
			int minIndex = i;
			//goes through every value from i to end of array find smallest value remaining
			for(int j = i; j < arr.length; j++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			//checks if min value index is current i index
			if(minIndex != i) {
				//swap min value and current index in array
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}
}