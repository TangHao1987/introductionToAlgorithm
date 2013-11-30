package heapsort;

import introductiontoalgo.common.CommonLogics;

/**
 * This class demonstrate Heap Sort algorithm in Java code
 * 
 * @author Tang Hao
 * @version 1.0
 */
public class HeapSort extends CommonLogics {
	public static void main(String [] args){
		int [] inputArray = {1,5,10,4,7,8,6,3,2,9};
		printIntArray(inputArray, true);
		
		performHeapSort(inputArray);
		
		printIntArray(inputArray, false);
		
	}
	
	/**
	 * HeapSort algorithm start from here 
	 * 
	 * @param array 
	 */
	public static void performHeapSort(int [] array){
		if(array != null && array.length != 0){
			int heapSize = array.length;
			//build maximum heap before loop start
			heapsort.common.CommonTreeMethod.buildMaxHeap(array, heapSize);
			while(heapSize > 1){
				//exchange first and last element in the array
				array[0] = array[0]^array[heapSize-1];
				array[heapSize-1] = array[0]^array[heapSize-1];
				array[0] = array[0]^array[heapSize-1];
				
				heapSize--;
				//perform mayHeapify after doing exchange
				heapsort.common.CommonTreeMethod.maxHeapify(array, 0, heapSize);
			}
		}
		
	}
}
