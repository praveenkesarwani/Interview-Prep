import java.util.*;
import java.io.*;

class MaxAreaOfIsland {

    static int[] dir = { -1, 0, 1, 0, -1 };

    public static int maxAreaOfIsland(ArrayList<ArrayList<Integer>> grid) {
        int maxArea = 0;
        int num_rows = grid.size();
        int num_cols = grid.get(0).size();
        for (int row = 0; row < num_rows; row++) {
            for (int col = 0; col < num_cols; col++) {
                if (grid.get(row).get(col) == 1) {
                    int area = getMaxArea(grid, row, col);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    public static int getMaxArea(ArrayList<ArrayList<Integer>> grid, int row, int col) {
        // check boundary condition
        if (row < 0 || col < 0 || row >= grid.size() || col >= grid.get(0).size() || grid.get(row).get(col) == 0) {
            return 0;
        }
        grid.get(row).set(col, 0);
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int x = row + dir[i];
            int y = col + dir[i + 1];
            area += getMaxArea(grid, x, y);
        }
        return area;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n, m;

        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> b = new ArrayList<>();

            for (int j = 0; j < m; j++) {
                b.add(sc.nextInt());
            }
            a.add(b);
        }

        int ans = MaxAreaOfIsland.maxAreaOfIsland(a);
        System.out.println(ans);
    }

}
