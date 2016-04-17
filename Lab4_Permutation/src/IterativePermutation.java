import java.util.ArrayList;
import java.util.List;

public class IterativePermutation {

	List<String> permutations = null;

	public List<String> findPermutations(String word) {

		permutations = new ArrayList<String>();

		List<Character> wordArray = Utils.convertStringToList(word);
		permutations.add(new String("" + wordArray.get(0)));
		
		for (int j = 1; j < wordArray.size(); j++) {

			char c = wordArray.get(j).charValue();

			// Creo nuove permutazioni combinando c con tutte le altre
			// permutazioni esistenti.

			for (int i = permutations.size() - 1; i >= 0; i--) {

				String str = permutations.remove(i);
				
				for (int l = 0; l <= str.length(); l++) {

					permutations.add(str.substring(0, l) + c + str.substring(l));
				}
			}
		}

		return permutations;
	}
}