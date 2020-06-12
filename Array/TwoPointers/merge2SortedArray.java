// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        int ptr1 = 0, ptr2 = 0, index = 0;
        while (ptr1 < m && ptr2 < n) {
            if (nums1[ptr1] < nums2[ptr2]) {
                ans[index++] = nums1[ptr1];
                ptr1++;
            } else if (nums2[ptr2] <= nums1[ptr1]) {
                ans[index++] = nums2[ptr2];
                ptr2++;
            }
        }
        while (ptr1 < m) {
            ans[index++] = nums1[ptr1++];
        }
        while (ptr2 < n) {
            ans[index++] = nums2[ptr2++];
        }
        ptr2 = 0;
        for (int val : ans) {
            nums1[ptr2++] = val;
        }

    }
}