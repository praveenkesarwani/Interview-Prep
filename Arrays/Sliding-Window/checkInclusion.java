//Given a string and a pattern, find out if the string contains any permutation of the pattern
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1);
        int n = s1.length();
        for(int i = 0;i <= s2.length() - n;i++){
            char ch = s2.charAt(i);
            String s = s2.substring(i,i+n);
            if(s.length() == s1.length()){
                if(sort(s).equals(s1)){
                    return true;
                }
            }
        }
        return false;
    }
    
    String sort(String s1){
        char[] ch = s1.toCharArray();
        Arrays.sort(ch);
        String sorted = String.valueOf(ch);
        return sorted;
    }
}