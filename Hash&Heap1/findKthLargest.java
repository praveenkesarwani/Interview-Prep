import java.io.*;
import java.util.*;

class KthLargestElementInAnArray {

    // Implement your solution by completing the below function
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); // min heap
        for(int i:nums){
            heap.add(i);
            if(heap.size() > k)
                heap.poll();
        }
        return heap.peek();
    }
    // I could have used max_heap instead and add all the elements in max_heap
    // After adding all the elements remove k-1 elements from max_heap and return
    // the peek value but running two loop is not efficient.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; ++i)
            nums[i] = scanner.nextInt();

        int k = scanner.nextInt();
        scanner.close();

        int result = new KthLargestElementInAnArray().findKthLargest(nums, k);
        System.out.println(result);
    }
}
