package introductiontoalgo.gettingstart.insertionsort;

/**
 * This model is exactly same as Original Model but just specified the input to
 * A = [31,41,59,26,41,58]
 * 
 * @author Tang Hao
 */
public class Exercises_2_1_1_InsertionSortWithIncreasingOrder {
	public static void main(String[] args) {
		// define your input in this array
		int[] input = { 31, 41, 59, 26, 41, 58 };
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
				int innerIterator = iterator - 1;
				while (innerIterator >= 0 && output[innerIterator] > key) {
					output[innerIterator + 1] = output[innerIterator];
					innerIterator--;
				}
				output[innerIterator + 1] = key;
			}
		}

		System.out.print("output int String is: [ ");
		for (int i : output) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}
}
