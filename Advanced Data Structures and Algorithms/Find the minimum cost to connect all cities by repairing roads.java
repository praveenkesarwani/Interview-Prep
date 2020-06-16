import java.util.*;
public class MinCostOfRoad {
    public static int minCostOfRoad(int n, ArrayList<ArrayList<Integer>> edges){
        //Applied Kruskals Algorithm
        //Sort all the edges in non-decreasing order of their weight.
        Collections.sort(edges, new Comparator<ArrayList<Integer>>() {    
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(2).compareTo(o2.get(2));
            }               
        });
        //create a parent array and fill it with the self value
        int []parent = new int[n + 1];
        for(int i = 0;i <= n;i++){
            parent[i] = i;
        }

        ArrayList<ArrayList<Integer>> mst = new ArrayList<>();
        int minCost = 0;
        int i = 0;
        int countEdges = 0;
        //Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far. 
        //If cycle is not formed, include this edge. Else, discard it.
        while(countEdges != n - 1){
            ArrayList<Integer>edge = edges.get(i);
            int source = edge.get(0);
            int dest = edge.get(1);
            int weight = edge.get(2);
            int sourceParent = findParent(source, parent);
            int destParent = findParent(dest, parent);
            if(sourceParent != destParent){
                mst.add(edge);
                countEdges++;
                minCost += weight;
                parent[sourceParent] = destParent;
            }
            i++;
        }
        return minCost;
    }
    //union-find algorithm to detect cycle 
    public static int findParent(int child, int[]parent){
        if(parent[child] == child){
            return child;
        }
        return findParent(parent[child], parent);
    }
    //main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,e;
        n = sc.nextInt();
        e = sc.nextInt();
        ArrayList<ArrayList<Integer>>edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < e; i++) {
            edges.add(new ArrayList<Integer>());
            edges.get(i).add(sc.nextInt());
            edges.get(i).add(sc.nextInt());
            edges.get(i).add(sc.nextInt());
        }
        int ans = minCostOfRoad(n,edges);
        System.out.print(ans);
        sc.close();
    }
}
