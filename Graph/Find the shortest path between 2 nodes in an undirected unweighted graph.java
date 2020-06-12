import java.util.*;
import java.io.*;

class ShortestPath{
    public static int n;
    public static int m;

    public static List<Integer> shortestPath(int n,ArrayList<ArrayList<Integer>> edges,int source,int destination){
        //Adj = adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i < n + 1;i++){
            adj.add(new ArrayList<Integer>());
        }

        //convert edgeList to adjacency list
        for(int i = 0;i < m;i++){
            int x = edges.get(i).get(0);
            int y = edges.get(i).get(1);
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        int []level = new int[n + 1]; //to store the level of evrey vertex
        //BFS Traversal
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        level[source] = 1;
        while(!queue.isEmpty()){
            int top = queue.poll();
            for(Integer i:adj.get(top)){
                if(level[i] == 0){
                    level[i] = level[top] + 1;
                    queue.offer(i);
                }
            }
        }
        //find shortest path from destination to source
        List<Integer>ans = new ArrayList<>();
        ans.add(destination);
        int currentNode = destination;
        for(int i = 0;i < level[destination];i++){
            for(Integer j: adj.get(currentNode)){
                if(level[j] == level[currentNode] - 1){
                    ans.add(j);
                    currentNode = j;
                    break;
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<m;i++){
            edges.add(new ArrayList<Integer>());
            edges.get(i).add(sc.nextInt());
            edges.get(i).add(sc.nextInt());
        }

        int source,destination;
        source = sc.nextInt();
        destination = sc.nextInt();


        List<Integer> ans = ShortestPath.shortestPath(n,edges,source,destination);

        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }

    }
}
