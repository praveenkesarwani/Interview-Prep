import java.util.*;
import java.io.*;
class EvaluateExpression {
	public static Long evaluateExpression(Long n , ArrayList<String> expresion) {
		Stack<Long>stack = new Stack<>();
		for(int i = 0;i < expresion.size();i++){
            if(!isOperator(expresion.get(i)))
                stack.push(Long.parseLong(expresion.get(i)));
            else{
            Long operand1 = stack.pop();
            Long operand2 = stack.pop();
            Long result = eval(operand1,operand2,expresion.get(i).charAt(0));
            stack.push(result);
            }
        }
        Long result = stack.pop();
        return result;
    }
    public static Long eval(Long operand1, Long operand2,char operater){
        if(operater == '+') return operand2 + operand1;
        if(operater == '-') return operand2 - operand1;
        if(operater == '*') return operand2 * operand1;
        else return operand2 / operand1;

    }
    public static boolean isOperator(String s){
        char c = s.charAt(0);
        return s.length() == 1 && (c == '+' || c == '-' || c == '*' || c == '/');
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Long n = sc.nextLong();
		ArrayList<String> A = new ArrayList<String> ();
		for ( int i = 0; i < n; i++) {
			String s = sc.next();
			A.add(s);
		}
		Long answer = evaluateExpression(n, A);
		System.out.print( answer + " ");
	}
}
