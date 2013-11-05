package introductionttoalgo.divideAndConquer.maximumSubarray;

import introductiontoalgo.common.CommonLogics;

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
		int [] inputArray = {-12, 42, -1 , -23 ,32  -5 ,63 , -3 , -3 , 26, -42 ,-74  };
		
		printIntArray(inputArray, true);
		
		OutputHolder output = getMaximumSubarray(inputArray, 0, inputArray.length - 1);
		
		printOutputHolder(output);
	}
	
	public static OutputHolder getMaximumSubarray(int [] array, int startPoint, int endPoint){
		if(startPoint < endPoint){
			int middlePoint = (startPoint + endPoint)/2;
			OutputHolder middleHolder = getMaximumMiddleSubarray(array, startPoint, middlePoint, endPoint);
			OutputHolder leftHolder = getMaximumSubarray(array, startPoint, middlePoint);
			OutputHolder rightHolder = getMaximumSubarray(array, middlePoint+1, endPoint);
			
			if(middleHolder.getMaximumValue() >= leftHolder.getMaximumValue() && middleHolder.getMaximumValue() >= rightHolder.getMaximumValue())
				return middleHolder;
			else if(leftHolder.getMaximumValue() >= middleHolder.getMaximumValue() && leftHolder.getMaximumValue() >= rightHolder.getMaximumValue())
				return leftHolder;
			else 
				return rightHolder;
		}else{
		return new OutputHolder(startPoint, endPoint, array[startPoint]);
		}
	}
	
	private static void printOutputHolder(OutputHolder output){
		System.out.println("Start Index: " + output.getStartIndex() + " End Index: " + output.getEndIndex() + " Maximum Sum: " + output.getMaximumValue());
	}
	
	private static OutputHolder getMaximumMiddleSubarray(int[] array,
			int startPoint, int middlePoint, int endPoint) {
		int startIndex = middlePoint;
		int endIndex = middlePoint;
		int maximumSum = 0;
		
		int maximumLeftSum = 0;
		int leftSum = 0;
		int maximumRightSum = 0;
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
		
		return new OutputHolder(startIndex, endIndex, maximumSum);
	}



	public static class OutputHolder{
		private int startIndex;
		private int endIndex;
		private int maximumValue;
		
		
		public OutputHolder(int startIndex, int endIndex, int maximumValue) {
			super();
			this.startIndex = startIndex;
			this.endIndex = endIndex;
			this.maximumValue = maximumValue;
		}
		public int getStartIndex() {
			return startIndex;
		}
		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}
		public int getEndIndex() {
			return endIndex;
		}
		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}
		public int getMaximumValue() {
			return maximumValue;
		}
		public void setMaximumValue(int maximumValue) {
			this.maximumValue = maximumValue;
		}
		
	}
}
