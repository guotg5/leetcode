//34
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int one = find(nums, target);
        if(one == -1){
            return new int[]{-1,-1};
        }

        int left = 0;
        int right = (left + one - 1) / 2;

        int left2 = (right + one + 1) / 2;
        int right2 = nums.length;

        int mid = (left + right) / 2;
        int mid2 = (left2 + right2) / 2;

        while(left < right){
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] <target){
                left = mid + 1;
            }else{

            }
        }

        return nums;
    }

    public int find(int[] nums, int target){
        int left = 0;
        int right = nums.length;

        int mid = (left + right) / 2;
        while(left < right){
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] <target){
                left = mid + 1;
            }else{
                return mid;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }
}