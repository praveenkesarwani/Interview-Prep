/*
Given a sorted array of strings that is interspersed with empty strings, 
find the location of a given string
*/
class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c : T.toCharArray()) {
            ++count[c - 'a'];
        } // count each char in T.
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            } // sort chars both in T and S by the order of S.
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            } // group chars in T but not in S.
        }
        return sb.toString();
    }
}