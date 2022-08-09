package Sort;

import java.util.Arrays;

public class sort {


    public int[] sortByBits(int[] arr) {
        int length = arr.length;

        /*
            根据 1的个数 和 当前数值，存储 每一个数字：
                此处是本题解的精髓：1的个数权值最大，其次是本身的值，方便之后的 还原和排序
         */
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * 100_000 + arr[i];
        }

        /*
            将 存储的数字，还原成最初始的数字，并根据 1的个数 和 当前数值 排序

         */
        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            arr[i] %= 100_000;
        }
        return arr;
    }

    /**
     * 快排 以基准点 将小于的放一边 并递归缩小范围
     * @return int
     **/
    public int[] quickSort(int[] arr, int begin, int end) {
        if(begin < end) {
            int temp = arr[end];
            int low = begin;
            int high = end;
            while (low < high) {
                if(arr[low] > temp && arr[high] < temp) {
                    int t = arr[low];
                    arr[low] = arr[high];
                    arr[high] = t;
                }else {
                    if(arr[low] <= temp) {
                        low ++;
                    }else {
                        high --;
                    }
                }
            }
            arr[end] = arr[low];
            arr[low] = temp;

            quickSort(arr, begin, low-1);
            quickSort(arr, low + 1, end);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(100_000);
    }
}
