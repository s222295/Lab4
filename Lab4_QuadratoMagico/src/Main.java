import java.util.Arrays;

public class Main {

	final static int dim = 3;
	final static boolean debug = false;

	public static void main(String[] args) {

		if (debug) {

			int[] debug_array = { 2, 7, 6, 9, 5, 1, 4, 3, 8 };
			System.out.println(Arrays.toString(debug_array));
			boolean returnValue = Utils.checkQuadratoMagico(debug_array);
			System.out.println("Check Quadrato Magico: " + returnValue);

		}

		int[] array = new int[dim * dim];
		array = Utils.initializeArray(array);

		if (debug) {
			System.out.println(Arrays.toString(array));
		}
		
		RecursiveSquare1 rs1 = new RecursiveSquare1();
		int solutionCounter = rs1.solveRecursiveSquare1(array);
		System.out.println("Counter: " + solutionCounter);
		
		RecursiveSquare2 rs2 = new RecursiveSquare2();
		solutionCounter = rs2.solveRecursiveSquare2(array);
		System.out.println("Counter: " + solutionCounter);
		
		RecursiveSquare3 rs3 = new RecursiveSquare3();
		solutionCounter = rs3.solveRecursiveSquare3(array);
		System.out.println("Counter: " + solutionCounter);
	}
}