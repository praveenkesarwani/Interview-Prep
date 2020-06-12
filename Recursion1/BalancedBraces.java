
/*
Generate balanced brace combinations:
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
*/
import java.util.*;

public class BalancedBraces {
    ArrayList<String> balancedBraces(int n) {
        ArrayList<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(ArrayList<String> ans, String current, int open, int close, int max) {

        if (current.length() == 2 * max) {
            ans.add(current);
            return;
        }
        if (open < max) {
            backtrack(ans, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(ans, current + ")", open, close + 1, max);
        }

    }
}
