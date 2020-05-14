
//Towers of Hanoi
import java.util.*;

public class TowerOfHanoi {
    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println(n + " " + source + " " + destination);
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        towerOfHanoi(n, 'A', 'B', 'C');
    }
}
/*
Time Complexity: O(2^N)
Space Complexity: O(N)
*/