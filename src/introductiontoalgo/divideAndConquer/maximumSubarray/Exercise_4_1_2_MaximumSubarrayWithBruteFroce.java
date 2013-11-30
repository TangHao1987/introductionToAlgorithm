package introductiontoalgo.divideAndConquer.maximumSubarray;

import introductiontoalgo.common.CommonLogics;

/**
 * 
 * This the the most tranditional brute force maximum subarray implementation
 * BIG-O of this logic is n^2
 * 
 * @author Tang Hao
 * 
 */
public class Exercise_4_1_2_MaximumSubarrayWithBruteFroce extends CommonLogics {
	public static void main(String[] args) {
		int[] inputArray = { -12, -42, 24, 23, 43, 64, 3, 64, 75, -24 };
		printIntArray(inputArray, true);

		String outputHolder = bruteForceMaximumSubArray(inputArray);

		System.out.println(outputHolder);
	}

	public static String bruteForceMaximumSubArray(int[] inputArray) {
		int arraySize = inputArray.length * (inputArray.length + 1) / 2;
		int[] lengthArray = new int[arraySize];
		int lengthArrayIterator = 0;
		for (int i = 0; i < inputArray.length; i++) {
			int sum = 0;
			for (int j = i; j < inputArray.length; j++) {
				sum += inputArray[j];
				lengthArray[lengthArrayIterator] = sum;
				lengthArrayIterator++;
			}
		}

		int maxSum = -1000000;
		for (int i = 0; i < lengthArray.length; i++) {
			if (lengthArray[i] > maxSum) {
				maxSum = lengthArray[i];
			}
		}

		return new Integer(maxSum).toString();
	}
}
