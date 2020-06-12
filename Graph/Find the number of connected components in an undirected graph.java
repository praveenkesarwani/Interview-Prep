import java.util.*;

public class ConnectedComponentsInGraph {
    boolean[] visited;
    ArrayList<ArrayList<Integer>>adj;
    int connectedComponentsInGraph(int n,  ArrayList<ArrayList<Integer>> edges) {
        adj = new ArrayList<>();
        visited = new boolean[n+1];
        Arrays.fill(visited,false);
        for(int i = 0;i <= n;i++){
            adj.add(new  ArrayList<>());
        }
        for(int i = 0;i < edges.size();i++){
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }

        int no_of_conn_comonents = 0;
        for(int i = 1;i <= n;i++){
            if(!visited[i]){
                no_of_conn_comonents++;
                DFS(i);
            }
        }
        return no_of_conn_comonents;
    }
    //BFS Traversal
    // void BFS(int i){
    //     visited[i] = true;
    //     Queue<Integer>queue = new LinkedList<>();
    //     queue.add(i);
    //     while(!queue.isEmpty()){
    //         int top = queue.poll();
    //         for(Integer j:adj.get(top)){
    //             if(!visited[j]){
    //                 visited[j] = true;
    //                 queue.add(j);
    //             }
    //         }
    //     }
    // }

    //DFS Traversal
    void DFS(int source){
        visited[source] = true;
        for(int i = 0; i < adj.get(source).size();i++){
            int neighbour = adj.get(source).get(i);
            if(!visited[neighbour])
                DFS(neighbour);
        }
        return;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
    
        for(int i=0;i<m;i++){
            edges.add(new ArrayList<Integer>());
            edges.get(i).add(scanner.nextInt());
            edges.get(i).add(scanner.nextInt());
        }
        ConnectedComponentsInGraph answer = new ConnectedComponentsInGraph();
        int result = answer.connectedComponentsInGraph(n, edges);
        System.out.println(result);
        scanner.close();
    }
}
