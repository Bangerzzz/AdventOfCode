import java.io.BufferedReader;
import java.io.FileReader;

public class Day4 {
    public static void main(String[] args) throws Exception{

        @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("inputs/Day4.txt"));

        int count = 0;
        int no_overlap_count = 0;
        int all = 0;

        String line;
        while ((line = br.readLine()) != null) {
            String[] elfassign = line.split(",");

            String[] assign1 = elfassign[0].split("-");
            String[] assign2 = elfassign[1].split("-");

            int assign1low = Integer.parseInt(assign1[0]);
            int assign1high = Integer.parseInt(assign1[1]);
            int assign2low = Integer.parseInt(assign2[0]);
            int assign2high = Integer.parseInt(assign2[1]);

            if (assign1low <= assign2low && assign1high >= assign2high) {
                count++;
            } else if (assign1low >= assign2low && assign1high <= assign2high) {
                count++;
            }

            if (assign1low > assign2high) {
                no_overlap_count++;
            } else if (assign2low > assign1high) {
                no_overlap_count++;
            }

            all++;
        }

        System.out.println(count);
        System.out.println(no_overlap_count);
        System.out.println(all - no_overlap_count);
    }
}