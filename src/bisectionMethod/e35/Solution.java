package bisectionMethod.e35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int begin = 0;
        int end = nums.length - 1;
        int mid;
        while(begin <= end){
            mid = (begin + end) >>> 1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else if(nums[mid] < target){
                begin = mid + 1;
            }
        }
        return begin;
    }
}