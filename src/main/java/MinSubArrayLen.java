public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int k=0;
        int minLen = 0;
        if(nums.length>0){
            int sum = nums[0];
            for (int i = 0; i < nums.length; i++) {
                int j=i+1;
                if(i != 0){
                    j = k+1;
                    sum -= nums[i-1];
                }
                while(sum < s && j <nums.length){
                    sum+=nums[j];
                    k = j++;
                }
                if(sum >= s && (minLen==0||j-i<minLen)){
                    minLen = j-i;
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        new MinSubArrayLen().minSubArrayLen(8, new int[]{2,3,1,2,4,3});
    }
}
