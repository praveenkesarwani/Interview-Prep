import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
        int[][] edges = new int[V][V];
        for(int i = 0;i < V;i++){
            for(int j = 0;j < V;j++){
                edges[i][j] = 0;
            }
        }
        
        for(int i = 0;i < E;i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();
            edges[v1][v2] = weight;
            edges[v2][v1] = weight;
        }
        
        Prims(edges,V);
	}
    //Prims
    public static void Prims(int[][]edges, int n){
        boolean[]visited = new boolean[n];
        int []weight = new int[n];
        int []parent = new int[n];
        Arrays.fill(visited,false);
        Arrays.fill(weight,Integer.MAX_VALUE);
        
        weight[0] = 0;
        parent[0] = -1;
        for(int i = 0;i < n - 1;i++){
            //find min vertex
            int minVertex = findMinVertex(weight,visited,n);
            visited[minVertex] = true;
            //Explore unvisited neighbours
            for(int j = 0;j < n;j++){
                if(edges[minVertex][j] != 0 && !visited[j]){
                    if(edges[minVertex][j] < weight[j]){
                        weight[j] = edges[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }
        print(weight,parent,n);
    }
    //find min vertex
    public static int findMinVertex(int []weight,boolean[]visited, int n){
    	int minVertex = -1;
        for(int i = 0;i < n;i++){
            if(!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }
    //print
    public static void print(int[]weight,int[]parent,int n){
        for(int i = 1;i < n;i++){
            if(parent[i] < i){
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            } else{
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
        }
    }
}