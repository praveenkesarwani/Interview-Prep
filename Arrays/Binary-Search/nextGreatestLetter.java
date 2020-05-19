//Given an array of lowercase letters sorted in ascending order, 
//find the smallest letter in the given array greater than a given key
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;
        int n = letters.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return letters[left % (n)];
    }
}
/*
 * Time Complexity: O(logN), where N is the length of letters. Space Complexity:
 * O(1), as we maintain only pointers.
 */