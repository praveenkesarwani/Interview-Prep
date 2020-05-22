import java.util.*;

public class PalindromePartitioning {
    ArrayList<ArrayList<String> > palindromePartitioning(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if(s.length() == 0){
            return res;
        }
        helper(res,new ArrayList<>(), s, 0);
        return res;
    }

    private void helper(ArrayList<ArrayList<String>> res,ArrayList<String>curr,
            String s,int low){
        if(low == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        int n = s.length();
        for(int high = low;high < n;high++){
            if(isPalndrome(s,low,high)){
                curr.add(s.substring(low,high+1));
                helper(res,curr,s , high + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    private boolean isPalndrome(String s,int low ,int high){
        if(low >= high){
            return true;
        }
        if(s.charAt(low) != s.charAt(high)){
            return false;
        }
        return isPalndrome(s,low + 1, high - 1);
    }
}
