import java.util.Arrays;

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int a=i+1;
            int b= nums.length-1;
            while(a<b){
                int sum = nums[i] + nums[a] + nums[b];
                if(Math.abs(sum-target)<Math.abs(result-target))result=sum;
                if(sum>target){
                    b--;
                }else if(sum < target){
                    a++;
                }else{
                    return sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new ThreeSumClosest().threeSumClosest(new int[]{-1,2,1,-4}, 1);
    }
}