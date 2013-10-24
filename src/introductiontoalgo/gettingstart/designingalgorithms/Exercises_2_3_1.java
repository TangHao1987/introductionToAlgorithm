package introductiontoalgo.gettingstart.designingalgorithms;

import introductiontoalgo.common.CommonLogics;

/**
 * This case is exactly same as basic model but using sentinel instance of checking if half array is out of boundary
 * Main method use to run the logic
 * merge method and merge sort method contain main logic 
 * 
 * @author Tang Hao
 *
 */
public class Exercises_2_3_1 extends CommonLogics{
	public static void main(String [] args){
		int [] inputArray = {3, 41 , 52 , 26 , 38 , 57 , 9 ,49};
		printIntArray(inputArray, true);
		
		//Algorithm starts here
		mergeSort(inputArray, 0, inputArray.length - 1);
		//Algorithm ends here
		
		printIntArray(inputArray, false);
	}
	
	/**
	 * Recursively separate an int array to two half lengths arrays, and then 
	 * sort the half arrays, and merge them back to a whole array
	 * @param array
	 * @param startPoint
	 * @param endPoint
	 */
	public static void mergeSort(int [] array, int startPoint, int endPoint){
		if(startPoint < endPoint){
			int middlePoint = (startPoint + endPoint)/2;
			mergeSort(array, startPoint, middlePoint);
			mergeSort(array, middlePoint + 1, endPoint);
			merge(array,startPoint,middlePoint,endPoint);
		}
	}
	
	/**
	 * This method use to merge two sorted sub array in array to be a whole sorted array
	 * 
	 * @param array
	 * @param startPoint
	 * @param middlePoint
	 * @param endPoint
	 */
	public static void merge(int [] array, int startPoint, int middlePoint, int endPoint){
		int [] leftArray = new int [middlePoint - startPoint + 2] ;
		int [] rightArray = new int [endPoint - middlePoint + 1] ;
		//define sentinel
		leftArray[middlePoint - startPoint + 1] = 10000;
		rightArray[endPoint - middlePoint] = 10000;
		//build leftArray and right Array
		for(int i = startPoint; i <= endPoint ; i++){
			if(i <= middlePoint)
				leftArray[i - startPoint] = array[i];
			else
				rightArray[i - middlePoint - 1] = array[i];
		}
		
		//put array back to original array
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = startPoint; i <= endPoint ; i++){
			if(rightArray[rightIndex] > leftArray[leftIndex]){
				array[i]=leftArray[leftIndex];
				leftIndex++;
			}else{
				array[i] = rightArray[rightIndex];
				rightIndex ++;
			}
		}
	}
}
