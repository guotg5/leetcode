//34
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        int mid = (left + right) / 2;

        if(nums[mid] > target){
            right = mid - 1;
        }else if(nums[mid] <target){
            left = mid + 1;
        }else{

        }



        return nums;
    }
}