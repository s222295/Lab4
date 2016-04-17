import java.util.List;

public class Utils {

	/*
	 * Metodo wrapper su tutti i controlli
	 */
	static boolean checkQuadratoMagico(int[] array) {
		if (checkRows(array))
			if (checkColumns(array))
				return checkDiagonals(array);

		return false;
	}

	/*
	 * Esegue il controllo dei vincoli sulle righe
	 */
	static private boolean checkRows(int[] array) {

		int temp = 0, temp2 = 0;

		for (int i = 0; i < Main.dim; i++) {

			temp = 0;

			for (int j = 0; j < Main.dim; j++)
				temp += array[i * Main.dim + j];

			if (temp2 == 0)
				temp2 = temp;
			else if (temp2 != temp)
				return false;
		}
		return true;

	}

	/*
	 * Esegue il controllo dei vincoli sulle colonne
	 */
	static private boolean checkColumns(int[] array) {

		int temp = 0, temp2 = 0;

		for (int i = 0; i < Main.dim; i++) {

			temp = 0;

			for (int j = 0; j < Main.dim; j++) {
				temp += array[i + j * Main.dim];
			}
			//
			if (temp2 == 0)
				temp2 = temp;
			else if (temp2 != temp)
				return false;
		}
		return true;
	}

	/*
	 * Esegue il controllo dei vincoli sulla diagonali
	 */
	static private boolean checkDiagonals(int[] array) {
		
		int temp = 0, temp2 = 0;
		
		for (int j = 0; j < Main.dim; j++) {
			temp+=array[j*Main.dim+j];
		}
		
		for (int j = Main.dim-1; j >= 0; j--) {
			temp2+=array[j*Main.dim+j];
		}
		
		if (temp2 != temp)
			return false;
		
		return true;
	}

	/*
	 * Confronta due array passati in input
	 */
	public static boolean compareArrays(int[] array1, int[] array2) {
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] != array2[i]) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Inizializza l'array passato come parametro
	 */
	public static int[] initializeArray(int[] array) {
		for (int i = 0; i < Main.dim * Main.dim; i++) {
			array[i] = i + 1;
		}
		return array;
	}
	
	/*
	 * Converte una lista di Integer in un array di int
	 */
	public static int[] toIntArray(List<Integer> list)  {
	    int[] ret = new int[list.size()];
	    int i = 0;
	    for (Integer e : list)  
	        ret[i++] = e.intValue();
	    return ret;
	}

}
