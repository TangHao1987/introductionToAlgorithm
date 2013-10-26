package introductiontoalgo.gettingstart.designingalgorithms;

/**
 * This class include algorithm of insertionSort with a recursive way.
 * and this class is also the solution of excrise 2.3_4
 * @author Tang Hao
 *
 */
public class Exercises_2_3_4_RecursiveInsertionSort {
	public static void main(String[] args) {
		int [] input = {3, 41 , 52 , 26, 38, 57, 9 , 49};
		// output array
		int[] output = input;

		System.out.print("input int String is: [ ");
		for (int i : input) {
			System.out.print(i + " ");
		}
		System.out.println("]");
		
		//Algorithm starts from here
		insertionSort(output, output.length -1 );
		//Algorithm ends at here
		
		System.out.print("output int String is: [ ");
		for (int i : output) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}
	
	public static void insertionSort(int [] array, int endPoint){
		if(endPoint >= 1){
			insertionSort(array, endPoint - 1);
			int i = endPoint - 1;
			int key = array[endPoint];
			while (i > 0 && array[i] > key){
				array[i+1] = array[i];
				i--;
			}
			array[i+1] = key;
		}
	}
}
