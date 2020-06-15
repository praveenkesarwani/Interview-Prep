import java.util.*;

public class CheapestFlights {

    public static int cheapestFlights(int n, ArrayList<ArrayList<Integer>>flight, int source, int des, int k){
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        for(ArrayList<Integer> f : flight){
            map.computeIfAbsent(f.get(0),m->new HashMap<>()).put(f.get(1),f.get(2));
        }
        PriorityQueue<ArrayList<Integer>> minHeap = new PriorityQueue<>((x,y)->x.get(0)-y.get(0));
        ArrayList<Integer>first = new ArrayList<>();
        first.add(0);
        first.add(source);
        first.add(k+1);
        minHeap.add(first);
        while(!minHeap.isEmpty()){
            ArrayList<Integer> cur = minHeap.poll();
            int price = cur.get(0), city = cur.get(1), stop = cur.get(2);
            if(stop < 0) continue;
            if(city==des) return price;
            Map<Integer,Integer> next = map.getOrDefault(city,new HashMap<>());
            for(Map.Entry<Integer,Integer> entry : next.entrySet()){
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(price + entry.getValue());
                arr.add(entry.getKey());
                arr.add(stop-1);
                minHeap.add(arr);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>>flight = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < e; i++) {
            flight.add(new ArrayList<Integer>());
            flight.get(i).add(sc.nextInt());
            flight.get(i).add(sc.nextInt());
            flight.get(i).add(sc.nextInt());
        }
        int source = sc.nextInt();
        int des = sc.nextInt();
        int k = sc.nextInt();
        int ans = cheapestFlights(n,flight,source,des,k);
        System.out.print(ans);
        sc.close();
    }
}