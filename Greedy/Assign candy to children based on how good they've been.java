import java.util.*;

public class CandyToKids {
    static int candyToKids(int n, ArrayList<Integer>goodness){
        //make two arrays of length n and fill it with value 1
        int []left = new int[n];
        Arrays.fill(left,1);
        int[] right = left.clone();
        //compare the goodness with left neighbours
        for(int i = 1;i < n;i++){
            if(goodness.get(i) > goodness.get(i-1)){
                left[i] = left[i-1] + 1;
            }
        }
        //compare the goodness with right neighbours
        for(int i = n - 2;i >= 0;i--){
            if(goodness.get(i) > goodness.get(i+1)){
                right[i] = right[i+1] + 1;
            }
        }
        //find the maximum element of both the arrays and add it to result
        int totalCandy = 0;
        for(int i = 0;i < n;i++){
            totalCandy += Math.max(left[i],right[i]);
        }
        return totalCandy;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>goodness = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            goodness.add(sc.nextInt());
        }
        int ans = candyToKids(n,goodness);
        System.out.print(ans);
        sc.close();
    }
}