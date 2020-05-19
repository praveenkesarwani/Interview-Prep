//167. Two Sum II - Input array is sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int newTarget = target - numbers[i];
            int index = binarySearch(numbers, newTarget, i + 1);
            if (index != -1) {
                ans[0] = i + 1;
                ans[1] = index;
                return ans;
            }
        }
        return ans;
    }

    public int binarySearch(int[] arr, int target, int left) {
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
