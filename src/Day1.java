import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
	    @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader (new FileReader("inputs/Day1.txt"));
	    
	    int calorie = 0;
	    int mostCalories = 0;
	    List<Integer> calorieList = new ArrayList<>();
	    String line;
	    
	    while ((line = br.readLine()) != null) {
            String strCal = line.trim();
            if (strCal.isBlank()) {
                if (mostCalories < calorie) {
                    mostCalories = calorie;
                }
                calorieList.add(calorie);
                calorie = 0;
                continue;
            }
            calorie += Integer.parseInt(strCal);
        }
        calorieList.add(calorie);
        if (mostCalories < calorie) {
            mostCalories = calorie;
        }

        System.out.println(mostCalories);

        calorieList.sort((a, b) -> b - a); //Decroissante
        System.out.println(calorieList.get(0) + calorieList.get(1) + calorieList.get(2));
	}

}
