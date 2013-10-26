package introductiontoalgo.gettingstart.designingalgorithms;

/**
 * This case demostrate Insertion Sort with linear search for the inner loop of insertion sort
 * 
 * regarding the question that if possible to use a binary search instead to imporve the overall worst-case running time of insertion sort to
 * big-theta(nlgn)? 
 * My answer is no, that's impossible. reason is binary search only can help to find the value where to insert the key in inner loop, 
 * but after that we still need to shift all the values which is large than key one by one to right in inner loop, 
 * that operation only can be done by a for loop. and it will give big-theta(n^2) as usual.
 * 
 * @author Tang Hao
 *
 */
public class Exercises_2_3_6_InsertionSortWithLinearSearch {
	public static void main(String[] args) {
		// define your input in this array
		int[] input = { 1, 10, 100, 56, 27, 42, 6 };
		// output array
		int[] output = input;

		System.out.print("input int String is: [ ");
		for (int i : input) {
			System.out.print(i + " ");
		}
		System.out.println("]");

		// algorithm start
		if (input.length > 1) {
			for (int iterator = 1; iterator < input.length; iterator++) {
				int key = output[iterator];
				SortBylinearSearch(output, 0, iterator, key);
			}
		}

		System.out.print("output int String is: [ ");
		for (int i : output) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}
	
	private static void SortBylinearSearch(int [] array, int startPoint, int endPoint, int key){
		for(int index = endPoint - 1; index >= startPoint; index--){
			if(array[index] < key){ 
				array[index + 1] = key;
				break;
			}else{
				array[index + 1] = array[index];
			}
		}
	}
	
}
