/*
You are given two numbers a and b. 
You have to find the remainder when a is divided by b using recursion. 
If remainder is not possible then return -1.
Note: You cannot use the Modulo (%) operator.
*/
import java.util.*;

public class ModuloUsingRecursion {
    int moduloUsingRecursion(int dividend, int divisor) {
        if (divisor == 0) {
            return -1;
        }
        if (dividend < divisor) {
            return dividend;
        }
        return moduloUsingRecursion(dividend - divisor, divisor);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend = scanner.nextInt();
        int divisor = scanner.nextInt();
        int result = new ModuloUsingRecursion().moduloUsingRecursion(dividend, divisor);
        System.out.println(result);
    }
}
