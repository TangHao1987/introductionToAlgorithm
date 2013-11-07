package introductiontoalgo.divideAndConquer.maximumSubarray;

import introductiontoalgo.common.CommonLogics;
import introductiontoalgo.common.MaxSubarrayOutputHolder;

/**
 * 
 * This is the algorithm described in 4.1.5
 * BIG-O of this logic is n^2
 * 
 * @author Tang Hao
 *
 */
public class Exercise_4_1_5_MaximumSubarrayWithCustomLogic extends CommonLogics{
	public static void main(String [] args){
		int [] inputArray = {12 , 42 , 24, 23 , -43 , 64 ,3 ,64 ,75, 24};
		printIntArray(inputArray, true);
		
		MaxSubarrayOutputHolder outputHolder = customAlgoMaximumSubArray(inputArray);
		
		System.out.println(outputHolder);
	}

	public static MaxSubarrayOutputHolder customAlgoMaximumSubArray(int[] inputArray) {
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
