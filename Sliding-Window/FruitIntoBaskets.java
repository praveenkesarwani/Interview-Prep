/*
Find the maximum numbers of fruits that can be collected in baskets
Input: [1,2,3,4,4,7,7,8,7,8,8,3,0]
Output: 6
*/
class FruitIntoBaskets {
    // complete the below function implementation
    public int totalFruit(int[] trees) {
                Map<Integer,Integer>map = new HashMap<>();
                int win_start = 0;
                int win_end = 0;
                int max_fruits = 0;
                int n = trees.length;
                int count = 0;
                for(;win_end < n;win_end++){
                    int last_val = trees[win_end]; 
                    map.put(last_val,map.getOrDefault(last_val,0)+1);
                    while(map.size() > 2){
                        int first_val = trees[win_start++];
                        map.put(first_val,map.get(first_val)-1);
                        if(map.get(first_val) == 0){
                            map.remove(first_val);
                        }
                        count--;
                    }
                    count++;
                    max_fruits = Math.max(max_fruits,count);
                }
                return max_fruits;
    }
}