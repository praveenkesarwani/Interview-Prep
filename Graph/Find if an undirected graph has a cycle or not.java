import java.util.*;
import java.io.*;

class DetectCycle {

	public static String detectCycle(int n, ArrayList<ArrayList<Integer>> edges) {
		ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i <=n ;i++){
            adj.add(new ArrayList<Integer>());
        }
        //convert edgeList to adjancenyList
        for(int i = 0;i < edges.size(); i++){
            int x = edges.get(i).get(0);
            int y = edges.get(i).get(1);
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        //array with 3 flag values -1,0,-1
        //-1 -> not visited ,0 -> visited ,1 -> traversed
        int []visited = new int[n + 1];
        for(int i = 0; i <= n;i++){
            visited[i] = -1;
        }
        //To handle disconnected graph also
        for(int i = 1; i <= n;i++){
            if(visited[i] == -1)
                if(detectCycle_BFS(n,adj,i,visited)){
                    return "Yes";
            }
        }
        return "No";
    }
    //BFS Traversal
    public static boolean detectCycle_BFS(int n, ArrayList<ArrayList<Integer>> adj, int currNode, int[] visited){
        Queue<Integer>q = new LinkedList<>();
        q.offer(currNode);
        visited[currNode] = 0; //Inserted into queue
        while(!q.isEmpty()){
            int top = q.poll();
            visited[top] = 1; //Removed from queue
            for(Integer i:adj.get(top)){
                if(visited[i] == 0) //Means node is already in the queue and it is an adjacent of another vertex.
                    return true;
                else if(visited[i] == -1){
                    q.offer(i);
                    visited[i] = 0;
                }
            }
        }
        return false;
    }

    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		while ((t--) > 0) {
			int nodes = sc.nextInt();
			int e = sc.nextInt();
			ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
			for (int i = 0; i < e; i++) {
				ArrayList<Integer> b = new ArrayList<Integer>();
				b.add(sc.nextInt());
				b.add(sc.nextInt());
				edges.add(b);
			}
			String ans = DetectCycle.detectCycle(nodes, edges);
			System.out.println(ans);
		}
	}
}
