/*
Given a string, find the length of the longest substring which has 
no repeating characters.
Input:
String='aabcccbcb'

Output:
3
*/
public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>map = new HashMap<>();
        int win_start = 0;
        int win_end = 0;
        int longest_substring = 0;
        int count = 0;
        for(;win_end < s.length();win_end++){
            char end_char = s.charAt(win_end);
            while(map.containsKey(end_char)){
                char start_char = s.charAt(win_start);
                map.put(start_char,map.get(start_char)-1);
                if(map.get(start_char) == 0){
                    map.remove(start_char);
                }
                win_start++;
            }
            map.put(end_char,map.getOrDefault(end_char,0)+1);
            longest_substring = Math.max(longest_substring,map.size());
        }
        return longest_substring;
    }
}