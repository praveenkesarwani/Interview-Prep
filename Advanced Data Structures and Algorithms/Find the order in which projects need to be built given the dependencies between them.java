import java.util.*;

public class BuildOrder {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int d = sc.nextInt();
        
        sc.nextLine();
        ArrayList<String> project = new ArrayList<>();
        for(String val:sc.nextLine().split(" ")){
            // System.out.print(val+" ");
            project.add(val);
        }
        
        ArrayList<ArrayList<String> > dependencies = new ArrayList<>();
        for(int i=0;i<d;i++){
            ArrayList<String> dependency = new ArrayList<>();
            for(String dep:sc.nextLine().split(" ")){
                dependency.add(dep);
            }
            dependencies.add(dependency);
        }
        ArrayList<String> ans = buildOrder(project,dependencies);

        for(String proj:ans){
            System.out.print(proj+" ");
        }
        sc.close();
    }
    /*
    ----------------------------------------------------solve the below function------------------------------------------
    */
    public static ArrayList<String> buildOrder(ArrayList<String> projects,ArrayList<ArrayList<String> > dependencies){
        int N = projects.size();
        int D = dependencies.size();
        ArrayList<String> result = new ArrayList<>();
        HashMap<String,Integer>indegree = new HashMap<>(); //indegree hashmap
        HashMap<String,List<String>>adj = new HashMap<>(); //adj list

        for(int i = 0;i < N;i++){
            String project = projects.get(i);
            indegree.put(project,0);            //initialize with 0 value
            adj.put(project, new ArrayList<>());//intilialize with empty list
        }

        for(int i = 0;i < D;i++){
            String P = dependencies.get(i).get(0);
            String Q = dependencies.get(i).get(1);
            adj.get(P).add(Q);                      //add in adj list
            indegree.put(Q,indegree.get(Q)+1);      //increment the indegree of neighbour
        }

        Queue<String> q = new LinkedList<>();
        for(Map.Entry<String,Integer> entry:indegree.entrySet()){
            if(entry.getValue() == 0){              //add those vertex which have 0 indegree
                q.add(entry.getKey());
            }
        }

        while(!q.isEmpty()){
            String frontProject = q.poll();
            result.add(frontProject);
            for(String neighbour:adj.get(frontProject)){
                indegree.put(neighbour,indegree.get(neighbour) - 1);
                if(indegree.get(neighbour) == 0){
                    q.add(neighbour);
                }
            }
        }
        ArrayList<String> notPosibble = new ArrayList<>(); //when there is a cycle in a graph
        notPosibble.add("-1");
        return result.size() == N ? result : notPosibble;
    }
}
