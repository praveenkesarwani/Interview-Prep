/*
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
Note: There could be self loops.
Note: This is a directed graph.
*/
import java.util.*;

public class RouteBetweenNodes {
    boolean result;
    int visited[];
    boolean routeBetweenNodes(int source , int destination ,int n,  ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n;i++){
            graph.add(new ArrayList<Integer>());
        }
        int num_edges = edges.size();
        for(int i = 0;i < num_edges;i++){
            //convert edgelist to adjacency list
            int x = edges.get(i).get(0);
            int y = edges.get(i).get(1);
            graph.get(x).add(y);
        }
        init(n);
        result = false;
        isPath(source,destination,graph);
        return result;
    }
    
    void init(int n){
        this.visited = new int[n + 1];
        for(int i = 0;i <= n;i++){
            this.visited[i]  = 0;
        }
    }

    //DFS Traversal
    void isPath(int source, int destination, ArrayList<ArrayList<Integer>> graph){
        this.visited[source] = 1;
        for(int i = 0; i < graph.get(source).size();i++){
            int node = graph.get(source).get(i);
            if(node == destination){
                this.result = true;
                return;
            }
            if(visited[node] == 0){
                isPath(node,destination,graph); // DFS
            } //can check for success and return if we result == true
        }
        return;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int p = 0 ; p < t ; p++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        
            for(int i=0;i<m;i++){
                edges.add(new ArrayList<Integer>());
                edges.get(i).add(scanner.nextInt());
                edges.get(i).add(scanner.nextInt());
            }
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            RouteBetweenNodes answer = new RouteBetweenNodes();
            boolean ans = answer.routeBetweenNodes(src, dest,n,edges);
            if (ans) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        scanner.close();
    }
}
