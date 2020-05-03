/*
Given a string, find the length of the longest substring
that contains at most K distinct characters.
Input:
6 3
xyyzya
Output: 5
Explanation: There are 2 substrings, 'xyyzy' and “yyzya” 
which are the longest ones having 3 distinct characters and their length is 5

*/

public class LongestSubstringWithAtMostKDistinctCharacter {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k == 0){
            return 0;
        }
        int start_window_ptr = 0;
        int end_window_ptr = 0;
        int max_window_size = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(; end_window_ptr < s.length();end_window_ptr++){
            char last_char = s.charAt(end_window_ptr);
            map.put(last_char,map.getOrDefault(last_char,0)+1);
            while(map.size() > k){ 
                char first_char = s.charAt(start_window_ptr);
                map.put(first_char, map.get(first_char) -1);
                if(map.get(first_char) == 0){
                    map.remove(first_char);
                }
                start_window_ptr++;
            }
            max_window_size = Math.max(max_window_size, end_window_ptr - start_window_ptr + 1);
        }
        return max_window_size;
    }   
}