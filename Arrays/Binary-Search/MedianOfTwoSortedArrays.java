// Brute forch approach
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2, int m, int n) {
        double median = 0;
        int[] arr = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        while (i < m) {
            arr[k++] = nums1[i++];
        }
        while (j < n) {
            arr[k++] = nums2[j++];
        }
        if ((m + n) % 2 != 0) {
            median = arr[(m + n) / 2];
        } else {
            median = (arr[(m + n) / 2 - 1] + arr[(m + n) / 2]) / 2.0;
        }
        return median;
    }

}

    // Binary Search Approach
public double findMedianSortedArrays(int[] arrayA, int[] arrayB, int sizeOfA, int sizeOfB) {
    if (sizeOfA > sizeOfB) {
        return findMedianSortedArrays(arrayB, arrayA, sizeOfB, sizeOfA);
    }
    int lowAPtr = 0, highAPtr = sizeOfA, sizeLeftTotal = (sizeOfA + sizeOfB + 1) / 2;
    while (lowAPtr <= highAPtr) {
        int sizeLeftA = (lowAPtr + highAPtr) / 2;
        int sizeLeftB = sizeLeftTotal - sizeLeftA;
        int maxLeftA = (sizeLeftA == 0) ? Integer.MIN_VALUE : arrayA[sizeLeftA - 1];
        int maxLeftB = (sizeLeftB == 0) ? Integer.MIN_VALUE : arrayB[sizeLeftB - 1];
        int minRightA = (sizeLeftA == sizeOfA) ? Integer.MAX_VALUE : arrayA[sizeLeftA];
        int minRightB = (sizeLeftB == sizeOfB) ? Integer.MAX_VALUE : arrayB[sizeLeftB];
        if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
            if ((sizeOfA + sizeOfB) % 2 == 0) {
                double median = Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB);
                median = median / 2.0;
                return median;
            } else {
                double median = Math.max(maxLeftA, maxLeftB);
                return median;
            }
        } else if (maxLeftA > minRightB)
            highAPtr = sizeLeftA - 1;
        else
            lowAPtr = sizeLeftA + 1;
    }
    return 0.0;
}