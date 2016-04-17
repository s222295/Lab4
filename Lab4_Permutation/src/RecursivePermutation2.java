import java.util.ArrayList;
import java.util.List;

public class RecursivePermutation2 {

	List<String> permutations = null;

	public List<String> findPermutations2(String word) {

		permutations = new ArrayList<String>();
		recursivePermutations2(new ArrayList<Character>(), word.toCharArray(), 0);

		return permutations;
	}

	private void recursivePermutations2(List<Character> word, char[] characters, int passo) {
		
		if (passo == characters.length) {
			permutations.add(Utils.converListToString(word));
			return;
		}

		for (int i = 0; i < characters.length; i++) {

			// Controllo se il carattere i-esimo è già presente nella lista.
			if (Utils.listCounter(word, characters[i]) < Utils.arrayCounter(characters, characters[i])) {
				// Aggiungo un carattere alla mia word
				word.add(Character.valueOf(characters[i]));
				
				// Richiamo la funzione ricorsiva
				recursivePermutations2(word, characters, passo + 1);

				// Tolgo il carattere dalla mia word
				word.remove(Character.valueOf(characters[i]));
			}
		}
	}

}
