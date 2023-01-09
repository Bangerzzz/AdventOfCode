import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class Day6 {
    public static void main(String[] args) throws Exception{

        @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("inputs/Day6.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] characters = line.split("");

            List<String> buffer = new ArrayList<>();

            int idx = 0;
            for (String s : characters) {
                if (buffer.size() > 3) {
                    if (buffer.size() == new HashSet<>(buffer).size()) {
                        break;
                    }
                    buffer.add(s);
                    buffer.remove(0);
                } else {
                    buffer.add(s);
                }
                idx++;
            }

            System.out.println(idx);
        }
    }
}