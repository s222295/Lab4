import java.util.Arrays;

public class RecursiveSquare1 {

	private int solutionCounter = 0;

	public int solveRecursiveSquare1(int[] array) {

		recursiveSquare1(array, 0);
		return solutionCounter;
	}

	/*
	 * Prima versione ricorsiva:
	 * le soluzioni vengono cercate calcolando tutte le possibili permutazioni
	 * dei numeri nell'array. La soluzione è molto simile alla permutazione delle
	 * parole, ma è necessario introdurre il Backtracking perchè in questo non
	 * si utilizzano le stringhe che sono oggetti immutabili.
	 * Arrivati al livello == Main.dim controllo se la soluzione soddisfa
	 * i requisiti del quadrato magico.
	 */
	private void recursiveSquare1(int[] array, int passo) {
		if (passo == array.length) {
			if (Utils.checkQuadratoMagico(array)) {
				if (Main.debug)
					System.out.println(Arrays.toString(array));
				solutionCounter++;
			}
		}

		for (int i = passo; i < array.length; i++) {

			// Genero una nuova soluzione scambiando l'elemento in posizione i-esima
			// con tutti i successivi
			int t = array[i];
			array[i] = array[passo];
			array[passo] = t;
			
			recursiveSquare1(array, passo + 1);
			
			// Backtrack: riscambio gli elementi precedentemente scambiati
			array[passo] = array[i];
			array[i] = t;
		}
	}

}
