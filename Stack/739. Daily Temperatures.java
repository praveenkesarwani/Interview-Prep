class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int []res = new int[T.length];
        for(int i = 0;i < T.length;i++){
            while(!stack.empty() && T[i] > T[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}