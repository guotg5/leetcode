import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//378
class KthSmallest {
//    二分法   有序二维矩阵  如果确定一个数k 很容易得出比k小的数有多少个（从左下角遍历 直到横坐标超出）
//    找出不小于k的数量  并记录k出现的次数
//    如果不满足  二分法继续找数
    //问题1 二分法的数不一定存在于数组
    public int kthSmallest(int[][] matrix, int k) {
        int max = matrix[matrix.length-1][matrix.length-1];
        int min = matrix[0][0];
        return find(matrix, max, min, k);
    }

    public int find(int[][] arr,int max, int min, int k){
        int mid = (max + min)/2;
        int num = 0;
        int x=arr.length-1;
        int y=0;
        while(x>=0&&y<arr.length){
            if(arr[x][y]<=mid){
                y++;
                if(y==arr.length){
                    num += y;
                    x--;
                    y--;
                }
            }else{
                num += y;
                x--;
            }
        }
        if(num > k){
            return find(arr,mid,min,k);
        }else if (num < k){
            return find(arr,max,mid,k);
        }else{
            return mid;
        }
    }

    public static void main(String[] args) {
        new KthSmallest().kthSmallest(new int[][]{{1,2,3},
                {4,5,6},{7,8,17}},1);
    }

}