//Idea is to use directed graph. If there is a node which has zero neighbour and it is everyone's neighbour
//then that's the answer
//Solution I:
class Solution {
    public int findJudge(int N, int[][] trust) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= N;i++){
            adj.add(new ArrayList<Integer>());
        }
        //convert trust to adjacency list
        for(int i = 0; i < trust.length;i++){
            int x = trust[i][0];
            int y = trust[i][1];
            adj.get(x).add(y);
        }
        
        ArrayList<Integer> judge = new ArrayList<>();
        for(int i = 1;i <= N;i++){
            if(adj.get(i).size() == 0)
                judge.add(i);
        }
        //violates the 3rd condition
        if(judge.size() != 1)
            return -1;
        
        for(int i = 1;i <= N;i++){
            if(i == judge.get(0))
                continue;
            if(!findJudge(i, adj, judge.get(0)))
                return -1;
        }
        return judge.get(0);
    }
    
    boolean findJudge(int i , ArrayList<ArrayList<Integer>>adj, int target){
        for(Integer j:adj.get(i)){
            if(j == target)
                return true;
        }
        return false;
    }
}

//Solution II:
class Solution{
    public int findJudge(int N, int[][] trust){
        int []count = new int[N + 1];
        for(int[] i: trust){
            count[i[0]]--;
            count[i[1]]++;
        }
        for(int i = 1;i <= N;i++)
            if(count[i] == N - 1)
                return i;
        return -1;
    }
}