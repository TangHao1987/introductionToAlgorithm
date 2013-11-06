package introductiontoalgo.divideAndConquer.maximumSubarray;

import introductiontoalgo.common.CommonLogics;
import introductiontoalgo.common.MaxSubarrayOutputHolder;

/**
 * This file is the basic model of maximum Subarray problem.
 * To find the largest change problem can be convert to maximum Subarray problem 
 * by getting the change rate of each basic unit, and find maximum Subarray
 * 
 *  To use divid-and-conquer method for maximum Subarray problem:
 *  <li>
 *  <ul> Find the most close middle point
 *  <ul> check if the Maximum Array is at left side, middle or right side
 *  <ul> return the Maximum array 
 *  <ul> left and right sides are just arrays which have half length of original problem, so just divide-and-conquer  
 * </li>
 * @author Tang Hao
 *
 */
public class MaximumSubarrayAlgorithmBasicModel extends CommonLogics{
	public static void main(String [] args){
		int [] inputArray = {-12, -42, -11 , -23 ,32  ,35 ,-36 , 13, -2 , -26, 42 ,-7  };
		
		printIntArray(inputArray, true);
		
		MaxSubarrayOutputHolder output = getMaximumSubarray(inputArray, 0, inputArray.length - 1);
		
		printOutputHolder(output);
	}
	
	public static MaxSubarrayOutputHolder getMaximumSubarray(int [] array, int startPoint, int endPoint){
		if(startPoint < endPoint){
			int middlePoint = (startPoint + endPoint)/2;
			MaxSubarrayOutputHolder middleHolder = getMaximumMiddleSubarray(array, startPoint, middlePoint, endPoint);
			MaxSubarrayOutputHolder leftHolder = getMaximumSubarray(array, startPoint, middlePoint);
			MaxSubarrayOutputHolder rightHolder = getMaximumSubarray(array, middlePoint+1, endPoint);
			
			if(middleHolder.getMaximumValue() >= leftHolder.getMaximumValue() && middleHolder.getMaximumValue() >= rightHolder.getMaximumValue())
				return middleHolder;
			else if(leftHolder.getMaximumValue() >= middleHolder.getMaximumValue() && leftHolder.getMaximumValue() >= rightHolder.getMaximumValue())
				return leftHolder;
			else 
				return rightHolder;
		}else{
		return new MaxSubarrayOutputHolder(startPoint, endPoint, array[startPoint]);
		}
	}
	
	private static void printOutputHolder(MaxSubarrayOutputHolder output){
		System.out.println(output);
	}
	
	private static MaxSubarrayOutputHolder getMaximumMiddleSubarray(int[] array,
			int startPoint, int middlePoint, int endPoint) {
		int startIndex = middlePoint;
		int endIndex = middlePoint;
		int maximumSum = 0;
		
		int maximumLeftSum = -1000;
		int leftSum = 0;
		int maximumRightSum = -1000;
		int rightSum = 0; 
		//get maximum value from left hand side
		for(int leftIndex = middlePoint ; leftIndex >= startPoint ; leftIndex--){
			leftSum += array[leftIndex];
			if (leftSum > maximumLeftSum){
				maximumLeftSum = leftSum;
				startIndex = leftIndex;
			}
		}
		//get maximum value from right hand side
		for(int rightIndex = middlePoint; rightIndex <= endPoint ; rightIndex++){
			rightSum += array[rightIndex];
			if(rightSum > maximumRightSum){
				maximumRightSum = rightSum;
				endIndex = rightIndex;
			}
		}
		
		maximumSum = maximumLeftSum + maximumRightSum;
		
		return new MaxSubarrayOutputHolder(startIndex, endIndex, maximumSum);
	}

}
