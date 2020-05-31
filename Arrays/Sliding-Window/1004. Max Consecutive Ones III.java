class Solution {
    public int longestOnes(int[] A, int k) {
        int start_win = 0,end_win = 0;
        int count = 0;
        int max_size = Integer.MIN_VALUE;
        for(;end_win < A.length; end_win++){
            if(A[end_win] == 0)
                count++;
            while(A[end_win] == 0 && count > k){
                if(A[start_win++] == 0)
                    count--;
            }
            max_size = Math.max(max_size,end_win - start_win + 1);
        }
        return max_size;
    }
}