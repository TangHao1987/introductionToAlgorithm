package introductiontoalgo.gettingstart.insertionsort;

/**
 * This case demostrate the basic model of Insertion Sort
 * please refer to the Psesudo code on page 18 of book for more reference
 * @author Tang Hao
 *
 */
public class OriginalModel {
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
				int innerIterator = iterator - 1;
				while (innerIterator >= 0 && output[innerIterator] > key) {
					output[innerIterator + 1] = output[innerIterator];
					innerIterator--;
				}
				output[innerIterator+1] = key;
			}
		}

		System.out.print("output int String is: [ ");
		for (int i : output) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}
}
