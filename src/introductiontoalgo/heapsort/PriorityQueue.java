package introductiontoalgo.heapsort;

import introductiontoalgo.heapsort.common.CommonTreeMethod;

/**
 * This Priority Queue implements a few common methods</br> <li>
 * <ul>
 * insert(int key)
 * </ul>
 * <ul>
 * getMaximum()
 * </ul>
 * <ul>
 * popMaximum()
 * </ul>
 * <ul>
 * modifyIndexKey(int index, int key)
 * </ul>
 * </li>
 * 
 * @author Tang Hao
 * 
 */
public class PriorityQueue {
	/**
	 * array is the data storage for the PriorityQueue, all the user data is
	 * stored in this array
	 */
	private int[] array;
	/**
	 * HeapSize is the pointer to the PriorityQueue element, it always points to
	 * the last element in the priority Queue Initialised value is 0 as queue at
	 * initialise time is empty
	 */
	private int heapSize;

	/**
	 * Constructor use to initialise PriorityQueue Must offer the size for the
	 * array to initialise it
	 * 
	 * @param size
	 */
	public PriorityQueue(int size) {
		if (size > 0) {
			array = new int[size];
			heapSize = -1;
		}
	}

	/**
	 * This method used to insert new element into priority queue,
	 * it will return true if insertion is successful
	 * else will return false
	 * @param key
	 * @return
	 */
	public boolean insert(int key) {
		if (heapSize == array.length - 1) {
			System.out
					.println("PriorityQueue is already full, please removed some elements before excuting insert");
			return false;
		} else {
			heapSize++;
			array[heapSize] = key;
			sortKey(heapSize);
			return true;
		}
	}

	/**
	 * This method will popup the first element, as the largest element in the queue, and resize the queue
	 * @return
	 */
	public int popMaximum() {
		if (heapSize > -1) {
			if (heapSize == 0) {
				heapSize--;
				return array[0];
			} else {
				int max = array[0];
				array[0] = array[heapSize];
				heapSize--;
				CommonTreeMethod.maxHeapify(array, 0, heapSize);
				return max;
			}
		} else {
			throw new IllegalStateException("No element in priority queue");
		}
	}

	/**
	 * This method just return the largest value inside priority queue
	 * @return
	 */
	public int getMaximum() {
		return array[0];
	}

	/**
	 * This method used to sort the key at inputIndex position to be the proper location in binary tree
	 * 
	 * @param inputIndex
	 */
	private void sortKey(int inputIndex) {
		int index = inputIndex;
		while (CommonTreeMethod.hasParent(index)) {
			int parent = CommonTreeMethod.getParent(index);
			if (array[index] < array[parent]) {
				break;
			}

			array[index] = array[index] ^ array[parent];
			array[parent] = array[index] ^ array[parent];
			array[index] = array[index] ^ array[parent];

			index = parent;
		}
	}
	
	/**
	 * This method is simply printing all the element in priority queue 
	 */
	public void printPriorityQueue(){
		if(heapSize == -1){
			System.out.println();
		}
		else{
			for(int i =0 ; i<=heapSize ; i++){
				System.out.println(" " + array[i]);
			}
		}
	}

	/**
	 * This method used to modify the value of the specified key, the key will be auto-resorted 
	 * in the priority queue
	 * 
	 * @param index
	 * @param key
	 */
	public void modifyIndexKey(int index, int key) {
		array[index] = key;
		if (CommonTreeMethod.hasParent(index)) {
			if (array[index] > array[CommonTreeMethod.getParent(index)]) {
				sortKey(index);
			} else {
				CommonTreeMethod.maxHeapify(array, index, heapSize);
			}
		} else {
			CommonTreeMethod.maxHeapify(array, index, heapSize);
		}
	}
}
