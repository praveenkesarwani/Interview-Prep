import java.util.*;

public class Solution {

	public static void main(String[] args) {
        //take input
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int i = 0;i < E;i++){
            edges.add(new ArrayList<>());
            edges.get(i).add(sc.nextInt());
            edges.get(i).add(sc.nextInt());
            edges.get(i).add(sc.nextInt());
        }
        //sort the array based on the weight of egde
        Collections.sort(edges, new Comparator<ArrayList<Integer>>() {    
        @Override
        	public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            	return o1.get(2).compareTo(o2.get(2));
        	}               
		});
        Kruskals(V, E, edges);
	}
    
    public static void Kruskals(int V, int E, ArrayList<ArrayList<Integer>>edges){
        //make parent array and initilize it with the self value
        int[] parents = new int[V];
        for(int i = 0;i < V;i++){
            parents[i] = i;
        }
        //make output array or mstArray
        ArrayList<ArrayList<Integer>> mstArray = new ArrayList<>();
        int i = 0;
        int count = 0;
        while(count != V - 1){
        	ArrayList<Integer> edge = edges.get(i);
            int source = edge.get(0);
            int dest = edge.get(1);
            int sourceParent = findParent(source, parents);
            int destParent = findParent(dest, parents);
            if(sourceParent != destParent){		//different component 
                mstArray.add(edge);
                count++;
                parents[sourceParent] = destParent; //update parents array 
            }
            i++;
        }
        printMST(mstArray);
    }
    //find parent
    public static int findParent(int child, int[]parents){
        if(parents[child] == child){
            return child;
        }
        return findParent(parents[child],parents);
    }
    //print MST
    public static void printMST(ArrayList<ArrayList<Integer>> MST){
        for(ArrayList<Integer>edge:MST){
            if(edge.get(0) <= edge.get(1))
	            System.out.println(edge.get(0) + " " + edge.get(1) + " " + edge.get(2));
            else
	            System.out.println(edge.get(1) + " " + edge.get(0) + " " + edge.get(2));
        }
    }
    
}
