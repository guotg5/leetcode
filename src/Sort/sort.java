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
     * 插入排序
     * 依次遍历 将元素按顺序插入到已排序序列的正确位置
     **/
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
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

    public static int[] quickSort2(int[] arr, int begin, int end) {
        if(begin >= end) return arr;
        int temp = arr[end];
        int left = begin;
        int right = end;
        while(left < right) {
            while(arr[left]<=temp && left < right) {
                left++;
            }
            while(arr[right] >= temp && right > left) {
                right--;
            }
            if(left < right){
                int t = arr[left];
                arr[left] = arr[right];
                arr[right] = t;
                left++;
                right--;
            }

        }
        arr[end] = arr[left];
        arr[left] = temp;

        quickSort2(arr, begin, left-1);
        quickSort2(arr, left+1, end);
        return arr;
    }

    /**
     * 将数组拆分到最小子数组  从下至上 排序
     * @param arr
     * @Date 2023/4/6 21:47
     * @return int
     **/
    public int[] mergeSort(int[] arr) {
        if(arr.length == 1) return arr;

        //拆
        int mid = (arr.length-1)/2;
        int[] arr1 = mergeSort(Arrays.copyOfRange(arr, 0, mid+1));
        int[] arr2 = mergeSort(Arrays.copyOfRange(arr, mid+1, arr.length));

        return mergeArr(arr1, arr2);
    }

    /**
     * 合并两个排序数组
     **/
    public int[] mergeArr(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int ia = 0;
        int ib = 0;
        int i = 0;
        while(ia < a.length || ib < b.length) {
            if(ia == a.length) {
                result[i++] = b[ib++];
            }else if(ib == b.length) {
                result[i++] = a[ia++];
            }else {
                if(a[ia] < b[ib]) {
                    result[i++] = a[ia++];
                }else {
                    result[i++] = b[ib++];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(quickSort2(new int[]{5,78,2,4,6,2,45,4,3}, 0 , 8));
    }
}
