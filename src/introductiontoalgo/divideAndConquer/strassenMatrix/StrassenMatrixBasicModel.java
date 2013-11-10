package introductiontoalgo.divideAndConquer.strassenMatrix;

import introductiontoalgo.common.strassenMatrix.ArrayOperation;
import introductiontoalgo.common.strassenMatrix.PartIndex;

/**
 * This java program demonstrate basic strassen matrix algorithm for multiplication of two matrixes
 * the input matrixes must be n x n matrixes 
 * 
 * @author Hao
 *
 */
public class StrassenMatrixBasicModel { 
	public static void main(String [] args){
		int [][] matrixA = {
				{1, 4, 0, 2},
				{4, 8, 6, 3},
				{5, 9, 2, 1},
				{0, 3, 7, 5}
		};
		
		int [][] matrixB = {
				{2, 6, 7, 3},
				{4, 9, 6, 4},
				{3, 5, 6, 1},
				{6, 3, 9, 7}
		};
		
		int [][] matrixC = strassenAlgorithm(matrixA, matrixB); 
		
		System.out.println("The output array is:");
		System.out.println("[");
		for(int [] row : matrixC){
			for(int number : row){
				System.out.print(" " + number);
			}
			System.out.println(";");
		}
		System.out.println("]");
		
	}

	private static int[][] strassenAlgorithm(int[][] matrixA, int[][] matrixB) {
		// TODO Auto-generated method stub
		int [][] outputMatrix = null;
		if(validateInput(matrixA) &&  validateInput(matrixB) && matrixA.length == matrixB.length){
			
			if(matrixA.length == 1){
				int [][] matrixC = new int [0][0];
				matrixC[0][0] = matrixA[0][0]*matrixB[0][0];
				return matrixC;				
			} else{
				//main logic start from here
				int [][] S1 = performArrayOperation(getSubArray(matrixB, PartIndex.FRONT, PartIndex.END), getSubArray(matrixB, PartIndex.END, PartIndex.END),ArrayOperation.SUBSTRACT);
				int [][] S2 = performArrayOperation(getSubArray(matrixA, PartIndex.FRONT, PartIndex.FRONT), getSubArray(matrixA, PartIndex.FRONT, PartIndex.END),ArrayOperation.ADD);
				int [][] S3 = performArrayOperation(getSubArray(matrixA, PartIndex.END, PartIndex.FRONT), getSubArray(matrixA, PartIndex.END, PartIndex.END),ArrayOperation.ADD);
				int [][] S4 = performArrayOperation(getSubArray(matrixB, PartIndex.END, PartIndex.FRONT), getSubArray(matrixB, PartIndex.FRONT, PartIndex.FRONT),ArrayOperation.SUBSTRACT);
				int [][] S5 = performArrayOperation(getSubArray(matrixA, PartIndex.FRONT, PartIndex.FRONT), getSubArray(matrixA, PartIndex.END, PartIndex.END),ArrayOperation.ADD);
				int [][] S6 = performArrayOperation(getSubArray(matrixB, PartIndex.FRONT, PartIndex.FRONT), getSubArray(matrixB, PartIndex.END, PartIndex.END),ArrayOperation.ADD);
				int [][] S7 = performArrayOperation(getSubArray(matrixA, PartIndex.FRONT, PartIndex.END), getSubArray(matrixA, PartIndex.END, PartIndex.END),ArrayOperation.SUBSTRACT);
				int [][] S8 = performArrayOperation(getSubArray(matrixB, PartIndex.END, PartIndex.FRONT), getSubArray(matrixB, PartIndex.END, PartIndex.END),ArrayOperation.ADD);
				int [][] S9 = performArrayOperation(getSubArray(matrixA, PartIndex.FRONT, PartIndex.FRONT), getSubArray(matrixA, PartIndex.END, PartIndex.FRONT),ArrayOperation.SUBSTRACT);
				int [][] S10 = performArrayOperation(getSubArray(matrixB, PartIndex.FRONT, PartIndex.FRONT), getSubArray(matrixB, PartIndex.FRONT, PartIndex.END),ArrayOperation.ADD);
				
				int [][] P1 = strassenAlgorithm(getSubArray(matrixA, PartIndex.FRONT, PartIndex.FRONT), S1);
				int [][] P2 = strassenAlgorithm(S2, getSubArray(matrixB, PartIndex.END, PartIndex.END));
				int [][] P3 = strassenAlgorithm(S3, getSubArray(matrixB, PartIndex.FRONT, PartIndex.FRONT));
				int [][] P4 = strassenAlgorithm(getSubArray(matrixA, PartIndex.END, PartIndex.END), S4);
				int [][] P5 = strassenAlgorithm(S5, S6);
				int [][] P6 = strassenAlgorithm(S7, S8);
				int [][] P7 = strassenAlgorithm(S9, S10);
				
				int [][] C11 = performArrayOperation(P5, P4, ArrayOperation.ADD);
				C11 = performArrayOperation(C11, P2, ArrayOperation.SUBSTRACT);
				C11 = performArrayOperation(C11, P6, ArrayOperation.ADD);
				int [][] C12 = performArrayOperation(P1, P2, ArrayOperation.ADD);
				int [][] C21 = performArrayOperation(P3, P4, ArrayOperation.ADD);
				int [][] C22 = performArrayOperation(P5, P1, ArrayOperation.ADD);
				C22 = performArrayOperation(C22, P3, ArrayOperation.SUBSTRACT);
				C22 = performArrayOperation(C22, P7, ArrayOperation.SUBSTRACT);
				
				outputMatrix = combineSubarrays(C11,C12,C21,C22);
			}
		}
		
		return outputMatrix;
	}

