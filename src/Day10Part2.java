import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day10Part2 {

    public static void main(String[] args) throws Exception{

        @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("inputs/Day10.txt"));

        List<Integer> stops = new ArrayList<>();
        stops.add(20);
        stops.add(60);
        stops.add(100);
        stops.add(140);
        stops.add(180);
        stops.add(220);

        long sum = 0;
        int cycleCounter = 0;
        long currentValue = 1;

        String line;
        while ((line = br.readLine()) != null) {
            if ("noop".equals(line)) {
                cycleCounter++;
                if (stops.contains(cycleCounter)) {
                    sum += cycleCounter * currentValue;
                }
                drawCycle(cycleCounter, currentValue);
            }
            if (line.startsWith("addx")) {
                cycleCounter ++;
                if (stops.contains(cycleCounter)) {
                    sum += cycleCounter * currentValue;
                }
                drawCycle(cycleCounter, currentValue);
                cycleCounter ++;
                if (stops.contains(cycleCounter)) {
                    sum += cycleCounter * currentValue;
                }
                drawCycle(cycleCounter, currentValue);
                currentValue += Integer.parseInt(line.split(" ")[1]);
            }
        }
        System.out.println(sum);
    }

    private static void drawCycle(int cycleCounter, long currentValue) {
        int currentPos = (cycleCounter % 40);

        if (currentPos < currentValue || currentPos > currentValue + 2) {
            System.out.print(".");
        } else {
            System.out.print("#");
        }
        if (currentPos == 0) {
            System.out.println();
        }
    }
}