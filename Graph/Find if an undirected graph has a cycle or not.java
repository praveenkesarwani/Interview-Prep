import java.util.*;
import java.io.*;

class DetectCycle {

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
    //-------------------------------------------------------------------------------------------------- 
    //---------------------------------------topological sort-------------------------------------------
	public static String detectCycle(int nodes, ArrayList<ArrayList<Integer>> edges) {
		HashMap<Integer,List<Integer>> adj = new HashMap<>();
		HashMap<Integer,Integer> inDegree = new HashMap<>();
		for(int i = 1;i <= nodes;i++){
			adj.put(i,new ArrayList<Integer>());
			inDegree.put(i,0);
		}
		for(int i = 0;i < edges.size();i++){
			int u = edges.get(i).get(0);
			int v = edges.get(i).get(1);
			adj.get(u).add(v);
			adj.get(v).add(u);
			inDegree.put(u,inDegree.get(u) + 1);
			inDegree.put(v,inDegree.get(v) + 1);
		}
		//insert nodes in queue which indegree of 1 || 0  
		Queue<Integer> q = new LinkedList<>();
		for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()){
			if(entry.getValue() == 1 || entry.getValue() == 0){
				q.add(entry.getKey());
			}
		}
		int count = 0;
		while(!q.isEmpty()){
			int top = q.poll();
			count++;
			inDegree.put(top,inDegree.get(top) - 1);
			for(Integer neighbour : adj.get(top)){
				inDegree.put(neighbour,inDegree.get(neighbour) - 1);
				if(inDegree.get(neighbour) == 1){
					q.add(neighbour);
				}
			}
		}
		return count == nodes ? "No" : "Yes";
	}
}
//----------------------------------------BFS----------------------------------------------
//-----------------------------------------------------------------------------------------


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
        //To handle disconnected graph
        for(int i = 1; i <= n;i++){
            if(visited[i] == -1){
                if(detectCycle_BFS(adj,i,visited)){
                    return "Yes";
            	}
			}
        }
        return "No";
    }
    //BFS Traversal
    public static boolean detectCycle_BFS(ArrayList<ArrayList<Integer>> adj, int j, int[] visited){
        Queue<Integer>q = new LinkedList<>();
        q.offer(j);
        visited[j] = 0; //Inserted into queue
        while(!q.isEmpty()){
            int top = q.poll();
            visited[top] = 1; //Removed from queue
            for(Integer i:adj.get(top)){
                if(visited[i] == 0)
                    return true;
                else if(visited[i] == -1){
                    q.offer(i);
                    visited[i] = 0;
                }
            }
        }
        return false;
    }
