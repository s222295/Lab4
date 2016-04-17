import java.util.ArrayList;
import java.util.List;

public class RecursivePermutation1 {

	List<String> permutations = null;

	public List<String> findPermutations1(String word) {

		permutations = new ArrayList<String>();
		recursivePermutations1(word, 0);

		return permutations;
	}

	private void recursivePermutations1(String word, int passo) {
		if (passo == word.length()) {
			permutations.add(word);
			return;
		}

		for (int i = passo; i < word.length(); i++) {

			char[] chars = word.toCharArray();

			// Genero una nuova soluzione
			char temp = chars[passo];
			chars[passo] = chars[i];
			chars[i] = temp;

			// Richiamo la funzione ricorsiva
			recursivePermutations1(String.valueOf(chars), passo + 1);

			// Trasformando l'array di chars non è necessario fare backtrack.
		}
	}
}
