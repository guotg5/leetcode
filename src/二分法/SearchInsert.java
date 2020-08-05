package 二分法;

/*35 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。*/
class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] > target){
                right = mid;
            }else if(nums[mid] < target){
                left = left +1;
            }else{
                return mid;
            }
        }
        if(left == nums.length)return left;
        return nums[left] > target ? left : left + 1;
    }
}