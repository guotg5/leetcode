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

    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    //给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
    //注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
    public int findArrSmallest(int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if(arr[mid] > arr[end]) {
                begin = mid + 1;
            } else if(arr[mid] < arr[end]){
                end = mid;
            } else {
                // 1 1 1 0 0 1 1 1
                // 1=1 无法判断左右 舍去右端点
                end -= 1;
            }
        }
        return arr[begin];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findArrSmallest(new int[]{3,1,1}));
    }
}
