package bisectionMethod;

/**
 * 二分法
 *
 * @Author guotiangang
 * @Date 2022/8/4 11:02
 */
public class Solution {

    /**
     * 在一个长度为 n+1 的数组 nums 里的所有数字都在 1～n 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 数组不可变
     * 默认n>2
     * 思路：二分法 以中点m为分界 必然存在 1~m 或 m+1~n 在数组中包含数字量大于仅出现一次场景
     * 例：[1,4,2,3,4,5] n=5 m=2 1~2=2  3~5=4 那么重复数字必然在3~5之间
     **/
    public int findDuplication(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while(left < right) {
            int m = left + (right - left) >> 1;
            int leftNum = 0;
            for (int num : nums) {
                if (num <= m) {
                    leftNum++;
                }
            }
            if(leftNum > m - left + 1) {
                right = m;
            } else {
                left = m + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        new Solution().findDuplication(new int[]{2, 3, 1, 2, 5, 3});
    }
}
