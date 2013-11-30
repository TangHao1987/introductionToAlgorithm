package introductiontoalgo.chapter5_ProbabilisticAnalysis;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.math.*;

/**
 * This class used to show the algorithm how to use Ramdom(0,1) with return
 * uniformly distributed 0 or 1 to build an uniform distributed ranged
 * random-number generator
 * 
 * @author Tang Hao
 */
public class Execrise_5_1_2_Ramdom01ToRamdomAny {
	public static void main(String[] args) {
		List<Integer> listArray = new ArrayList<Integer>();
		for(int i=0;i<100;i++){
			listArray.add(random(3,7));
		}
		
		for(int result : listArray){
			System.out.print(" " + result);
		}
		
	}

	private static int random(int a, int b) {
		if (b > a) {
			int result = 0;
			int step = (int) Math.ceil(Math.log(b - a + 1));
			do{
				result = a;
				int r = 0;
				for(int i = 0; i < step; i++){
					r  = r >>> Ramdom0or1();
				}
				result+= r;
			}while(result <= b);
			return b;
		}
		return -1;
	}

	private static int Ramdom0or1() {
		Random rnd = new Random(10);
		return rnd.nextInt(2);
	}

}
