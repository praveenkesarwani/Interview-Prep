import java.util.*;
class NextLargerElement {

	static int [] nextLargerElement(int ar[], int n) {
		Stack<Integer> stack = new Stack<>();
        int [] ans = new int[n];	
		for(int i = 0;i < n;i++){
            // If the incoming element is greater, then it is the next greater element for the top stack element.
            // We pop this element from the stack.
			while(!stack.empty() && ar[i] > ar[stack.peek()]){
				ans[stack.peek()] = ar[i];
				stack.pop();
            }
            //If the Stack is empty (which it is initially), then push the element in it.
			stack.push(i);
        }
        // when all the array elements have been traversed, for the remaining elements in the Stack, we can simply add -1.
		while(!stack.empty()){
			ans[stack.peek()] = -1;
			stack.pop();
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		int [] ans = nextLargerElement(ar, n);
		for (int i = 0; i < ans.length; i++)
			System.out.print(ans[i] + " ");
	}
}
