package introductiontoalgo.gettingstart.insertionsort;

/**
 * This algorithm case is the simplest linear search case using forward linear
 * search loop invariant is A[0 ... i-1] when A[i] == v is exist and it's whole
 * array when A[i] == v is not exist initial condition is 0 which is first
 * iteration so always true for the maintenance for j = 0..i-1 will never appear
 * A[j] = v, so it's also true last condition is the A[i-1], which next
 * iteration will give the correct answer.
 * 
 * @author Tang Hao
 * 
 */
public class Exercises_2_1_3_LinearSearch {

	public static void main(String[] args) {
		int[] inputArray = { 10, 67, 43, 25, 78, 85 };
		// 43 is for the case input key in array and 99 is for the case input
		// key not in array
		int[] inputKeyArray = { 43, 99 };
		int outputIndex = -1;

		for (int key : inputKeyArray) {

			outputIndex = -1;
			for (int index = 0; index < inputArray.length; index++) {
				if (key == inputArray[index]) {
					outputIndex = index;
					break;
				}
			}

			if (outputIndex != -1)
				System.out
						.println("input key "
								+ key
								+ " is included in inputArray, and the corresponding value's index is "
								+ outputIndex);
			else
				System.out
						.println("There are no corresponding value to match the given key "
								+ key);

		}
	}

}
