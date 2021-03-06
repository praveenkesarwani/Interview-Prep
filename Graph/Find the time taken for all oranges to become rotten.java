/*
--------------------------------------------------------------------------------------------------------
|                                        1st Method                                                               |
--------------------------------------------------------------------------------------------------------
*/
import java.util.*;

class RottingOranges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ((t--) > 0) {
            int n, m;
            n = sc.nextInt();
            m = sc.nextInt();
            ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < n; i++) {
                a.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a.get(i).add(sc.nextInt());
                }
            }
            int ans = RottingOranges.rottingOranges(a);
            System.out.println(ans);
        }
        sc.close();
    }

    public static int rottingOranges(ArrayList<ArrayList<Integer>> grid) {
        // handle when matrix has 0 rows or column
        if (grid.size() == 0 || grid.get(0).size() == 0)
            return -1;
        int num_rows = grid.size();
        int num_cols = grid.get(0).size();
        Queue<Integer> q = new LinkedList<>();
        int fresh_oranges = 0;
        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) { // add rotten oranges at the start
                if (grid.get(i).get(j) == 2) // indexing to get the node position
                    q.add(i * num_cols + j);
                else if (grid.get(i).get(j) == 1)
                    fresh_oranges++; // count total fresh oranges
            }
        }

        int num_mins = 0;
        int dir[] = { -1, 0, 1, 0, -1 }; // To search all four directions
        Queue<Integer> temp = new LinkedList<>();

        while (true) { // While we still have rotten oranges
            while (!q.isEmpty()) { // for rotten oranges this minute
                int top = q.remove();
                int topx = top / num_cols;
                int topy = top % num_cols;
                for (int i = 0; i < 4; i++) {
                    int x = topx + dir[i];
                    int y = topy + dir[i + 1];
                    // Fresh oranges with in boundaries
                    if (x >= 0 && x < num_rows && y >= 0 && y < num_cols && grid.get(x).get(y) == 1) {
                        fresh_oranges--;
                        grid.get(x).set(y, 2); // set fresh orangess as rotten
                        temp.add(x * num_cols + y); // add rotten oranges for next minute
                    }
                }
            }
            if (temp.size() == 0) {
                break;
            } else {
                num_mins++;
                q = temp;
                temp = new LinkedList<>();
            }
        }
        if(fresh_oranges == 0)
            return num_mins;
        return -1;
    }
}
/*
--------------------------------------------------------------------------------------------------------
|                                        2nd Method                                                               |
--------------------------------------------------------------------------------------------------------
*/
import java.util.*;

class RottingOranges{
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    static int freshOranges;
    static Queue<Pair> q;
    static int times;
    static int rows;
    static int cols;
    static int []dir = {-1,0,1,0,-1};
    public static int rottingOranges(int[][]grid){
        if(grid == null || grid[0].length == 0){
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        q = new LinkedList<>();
        freshOranges = 0;
        times = 0;
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(grid[i][j] == 2){
                    Pair pair = new Pair(i,j);
                    q.offer(pair);
                }
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        BFS(grid);
        return freshOranges == 0 ? times : -1;
    }

    public static void BFS(int [][]grid){
        boolean checked = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0;j < size;j++){
                Pair coordinates = q.poll();
                int x_coord = coordinates.first;
                int y_coord = coordinates.second;
                for(int i = 0;i < 4;i++){
                    int x = x_coord + dir[i];
                    int y = y_coord + dir[i + 1];
                    if(isValid(x,y,grid)){
                        grid[x][y] = 2;
                        freshOranges--;
                        Pair pair = new Pair(x,y);
                        q.offer(pair);
                        checked = true;
                    }
                }
            }
            if(checked){
                times++;
                checked = !checked;
            }
        }
    }
    public static boolean isValid(int x,int y,int[][] grid){
        if(x < 0 || x >= rows || y < 0 || y >= cols){
            return false;
        }
        if(grid[x][y] == 0 || grid[x][y] == 2){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while((t--)>0){
            int n,m;
            n= sc.nextInt();
            m=sc.nextInt();
            int[][]grid = new int[n][m];
            for(int i=0;i<n;i++){
                for(int j = 0;j<m;j++){
                    grid[i][j] = sc.nextInt();
                }
            }
            int ans  = RottingOranges.rottingOranges(grid);
            System.out.println(ans);
        }
        sc.close();
    }
} 