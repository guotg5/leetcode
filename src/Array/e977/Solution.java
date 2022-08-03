package Array.e977;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = -1;
        int r;
        for (int num : nums){
            if(num < 0) l++;
            else break;
        }
        r = l + 1;
        int[] result = new int[nums.length];
        int i = 0;
        while(l >= 0 || r < nums.length){
            if(l >= 0 && (r >= nums.length || Math.abs(nums[l]) < Math.abs(nums[r]))){
                result[i++] = nums[l] * nums[l];
                l--;
            }else {
                result[i++] = nums[r] * nums[r];
                r++;
            }
        }
        return result;
    }
}