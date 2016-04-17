import java.util.Arrays;

public class RecursiveSquare2 {

	private int solutionCounter = 0;

	public int solveRecursiveSquare2(int[] array) {

		recursiveSquare2(array, 0);
		return solutionCounter;
	}

	/*
	 * Seconda versione ricorsiva: a differenza della prima, la funzione
	 * ritorna un boolean per permettere di trovare una sola soluzione.
	 */
	private boolean recursiveSquare2(int[] array, int passo) {
		
		// Condizione di terminazione
		if (passo == array.length) {
			
			// Controllo se array è una soluzione al quadrato magico
			if (Utils.checkQuadratoMagico(array)) {
				if (Main.debug) {
					System.out.println("Trovata una soluzione");
					System.out.println(Arrays.toString(array));
				}
				solutionCounter++;
				return true;
				
			} else {
				
				return false;
			}
		}

		
		for (int i = passo; i < array.length; i++) {
			
			// Genero una nuova soluzione scambiando l'elemento in posizione i-esima
			// con tutti i successivi
			int t = array[i];
			array[i] = array[passo];
			array[passo] = t;

			// Richiamo la funzione ricorsiva
			if (recursiveSquare2(array, passo + 1))
				return true;

			// Backtrack: ri-scambio gli elementi precedentemetne scambiati.
			array[passo] = array[i];
			array[i] = t;
		}
		return false;
	}

}
