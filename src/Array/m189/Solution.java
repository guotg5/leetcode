package Array.m189;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = result[i];
        }
    }
}