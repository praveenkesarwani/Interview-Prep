import java.util.*;

public class TownsAndPoliceStations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < m; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            edges.get(i).add(x);
            edges.get(i).add(y);
        }
        int s = sc.nextInt();
        ArrayList<Integer> sources = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            sources.add(sc.nextInt());
        }
        ArrayList<Integer> ans = TownsAndPoliceStations.townsAndPoliceStations(n, edges, sources);
        for (int distance : ans) {
            System.out.println(distance + " ");
        }
        sc.close();
    }

    public static ArrayList<Integer> townsAndPoliceStations(int n, ArrayList<ArrayList<Integer>> edges,
            ArrayList<Integer> sources) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // convert edgelist to adjacency list
        for (int i = 0; i < edges.size(); i++) {
            int x = edges.get(i).get(0);
            int y = edges.get(i).get(1);
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i : sources) {
            distance[i] = 0;
            q.add(i);
        }
        // BFS
        while (!q.isEmpty()) {
            int top = q.remove();
            for (Integer neighbour : adj.get(top)) {
                if (distance[neighbour] == -1) {
                    distance[neighbour] = distance[top] + 1;
                    q.add(neighbour);
                }
            }
        }
        // convert this array to arrayList and return
        for (int i = 1; i <= n; i++) {
            result.add(distance[i]);
        }
        return result;
    }
}
