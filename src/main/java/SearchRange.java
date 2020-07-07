//34
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{find(nums, target, true), find(nums, target, false)};
    }

    public int find(int[] nums, int target, boolean isl){
        int left = 0;
        int right = nums.length;

        int mid = left + (right - left) / 2;
        while(left < right){
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target){
                if(isl){
                    right = mid;
                }else{
                    left = mid +1;
                }
            }
            mid = left + (right - left) / 2;
        }
        return isl?left:left-1;
    }

    public static void main(String[] args) {
        new SearchRange().searchRange(new int[]{5,7,7,8,8,10},8);
    }
}