	private static int[][] combineSubarrays(int[][] matrix11, int[][] matrix12,
			int[][] matrix21, int[][] matrix22) {
		int halfLength = matrix11[0].length;
		int matrixX = 2*halfLength;
		int matrixY = 2*halfLength;
		int [][] matrix = new int [matrixY][matrixX];
		for (int y = 0; y < halfLength; y++){
			for(int x = 0; x < halfLength;x++){
				matrix[y][x] = matrix11[y][x];
				matrix[y+halfLength][x] = matrix21[y][x];
				matrix[y][x+halfLength] = matrix12[y][x];
				matrix[y+halfLength][x+halfLength] = matrix22[y][x];
			}
		}
		// TODO Auto-generated method stub
		return matrix;
	}

	private static boolean validateInput(int[][] matrix) {
		// TODO Auto-generated method stub
		boolean isValidated = true;
		if(matrix == null){
			isValidated = false;
		}else if(matrix[0].length != matrix.length){
			isValidated = false;
		}
		return isValidated; 
	}
	
	private static int [][] getSubArray(int [][] matrix, PartIndex vIndex, PartIndex hIndex){
		int[][] subArray = null;
		if (validateInput(matrix)) {
			int halfLength = matrix.length/2;
			switch (hIndex) {
			case FRONT:
				switch (vIndex) {
				case FRONT:
					subArray = copyPartArray(matrix, 0 , 0, halfLength);
					break;
				case END:
					subArray = copyPartArray(matrix, 0, halfLength+1, halfLength);
					break;
				default:
					System.out.println("vertical Index for matrix is not set correctly" );
				}
				break;
			case END:
				switch (vIndex) {
				case FRONT:
					subArray = copyPartArray(matrix, halfLength+1 , 0, halfLength);
					break;
				case END:
					subArray = copyPartArray(matrix, halfLength+1 , halfLength+1, halfLength);
					break;
				default:
					System.out.println("vertical Index for matrix is not set correctly" );
				}
			default:
				System.out.println("horizontal Index for matrix is not set correctly" );
			}
		}
		return subArray;
		
	}

	private static int[][] copyPartArray(int[][] matrix, int startX, int startY,
			int halfLength) {
		int [][] outputMatrix = new int [halfLength][halfLength];
		for(int y = startY; y <= (startY + halfLength) ; y++){
			for(int x = startX; x <= (startX + halfLength); x++){
				outputMatrix[y][x] = matrix[y][x];
			}
		}
		return outputMatrix;
	}
	
	private static int [][] performArrayOperation(int[][] arrayA, int [][] arrayB, ArrayOperation ao){
		int [][] outputArray = null;
		switch (ao) {
		case ADD:
			outputArray = performAddOperation(arrayA,arrayB);
			
			break;
		case SUBSTRACT:
			outputArray = performSubstractOperation(arrayA, arrayB);
			break;
		default:
			System.out.println("ArrayOperation for matrix is not set correctly" );
		}
		
		return outputArray;
	}

	private static int[][] performAddOperation(int[][] arrayA, int[][] arrayB) {
		int[][] outputArray = new int [arrayA.length][arrayA[0].length];
		for(int i = 0; i < arrayA.length; i++){
			for (int j=0; j<arrayA[0].length;j++){
				outputArray[i][j] = arrayA[i][j] + arrayB[i][j];
			}
		}
		return outputArray;
	}
	
	private static int[][] performSubstractOperation(int[][] arrayA, int[][] arrayB) {
		int[][] outputArray = new int [arrayA.length][arrayA[0].length];
		for(int i = 0; i < arrayA.length; i++){
			for (int j=0; j<arrayA[0].length;j++){
				outputArray[i][j] = arrayA[i][j] - arrayB[i][j];
			}
		}
		return outputArray;
	}
}
