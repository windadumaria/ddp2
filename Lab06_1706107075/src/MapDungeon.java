import java.util.Scanner;

public class MapDungeon {
    private String[] map;
    private int col, row;
    private boolean found;
    private int artifactCount;
    private int xStart, yStart;
    private boolean[][] flags;

    public boolean isFound() {
        return found;
    }

    public int getArtifactCount() {
        return artifactCount;
    }

    public void fillData() {
        String input = (new Scanner(System.in)).nextLine();
        String[] in = input.split(" ");
        row = Integer.parseInt(in[0]);
        col = Integer.parseInt(in[1]);
//        System.out.println("row : "+row+" & col : "+col);
        map = new String[row];
        flags = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = new String((new Scanner(System.in)).next());
//            System.out.println(peta[i]);
            for (int j = 0; j < col; j++) {
                if (map[i].charAt(j) == 'S') {
                    xStart = i;
                    yStart = j;
                }
            }
        }
    }

    public void run() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                flags[i][j] = false;
            }
        }
        artifactCount = 0;
        found = false;
        searching(xStart, yStart);
    }

    private void searching(int x, int y) {

        if ((x >= 0 && x < row) && (y >= 0 && y < col)) {
            if (!flags[x][y]) {
//                System.out.println("x : " + x + " & y: " + y + " CHAR : " + peta[x].charAt(y));
                flags[x][y] = true;
                if (map[x].charAt(y) != '#') {
                    if(map[x].charAt(y) == 'A') {
                        artifactCount++;
                    }
                    if(map[x].charAt(y) == 'X') {
                        found = true;
                    }
                    searching(x, y - 1);
                    searching(x - 1, y);
                    searching(x, y + 1);
                    searching(x + 1, y);
                }
            }
        }
    }
}
