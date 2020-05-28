/*
Given a string S which consists of both lowercase and uppercase alphabetical letters, 
you have to write a function to check if string S is a permutation of a palindrome or not. 
Note: Characters are case sensitive i.e. ‘a’ is not the same as ‘A’.
*/
import java.io.*;
import java.util.*;
import java.lang.Math;

public class PermutationPalindrome {

    public static int isPermutationPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        // if size of string is odd there would be a character which will occur odd number of times
        // otherwise every character will occur even number of times
        int oddCount = 0;
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char it : freq.keySet()) {
            int x = freq.get(it);
            if (x % 2 != 0)
                oddCount++;
        }
        if (oddCount > 1)
            return 0;
        return 1;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = 1;
        t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            t--;
            String s = new String();
            s = sc.next();

            int flag = isPermutationPalindrome(s);
            if (flag == 1) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

}
