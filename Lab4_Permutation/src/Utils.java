import java.util.ArrayList;
import java.util.List;

public class Utils {
	
	public static List<Character> convertStringToList(String word) {
		List<Character> list = new ArrayList<Character>();
		for (char c : word.toCharArray())
			list.add(Character.valueOf(c));
		return list;
	}

	public static String converListToString(List<Character> list){
		StringBuilder sb = new StringBuilder();
		for (Character c: list){
			sb.append(c);
		}
		return sb.toString();
	}

	public static int listCounter(List<Character> word, char c) {
		
		int listCounter = 0;
		
		for (Character a: word)
			if (a.charValue() == c)
				listCounter++;
		
		return listCounter;
	}

	public static int arrayCounter(char[] characters, char c) {
		
		int arrayCounter = 0;
		
		for (char a: characters) {
			if (a == c)
				arrayCounter++;
		}
		
		return arrayCounter;
	}
	
}
