/*
Given a sorted matrix, come up with an efficient way to search for a value 
in the matrix. Each row in the matrix is sorted in ascending order from left 
to right. 
Each column in the matrix is sorted in ascending order from top to bottom.
*/

public class SearchInA2DMatrix {
    boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int j = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][j]) {
                boolean check = binarySearch(matrix[i], target);
                if (check) {
                    return true;
                }
            }
        }
        return false;
    }
}