//Reverse a string in place
class Solution {
    void swap(int a, int b, char[] s) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            swap(left, right, s);
            left++;
            right--;
        }
    }
}