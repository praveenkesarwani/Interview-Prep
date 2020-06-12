import java.util.*;

class DiameterOfTree{
    // Utility Pair class for storing maximum distance & Farthest Node 
	private static class Pair<T,V>{
		T first;
		V second;
		Pair(T first,V second){
			this.first = first;
			this.second = second;
		}
    }
    
	private static int diameterOfTree(int n,Vector<Vector<Integer> > edges)
	{
		//Initializing Adjacency List
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0;i <= n ;i++){
			adj.add(new ArrayList<>());
		}
		//Convert edgelist to adj list
		for(int i = 0;i < edges.size();i++){
			int x = edges.get(i).get(0);
			int y = edges.get(i).get(1);
			adj.get(x).add(y);
			adj.get(y).add(x);
		}
        // first bfs to find one end point of longest path 
        Pair<Integer,Integer> node1 = BFS(1, n, adj);
        //second bfs to find actual longest path 
		Pair<Integer,Integer> node2 = BFS(node1.first, n, adj);
		return node2.second;
	}
	// method returns farthest node and its distance from node u
    public static Pair<Integer,Integer> BFS(int u ,int n, ArrayList<ArrayList<Integer>>adj){
        int []distance = new int[n + 1];
        // mark all distance with -1
		Arrays.fill(distance, -1);
        Queue<Integer> q = new LinkedList<>();
		q.add(u);
        // distance of u from u will be 0
		distance[u] = 0;
		while(!q.isEmpty()){
			int top = q.remove();
			for(Integer neighbour:adj.get(top)){           // push node into queue only if it is not visited already
				if(distance[neighbour] == -1){
					distance[neighbour] = distance[top] + 1;   // make distance of neighbour, one more than distance of top
					q.add(neighbour);
				}
			}
		}

		int nodeIndex = 0;
		int maxDistance = 0;
		for(int i = 1;i <= n;i++){
			if(distance[i] > maxDistance){
				maxDistance = distance[i];
				nodeIndex = i;
			}
		}
		return new Pair<Integer,Integer>(nodeIndex,maxDistance);
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int t= sc.nextInt();
		for(int test=0;test<t;test++)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			Vector<Vector<Integer> > edges = new Vector<Vector<Integer> >();
			for(int i=0;i<m;i++)
			{
				int u=sc.nextInt();
				int v=sc.nextInt();
				Vector<Integer> edge = new Vector<Integer>();
				edge.add(u);
				edge.add(v);
				edges.add(edge);
			}
			System.out.println(diameterOfTree(n,edges));
		}
	}
}
