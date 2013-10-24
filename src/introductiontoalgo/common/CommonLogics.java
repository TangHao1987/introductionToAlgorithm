package introductiontoalgo.common;

public class CommonLogics {
	protected static void printIntArray(int [] array, boolean isInput){
		if(isInput){
			System.out.print("Input  [ ");
		}
		else{
			System.out.print("Output [ ");
		}
				
		for(int i : array){
			System.out.print( i + " ");
		}
		
		System.out.println("]");
	}
}
