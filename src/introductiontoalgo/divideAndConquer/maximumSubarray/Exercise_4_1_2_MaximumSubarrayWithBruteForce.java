package introductiontoalgo.divideAndConquer.maximumSubarray;

import introductiontoalgo.common.CommonLogics;
import introductiontoalgo.common.MaxSubarrayOutputHolder;

/**
 * 
 * Very tranditional way to solve the Maximum Subarray problem.
 * to find the maximum subarray by iterating through all the elements by two loops
 * BIG-O of this logic is n^2
 * 
 * @author Tang Hao
 *
 */
public class Exercise_4_1_2_MaximumSubarrayWithBruteForce extends CommonLogics{
	public static void main(String [] args){
		int [] inputArray = {12 , 42 , 24, 23 , -43 , 64 ,3 ,64 ,75, 24};
		printIntArray(inputArray, true);
		
		MaxSubarrayOutputHolder outputHolder = bruteForceMaximumSubArray(inputArray);
		
		System.out.println(outputHolder);
	}

	public static MaxSubarrayOutputHolder bruteForceMaximumSubArray(int[] inputArray) {
		int startIndex = 0;
		int endIndex = 0;
		int maxSum = -10000;
		
		for(int i = 0; i < inputArray.length ; i++){
			int loopSum = 0;
			int loopSumMax = -10000;
			int loopMaxEndIndex = 0;
			for(int j = i ; j< inputArray.length; j++ ){
				loopSum += inputArray[j];
				if(loopSum > loopSumMax){
					loopSumMax = loopSum;
					loopMaxEndIndex = j;
				}
			}
			
			if(loopSumMax > maxSum){
				maxSum = loopSumMax;
				startIndex = i;
				endIndex = loopMaxEndIndex;
			}
		}
		
		return new MaxSubarrayOutputHolder(startIndex, endIndex, maxSum);
	}
}
