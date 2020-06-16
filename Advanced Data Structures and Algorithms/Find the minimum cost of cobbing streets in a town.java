import java.util.*;
public class CobbledStreets {
    public static int cobbledStreets(int n, ArrayList<ArrayList<Integer>> street, int p){
        //sort the array based on the weight of egde
        Collections.sort(street, new Comparator<ArrayList<Integer>>() {    
        @Override
        	public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            	return o1.get(2).compareTo(o2.get(2));
        	}               
		});

        int[] parent = new int[n + 1];
        for(int i = 0;i <= n;i++){
            parent[i] = i;
        }

        int minLenght = 0;
        int e = 0;
        int i = 0;
        while(e != n - 1){
            ArrayList<Integer> edge = street.get(i);
            int building1 = edge.get(0);
            int building2 = edge.get(1);
            int building1Parent = findParent(building1, parent);
            int building2Parent = findParent(building2, parent);
            if(building1Parent != building2Parent){
                minLenght += edge.get(2);
                parent[building1Parent] = building2Parent;
                e++;
            }
            i++;
        }
        return p * minLenght;
    }
    //union-find algorithm to detect cycle
    public static int findParent(int i,int[]parent) {
        if(parent[i] == i){
            return i;
        }
        return findParent(parent[i], parent);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,e,t,p;
        t = sc.nextInt();
        while(t>0){
            t--;
            p = sc.nextInt();
            n = sc.nextInt();
            e = sc.nextInt();
            ArrayList<ArrayList<Integer>>street = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < e; i++) {
                street.add(new ArrayList<Integer>());
                street.get(i).add(sc.nextInt());
                street.get(i).add(sc.nextInt());
                street.get(i).add(sc.nextInt());
            }
            int ans = cobbledStreets(n,street,p);
            System.out.println(ans);
        }
        sc.close();
    }
}
