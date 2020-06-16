class Solution {
    //topological sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Integer> indegree = new HashMap<>();
        HashMap<Integer,List<Integer>>adj_list = new HashMap<>();
        for(int i = 0;i < numCourses;i++){
            indegree.put(i,0);
            adj_list.put(i,new ArrayList<>());
        }

        for(int i = 0;i < prerequisites.length;i++){
            int p = prerequisites[i][0];
            int q = prerequisites[i][1];
            adj_list.get(q).add(p);
            indegree.put(p,indegree.get(p) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry:indegree.entrySet()){
            if(entry.getValue() == 0){
                q.add(entry.getKey());
            }
        }
        
        int countNodes = 0;
        while(!q.isEmpty()){
            int top = q.remove();
            countNodes++;
            for(Integer neighbour:adj_list.get(top)){
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if(indegree.get(neighbour) == 0){
                    q.add(neighbour);
                }
            }
        }

        return countNodes == numCourses;
    }
}