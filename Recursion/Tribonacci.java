
/*
*The Tribonacci sequence Tn is defined as follows:
*T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
*Overall the sequence looks like this - 0, 1, 1, 2, 4, 7, 13, 24, 44, 81 …
*Given n, return the value of Tn.
*/
import java.util.*;

class Tribonacci {
    int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }
}

/*
Time Complexity: O(3^N)
Space Complexity: O(N)
*/