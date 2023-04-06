package Array.滑动窗格;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗格记录
 *
 * @Author guotiangang
 * @Date 2022/8/26 11:40
 */
public class Solution {

    /**
     * 给定一个 排序好 的数组arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
     *
     * 整数 a 比整数 b 更接近 x 需要满足：
     *
     * |a - x| < |b - x| 或者
     * |a - x| == |b - x| 且 a < b
     **/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = k - 1;
        while(right < arr.length - 1 && (Math.abs(arr[left] - x) > Math.abs(arr[right + 1] - x) || arr[left] == arr[right + 1])) {
            left ++;
            right ++;
        }
        while(left <= right) {
            list.add(arr[left++]);
        }
        return list;
    }
}
