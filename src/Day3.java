import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("inputs/Day3.txt"));

	        int score = 0;

	        String alphabet = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	        String line;
	        while ((line = br.readLine()) != null) {
	            int[] chars = new int[line.length()];
	            int i = 0;
	            for (String e : line.split("")) {
	                chars[i] = alphabet.indexOf(e);
	                i++;
	            }

	            int[] first = Arrays.copyOfRange(chars, 0, chars.length / 2);
	            int[] second = Arrays.copyOfRange(chars, chars.length / 2, chars.length);
	          //Set collection sans doublons only les valeurs uniques
	            Set<Integer> scores = new HashSet<>();
	            for (int k = 0; k < first.length; k++) {
	                for (int j = 0; j < second.length; j++) {
	                    if (first[k] == second[j]) {
	                        scores.add(first[k]);
	                    }
	                }
	            }
	          //reduire la liste et retouner la somme de a et b au lieu de a et b
	            score += scores.stream().reduce((a, b) -> a + b).get();
	        }
	        System.out.println(score);
	}

}
