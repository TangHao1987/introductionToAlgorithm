package introductiontoalgo.gettingstart.designingalgorithms;

import introductiontoalgo.common.CommonLogics;

/**
 * This exercise contains algorithm of binary search for a sorted array Input:
 * an sorted array A, an arbitrary number v Output any index of array i makes
 * A[i] = v or i = NIL if no any A[i] = v is exist
 * 
 * As primitives is not a reference when passed in another method in java, so a new object type must be created to hold
 * the output data. 
 * 
 * @author Tang Hao
 */
public class Exercises_2_3_5_BinarySearch extends CommonLogics {
	static class AlgoOutput {
		private boolean assinged;
		private int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public boolean isAssinged() {
			return assinged;
		}

		public void setAssinged(boolean assinged) {
			this.assinged = assinged;
		}
	}

	public static void main(String[] args) {
		int[] inputArray = { 1, 4, 5, 8, 9, 12, 14, 16, 28, 30, 34, 36, 50, 56,
				67, 75, 87, 99 };
		Exercises_2_3_5_BinarySearch.AlgoOutput output = new Exercises_2_3_5_BinarySearch.AlgoOutput();
		int v = 99;
		printIntArray(inputArray, true);

		binarySearch(inputArray, 0, inputArray.length - 1, v, output);

		if (!output.isAssinged()) {
			System.out
					.println("Not exist such a number i, which could make A[i] = "
							+ v);
		} else {
			System.out.println("exist number i = " + output.getValue()
					+ ", which could make A[" + output.getValue() + "] = " + v);
		}
	}

	private static void binarySearch(int[] array, int startPoint, int endPoint,
			int input, Exercises_2_3_5_BinarySearch.AlgoOutput output) {
		// use "<=" is because that -> "=" is used to handle the situation that array length is 1
		if (startPoint <= endPoint && !output.isAssinged()) {
			int midPoint = (startPoint + endPoint) / 2;
			if (array[midPoint] > input) {
				binarySearch(array, startPoint, midPoint, input, output);
			} else if (array[midPoint] == input) {
				output.setValue(midPoint);
				output.setAssinged(true);
			} else {
				binarySearch(array, midPoint + 1, endPoint, input, output);
			}
		}
	}
}
