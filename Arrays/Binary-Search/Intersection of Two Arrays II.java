//350. Intersection of Two Arrays II
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 < n2) {
            Map<Integer, Integer> map = createMap(nums1);
            return intersect(nums2, map);
        } else {
            Map<Integer, Integer> map = createMap(nums2);
            return intersect(nums1, map);
        }
    }

    public Map<Integer, Integer> createMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map;
    }

    public int[] intersect(int[] arr, Map<Integer, Integer> map) {
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int target = arr[i];
            if (map.containsKey(target) && map.get(target) > 0) {
                list.add(target);
                map.put(target, map.get(target) - 1);
            }
        }
        int[] output = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            output[i] = list.get(i);
        }
        return output;
    }
}
/*
 * Time Complexity: O(N + M), O(N) for iterate one of the array to create a hashmap and O(M) to iterate 
 * the other array. 
 * Time Complexity: O(N) space to store
  */