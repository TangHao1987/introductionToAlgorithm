package introductiontoalgo.gettingstart.insertionsort;

/**
 * the Decreasing order simply apply the 'less than' rather than 'greater than' when comparing the key and output[innerIterator]  
 * This example will still be using the input of Exercise 2.1_1
 * 
 * @author Tang Hao
 */
public class Exercises_2_1_2 {
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
				while (innerIterator >= 0 && output[innerIterator] < key) {
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
