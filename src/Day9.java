import java.io.BufferedReader;
import java.io.FileReader;

public class Day9 {


    public static final int gridSize = 1000;

    public static int[] grid = new int[gridSize * gridSize];

    public static int posHeadX = 500;
    public static int posHeadY = 500;
    public static int posTailX = 500;
    public static int posTailY = 500;

    public static void main(String[] args) throws Exception{
        
        @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("inputs/Day9.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            String[] move = line.split(" ");
            move(move[0], Integer.parseInt(move[1]));
        }

        int amount = 0;
        for (int i : grid) {
            if (i > 0) {
                amount++;
            }
        }

        System.out.println(amount);
    }


    private static void move(String dir, int amount) {
        for (int i = 0; i < amount; i++) {
            moveAStep(dir);
        }
    }

    private static void moveAStep(String dir) {
        switch (dir) {
            case "U":
            	posHeadY -= 1;
                break;
            case "D":
            	posHeadY += 1;
                break;
            case "L":
            	posHeadX -= 1;
                break;
            case "R":
                posHeadX += 1;
                break;
        }

        if (Math.abs(posHeadX- posTailX)>1) {
        	if("L".equals(dir)) {
        		posTailX -= 1;
        	}  else {
        		posTailX += 1;
        	}
        	posTailY=posHeadY;
        }
        if (Math.abs(posHeadY- posTailY)>1) {
        	if("U".equals(dir)) {
        		posTailY -= 1;
        	}  else {
        		posTailY += 1;
        	}
        	posTailX=posHeadX;
        }
        grid[posTailY*gridSize + posTailX] +=1;
        
        //printGrid();
        //System.out.println("");

    }

    private static void printGrid() {
        for (int y = 0; y < gridSize; y++) {
            for (int x = 0; x < gridSize; x++) {
                System.out.print(grid[y * gridSize + x]);
            }
            System.out.println();
        }
    }
}