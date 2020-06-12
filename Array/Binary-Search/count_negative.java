//Count Negative Numbers in a Sorted Matrix
class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int num_rows = grid.length;
        int num_cols = grid[0].length;
        for (int i = 0; i < num_rows; i++) {
            count += binarySearch(grid[i]);
        }
        return count;
    }

    int binarySearch(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}