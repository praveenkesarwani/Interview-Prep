import java.util.*;

public class Solution {
	public static int findMinVertex(int []distance,boolean[] visited,int n){
        int minVertex = -1;
        for(int i = 0;i < n;i++){
            if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }
    //dijkstra 
    public static void dijkstra(int [][]edges, int V){
        boolean []visited = new boolean[V];
        int []distance = new int[V];
        Arrays.fill(visited,false);
        Arrays.fill(distance,Integer.MAX_VALUE); //assigning distance with infinite value
        distance[0] = 0;		//starting vertex
        
        for(int i = 0;i < V - 1;i++){
            int minVertex = findMinVertex(distance,visited,V); //find the vertex that have minimum distance
            visited[minVertex] = true;
            for(int j = 0;j < V;j++){
                if(edges[minVertex][j] != 0 && !visited[j]){
                    int dist = distance[minVertex] + edges[minVertex][j]; 
                    if(dist < distance[j]){
                        distance[j] = dist;
                    }
                }
            }
        }
        print(distance,V);
    }
    //print 
    public static void print(int []distance,int n){
        for(int i = 0;i < n;i++){
            System.out.println(i + " " + distance[i]);
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); //number of vertices
		int E = sc.nextInt(); //number of edges

		int [][] edges = new int[V][V]; //Adjacency Matrix
        for(int i = 0;i < V;i++){
            for(int j = 0;j < V;j++){
                edges[i][j] = 0;        //initializing with 0
            }
        }
        
        for(int i = 0;i < E;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            edges[src][dest] = weight; //adding the weight in matrix
            edges[dest][src] = weight;
        }
        
        dijkstra(edges, V);        //call the function
	}
}