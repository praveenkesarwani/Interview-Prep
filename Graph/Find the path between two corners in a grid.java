import java.util.*;

public class RobotInAGrid {

    int[][] visit;
    ArrayList<Integer> path;
    Vector<String> pathString;
    boolean isPath;

    Vector<String> robotInAGrid(int grid[][], int n, int m) {
        isPath = false;
        visit = new int[n][m];
        path = new ArrayList<>();
        pathString = new Vector<>();

        Vector<String> notPosiible = new Vector<>();
        notPosiible.add("Not Possible");
        if(!isValid(0,0,grid,n,m))  //strting value is 1 then return not possible
            return notPosiible;
        dfs(0, 0, grid, n, m);
        if (isPath) {
            return pathString;
        } else {
            return notPosiible;
        }
    }

    void dfs(int x, int y, int[][] grid, int n, int m) {
        visit[x][y] = 1;
        path.add(x);
        path.add(y);
        if (x == n - 1 && y == m - 1) { // Base Condition, path found, populate pathString from path
            for (int i = 0; i < path.size(); i += 2) { // + 1 below since path is 1 based not 0 based index
                pathString.add(Integer.toString(path.get(i) + 1) + " " + Integer.toString(path.get(i + 1) + 1));
            }
            isPath = true;
            return;
        }
        if (isValid(x + 1, y, grid, n, m))
            dfs(x + 1, y, grid, n, m); // can check if isPath is true and return here
        if (isValid(x, y + 1, grid, n, m))
            dfs(x, y + 1, grid, n, m); // can check if isPath is true and return here
        path.remove(path.size() - 1); // Backtrack
        path.remove(path.size() - 1);
    }

    boolean isValid(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        if (grid[x][y] == 1 || visit[x][y] == 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int grid[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        RobotInAGrid answer = new RobotInAGrid();
        Vector<String> result = answer.robotInAGrid(grid, n, m);
        for (String elem : result) {
            System.out.println(elem);
        }
    }

}
