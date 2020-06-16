import java.util.*;

class TopologicalOrdering{
    /*
    ------------------------------------------------------------------------
    |                        Method 1                                      |
    ------------------------------------------------------------------------
    */
	private static Vector<Integer> topologicalOrdering(int n,Vector<Vector<Integer> > edges)
	{
		Vector<Integer> result = new Vector<>();

		HashMap<Integer,Integer> in_degree = new HashMap<>();
		HashMap<Integer,List<Integer>>adj_list = new HashMap<>();
		for(int i = 1;i <= n;i++){
			in_degree.put(i,0);
			adj_list.put(i,new ArrayList<Integer>());
		}
		//convert edgelist to adjacency list + insert indegrees of nodes in in_degree map
		for(int i = 0;i < edges.size();i++){
			int node = edges.get(i).get(0);
			int neighbour = edges.get(i).get(1);
			adj_list.get(node).add(neighbour);
			in_degree.put(neighbour,in_degree.get(neighbour) + 1);
		}

		//Add those nodes which have 0 indegree
		Queue<Integer> source = new LinkedList<>();
		for(Map.Entry<Integer,Integer> entry:in_degree.entrySet()){
			if(entry.getValue() == 0){
				source.offer(entry.getKey());
			}
		}
        //there is a node having 0 indegree
		while(!source.isEmpty()){
			int frontNode = source.poll();
			result.add(frontNode);
			for(Integer neighbour:adj_list.get(frontNode)){
				in_degree.put(neighbour, in_degree.get(neighbour) - 1);
				if(in_degree.get(neighbour) == 0){
					source.offer(neighbour);
				}
			}
		}
        //if there a cycle in graph return empty list
		return result.size() == n ? result : new Vector<Integer>();
    }

    /*
    ------------------------------------------------------------------------
    |                        Method 2                                      |
    ------------------------------------------------------------------------
    */
    /*
    private static Vector<Integer> topologicalOrdering(int n,Vector<Vector<Integer> > edges)
    {
		//adjacency list
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0;i <= n;i++){
			adj.add(new ArrayList<Integer>());
		}
		//convert edgelist to adjacency list
		for(int i = 0;i < edges.size();i++){
			adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
		}

		Vector<Integer>result = DFS(n, adj);
		return result;
	}
	//DFS
	public static Vector<Integer> DFS(int n, ArrayList<ArrayList<Integer>> adj){
		boolean []visited = new boolean[n + 1];
		Arrays.fill(visited, false);

		Stack<Integer> stack = new Stack<>();
		for(int i = 1;i <= n;i++){	
			if(!visited[i]){
				topologicalSort(i,adj,visited,stack);
			}
		}
		Vector<Integer> result = new Vector<>();
		while(!stack.empty()){
			result.add(stack.pop());
		}
		return result;
	}
	//topological sort
	public static void topologicalSort(int v, ArrayList<ArrayList<Integer>>adj,boolean[]visited,Stack<Integer>stack){
		visited[v] = true;
		for(Integer neighbour:adj.get(v)){
			if(!visited[neighbour]){
				topologicalSort(neighbour,adj,visited,stack);
			}
		}
		stack.push(new Integer(v));
    }
    */
    //------------------------------------------------------------------------------//


    
	//main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int e = sc.nextInt();
		Vector<Vector<Integer> > edges = new Vector<Vector<Integer> >();
		for(int i=0;i<e;i++)
		{
			int u=sc.nextInt();
			int v=sc.nextInt();
			Vector<Integer> edge = new Vector<Integer>();
			edge.add(u);
			edge.add(v);
			edges.add(edge);
		}
		Vector<Integer> answer = topologicalOrdering(n,edges);
		for(int elem : answer)
			System.out.print(elem+" ");
	}
}
