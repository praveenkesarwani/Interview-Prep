import java.util.*;

class NetworkDelayTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> b = new ArrayList<>();

            b.add(sc.nextInt());
            b.add(sc.nextInt());
            b.add(sc.nextInt());
            edges.add(b);
        }

        int k = sc.nextInt();

        int ans = NetworkDelayTime.networkDelayTime(n, edges, k);

        System.out.println(ans);
    }
    //Solve this function
    public static int networkDelayTime(int n, ArrayList<ArrayList<Integer>> edges, int k) {
        int [][]adjMatrix = new int[n + 1][n + 1];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= n;j++){
                adjMatrix[i][j] = -1;
            }
        }
        //convert edgelist to adj matrix
        int num_connections = edges.size();
        for(int i = 0;i < num_connections;i++){
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int w = edges.get(i).get(2);
            adjMatrix[u][v] = adjMatrix[u][v] == -1 ? w : Math.min(w,adjMatrix[u][v]); // edges -> 1 2 100, 1 2 50
        }
        int result = dijkstra(adjMatrix,n,k);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    //dijkstra
    public static int dijkstra(int[][]adjMatrix,int n,int k){
        int []distance = new int[n+1];
        boolean []visited = new boolean[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        Arrays.fill(visited,false);

        distance[k] = 0;

        for(int i = 0;i < n;i++){
            int minVertex = findMinVertex(distance, visited, n);
            visited[minVertex] = true;
            for(int j = 1;j <= n;j++){
                if(!visited[j] && adjMatrix[minVertex][j] != -1){
                    int dist = distance[minVertex] + adjMatrix[minVertex][j];
                    if(dist < distance[j]){
                        distance[j] = dist;
                    }
                }
            }
        }

        //find maximum from distance
        int maxTime = Integer.MIN_VALUE;
        for(int i = 1;i <= n;i++){
            if(distance[i] > maxTime){
                maxTime = distance[i];
            }
        }
        return maxTime;
    }
    //Minvertex
    public static int findMinVertex(int[]distance, boolean[]visited, int n){
        int minVertex = -1;
        for(int i = 0;i <= n;i++){
            if(!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])){
                minVertex = i;
            }
        }
        return minVertex;
    }
}