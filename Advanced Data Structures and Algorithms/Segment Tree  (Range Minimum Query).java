import java.util.*;

public class Lilliput {
    public static Vector<Integer> lilliput(int n, int heights[], int num_actions, String actions[]) {
        Vector<Integer> result = new Vector<Integer>();
        int []segmentTree = createSegmentTree(heights,n);
        constructMinimumSegementTree(segmentTree, heights, 0, n - 1, 0);
        for(int i = 0;i < num_actions;i++){
            String[] action = actions[i].split("\\s+"); //split by space
            switch(action[0]){
                case "u":
                    int index = Integer.parseInt(action[1]);
                    int val = Integer.parseInt(action[2]);
                    updateSegmentTree(segmentTree, index,val,0,n-1,0);
                    break;
                case "q":
                   int startIndex = Integer.parseInt(action[1]);
                   int endIndex = Integer.parseInt(action[2]);
                   int minHeight = rangeMinimumQuery(segmentTree, 0, n - 1, startIndex, endIndex, 0);
                   result.add(minHeight);
            }
        }
        return result;
    }
    //create segment tree based on the heights
    public static int[] createSegmentTree(int[]heights, int n){
        //Height of segment tree 
        int nextPowerOf2 = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
        //Maximum size of segment tree 
        int max_size = 2 * (int) Math.pow(2, nextPowerOf2) - 1; 
        int []segmentTree = new int[max_size];
        for(int i = 0;i < segmentTree.length;i++){
            segmentTree[i] = Integer.MAX_VALUE;
        }
        return segmentTree;
    }

    //construct Minimum SegementTree
    public static void constructMinimumSegementTree(int[]segmentTree, int[] heights,int low, int high, int pos){
        if(low == high){
            segmentTree[pos] = heights[low];
            return;
        }
        int mid = low + (high - low) / 2;
        constructMinimumSegementTree(segmentTree, heights, low, mid, 2*pos + 1);
        constructMinimumSegementTree(segmentTree, heights, mid + 1, high, 2*pos + 2);
        segmentTree[pos] = Math.min(segmentTree[2*pos + 1], segmentTree[2*pos + 2]);
    }
    //update Segment Tree
    public static void updateSegmentTree(int[] segmentTree, int index, int val, int low, int high, int pos){        
        if(index < low || index > high){
            return;
        }
        if(low == high){
            segmentTree[pos] = val;
            return;
        }
        else{
            int mid = (low + high) / 2;
            if(index >= low && index <= mid){
                updateSegmentTree(segmentTree, index, val, low, mid, 2 * pos + 1);
            }
            else{
                updateSegmentTree(segmentTree, index, val, mid + 1, high, 2 * pos + 2);
            }
            segmentTree[pos] = Math.min(segmentTree[2*pos+1], segmentTree[2*pos + 2]);
        }
        return;
    }
    //range Minimum Query
    public static int rangeMinimumQuery(int[]segmentTree,int low,int high,int startIndex,int endIndex,int pos){
        if(startIndex <= low && endIndex >= high){
            return segmentTree[pos];
        }
        if(startIndex > high || endIndex < low){
            return Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;
        return Math.min(rangeMinimumQuery(segmentTree, low, mid, startIndex, endIndex, 2 * pos + 1),
                rangeMinimumQuery(segmentTree, mid + 1, high, startIndex, endIndex, 2 * pos + 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, q;

        n = sc.nextInt();
        int heights[] = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        q = sc.nextInt(); // Num actions
        sc.nextLine();

        String actions[] = new String[q];
        for (int i = 0; i < q; i++) {
            actions[i] = sc.nextLine();
        }
        sc.close();

        Vector<Integer> answer = lilliput(n, heights, q, actions);
        for (int i = 0; i < answer.size(); i++)
            System.out.println(answer.get(i));
    }
}
