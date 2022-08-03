package math.m78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= (1 << n) - 1 ; i++) {
            List<Integer> t = new ArrayList<Integer>();
            int index = 0, j = i;
            while(j > 0){
                if(j % 2 == 1){
                    t.add(nums[index]);
                }
                index++;
                j >>= 1;
            }
            ans.add(t);
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().subsets(new int[]{1,2,3});
    }
}