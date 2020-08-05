//34
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        return new int[]{find(nums, target, true), find(nums, target, false)};
    }

    public int find(int[] nums, int target, boolean isl){
        int left = 0;
        int right = nums.length;

        int mid = left + (right - left) / 2;
        while(left < right){
            if(nums[mid] > target){
                right = mid;
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
        if(isl&&(left>=nums.length||nums[left]!=target)){
            return -1;
        }else if(!isl&&(left<1||nums[left-1]!=target)){
            return -1;
        }
        return isl?left:left-1;
    }

    public static void main(String[] args) {
        Object o =new SearchRange().searchRange(new int[]{5},5);
        o.hashCode();
    }
}