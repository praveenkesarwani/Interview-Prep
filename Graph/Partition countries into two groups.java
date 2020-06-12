import java.util.*;
class PossibleBipartition {
	private static String possibleBipartition(int n, Vector<Vector<Integer> > edges) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0;i <= n;i++){
			adj.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < edges.size();i++){
			int x = edges.get(i).get(0);
			int y = edges.get(i).get(1);
			adj.get(x).add(y);
			adj.get(y).add(x);
		}

		int []color = new int[n + 1];
		for(int i = 0;i <= n;i++){
			color[i] = -1;
        }
        //call BFS function
		for(int i = 1;i <= n;i++){
			if(color[i] == -1){
				if(!BFS(i, color, adj)){
					return "Not Possible";
				}
			}
		}
		return "Possible";
	}
    //BFS Traversal
	public static boolean BFS(int pos, int[]color, ArrayList<ArrayList<Integer>> adj){
		Queue<Integer> q = new LinkedList<>();
		color[pos] = 0;
		q.offer(pos);
		while(!q.isEmpty()){
			int top = q.poll();
			int colorOfTop = color[top]; //0 or 1
			for(Integer neighbour: adj.get(top)){
				if(color[neighbour] == colorOfTop){ 
					return false;
				}
				if(color[neighbour] == -1){
					color[neighbour] = colorOfTop == 0 ? 1 : 0;
					q.offer(neighbour);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tests = 0; tests < t; tests++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			Vector<Vector<Integer> > edges = new Vector<Vector<Integer> >();
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				Vector<Integer> edge = new Vector<Integer>();
				edge.add(u);
				edge.add(v);
				edges.add(edge);
			}
			System.out.println(possibleBipartition(n, edges));
		}

	}
}
