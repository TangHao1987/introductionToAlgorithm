package heapsort.common;

public class CommonTreeMethod {
	public static int getLeft(int i){
		return 2*i + 1;
	}
	
	public static int getRight(int i){
		return 2*i + 2;
	}
	
	public static int getParent(int i){
		return i/2;	
	}
	
	public static void maxHeapify(int [] array, int index, int heapSize){
		int left = getLeft(index);
		int right = getRight(index);
		int largest = -1000;
		if(left < heapSize && array[left] > array[index]){
			largest = left;
		}else{
			largest = index;
		}
		
		if(right < heapSize && array[right] > array[largest]){
			largest = right;
		}
		
		if(largest != index && largest != -1000){
			array[largest] = array[largest]^array[index];
			array[index] = array[largest]^array[index];
			array[largest] = array[largest]^array[index];
			
			maxHeapify(array, largest, heapSize);
		}
	}
	
	public static void buildMaxHeap(int [] array, int heapSize){
		for(int index = (array.length-2)/2 ; index >= 0 ; index--){
			maxHeapify(array, index, heapSize);
		}
	}
	
}
