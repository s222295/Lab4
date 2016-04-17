import java.util.List;

public class Main {

	public static int n = 4;

	public static void main(String[] args) {

		String word = "Andrea";

		RecursivePermutation1 rp1 = new RecursivePermutation1();
		List<String> listResult = rp1.findPermutations1(word);
		System.out.println("Numero di permutazioni: " + listResult.size());
		System.out.println(listResult);
		
		RecursivePermutation2 rp2 = new RecursivePermutation2();
		listResult = rp2.findPermutations2(word);
		System.out.println("Numero di permutazioni: " + listResult.size());
		System.out.println(listResult);
		
		IterativePermutation ip = new IterativePermutation();
		listResult = ip.findPermutations(word);
		System.out.println("Numero di permutazioni: " + listResult.size());
		System.out.println(listResult);
	}
}
