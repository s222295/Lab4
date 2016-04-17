import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveSquare3 {

	private int solutionCounter = 0;

	public int solveRecursiveSquare3(int[] array) {

		recursiveSquare3(new ArrayList<Integer>(), array, 0);
		return solutionCounter;
	}

	/*
	 * Terza versione ricorsiva: In questo caso la soluzione viene costruita
	 * in modo incrementale aggiungendo un numbero ad ogni passo della
	 * ricorsione. Arrivati al livello == Main.dim controllo se la soluzione
	 * soddisfa i requisiti del quadrato magico.
	 */
	private void recursiveSquare3(List<Integer> square, int[] array, int passo) {
		
		// Condizione di terminazione
		if (passo == array.length) {
			if (Utils.checkQuadratoMagico(Utils.toIntArray(square))) {
				if (Main.debug)
					System.out.println(Arrays.toString(Utils.toIntArray(square)));
				solutionCounter++;
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			
			if (!square.contains(Integer.valueOf(array[i]))) {
				square.add(Integer.valueOf(array[i]));
	
				// Richiamo la funzione ricorsiva
				recursiveSquare3(square, array, passo + 1);
	
				// Backtrack: ri-scambio gli elementi precedentemetne scambiati.
				square.remove(Integer.valueOf(array[i]));
			}
		}
	}

}
