import java.util.*;
import java.io.*;
class WallsAndGates {
	public static int[][] WallsAndGates(int [][] grid , int n, int m) {
        int [][]distance = new int[n][m];
        for(int []row:distance){   //Initialize every cell with -1
            Arrays.fill(row,Integer.MAX_VALUE);
        }
		Queue<Integer>q = new LinkedList<>();
		for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				if(grid[i][j] == 0){
					q.add(i * m + j);
					distance[i][j] = 0;
				}
				else if(grid[i][j] == -1){
					distance[i][j] = -1;
				}
			}
		}
		//BFS Traversal
		int []dir = {-1,0,1,0,-1}; 
		while(!q.isEmpty()){
			int top = q.remove();
			int topX = top / m;
			int topY = top % m;
			int topDistance = distance[topX][topY];
			for(int i = 0;i < 4; i++){ //run a loop for 4 direction
				int x = topX + dir[i];
				int y = topY + dir[i + 1];
				if(isValid(grid,distance,x,y)){
					distance[x][y] = topDistance + 1;
					q.add(x * m + y);
				}
			}
		}
		return distance;
	}
	//check valid position
	public static boolean isValid(int[][]grid,int[][]distance,int i,int j){
		if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == Integer.MAX_VALUE && distance[i][j] == Integer.MAX_VALUE){
			return true;
		}
		return false;
	}
	public static void main(String []args) {
		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int [][] grid = new int[n + 1][m + 1];
		for ( int i = 0; i < n; i++) {
			for ( int j = 0; j < m; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		int [][] distance = WallsAndGates(grid, n, m);
		for ( int i = 0; i < n; i++) {
			for ( int j = 0; j < m; j++) {
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
	}
}
