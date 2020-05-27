
/** Problem:
*Given an array of positive and negative numbers you need to find if there is any subarray with 0 sum.
*Note: A subarray of an array is a set of contiguous elements having a size of at least 1.
Approach:

*/

import java.util.*;

class SubarraySumZero {
	public static String subarraySumZero(Vector<Integer> arr) {
		// prefix sum approach
		int sum = 0;
		Set<Integer> hash_set = new HashSet<>();
		for (int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
			if (arr.get(i) == 0 || sum == 0 || hash_set.contains(sum))
				return "Yes";
			hash_set.add(sum);
		}
		return "No";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int j = 0; j < t; j++) {
			int n = sc.nextInt();
			Vector<Integer> arr = new Vector<Integer>();
			for (int i = 0; i < n; i++) {
				arr.add(sc.nextInt());
			}
			System.out.println(subarraySumZero(arr));
		}

	}
}
