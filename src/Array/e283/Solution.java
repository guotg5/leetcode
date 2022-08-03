package Array.e283;

class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 0 || nums.length == 1)return;
        for (int i = nums.length - 2; i >= 0; i--) {
            int j = i;
            while(nums[j] == 0 && j < nums.length -1 && nums[j+1] != 0){
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                j++;
            }
        }
    }
}