
/*
Given a string and a pattern, find all the starting
indices of the pattern’s anagrams in the given string.
Note: Anagrams mean permutations of the string
Input:
bacdgabcda abcd
Output:
3
0 5 6
*/
class Solution {
    public static Map<Character,Integer> createMap(String p){
        Map<Character,Integer>map = new HashMap<>();
        for(char ch:p.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        return map;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character,Integer> map = createMap(p);
        int win_start = 0,win_end = 0, matched_char = 0;
        for(;win_end < s.length();win_end++){
            char end_char = s.charAt(win_end);
            if(map.containsKey(end_char)){
                map.put(end_char,map.get(end_char)-1);
                if(map.get(end_char) == 0){
                    matched_char++;
                }
            }
            if(matched_char == map.size()){
                ans.add(win_start);
            }
            if(win_end >= p.length() - 1){
                char start_char = s.charAt(win_start++);
                if(map.containsKey(start_char)){
                    if(map.get(start_char) == 0){
                        matched_char--;
                    }
                    map.put(start_char,map.get(start_char)+1);
                }
            }
        }
        return ans;
    }
}