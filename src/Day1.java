
public class Day1 {

	public static void main(String[] args) {
		
	    String calories = """
	1000
	2000
	3000

	4000

	5000
	6000

	7000
	8000
	9000

	10000
	                       """;
	    for(String s: calories.split("\n")){
	        System.out.println(s);
	    }
	}

}
