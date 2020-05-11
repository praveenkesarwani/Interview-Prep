/*
problem: container With Most Water

Input consists of n non negative integers a1, a2, ..., an,
where each represents the height of a line. n vertical lines are drawn at 
points 1,2, … n on the x axis as shown in the diagram. Find two lines,
which together with the x axis forms a container,
such that the container holds the most water.
Note: You may not slant the container and n is at least 2.

Input: [1,8,6,2,5,4,8,3,7]

Output: 49
*/

public class containerWithMostWater {
    public int maxArea(int[] height) {
        int max_area = 0;
        int start_ptr = 0;
        int end_ptr = height.length - 1;
        while (start_ptr < end_ptr) {
            max_area = Math.max(max_area, Math.min(height[start_ptr], height[end_ptr]) * (end_ptr - start_ptr));
            if (height[start_ptr] < height[end_ptr]) {
                start_ptr++;
            } else {
                end_ptr--;
            }
        }
        return max_area;
    }
}