import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//378
class KthSmallest {
//    二分法   有序二维矩阵  如果确定一个数k 很容易得出比k小的数有多少个（从左下角遍历 直到横坐标超出）
//    找出不小于k的数量  并记录k出现的次数
//    如果不满足  二分法继续找数
    //问题1 必然存在多个数字 使得小于等于它本身的数量等于k  找到最小的
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix.length-1];
        int mid = left + (right - left)/2;

        while(left < right){
            if(check(matrix, mid, k)){
                right = mid;
            }else{
                left = mid + 1;
            }
            mid = left + (right - left)/2;
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k){
       int x = matrix.length - 1;
       int y = 0;
       int num = 0;
       while(x>=0&&y<matrix.length){
           if(matrix[x][y] > mid){
               x--;
           }else{
               num += (x + 1);
               y++;
           }
       }
       return num >= k;
    }

    public static void main(String[] args) {
        new KthSmallest().kthSmallest(new int[][]{{-5}},1);
    }

}