import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        //构造二叉树
        Entry entry = buildEntry(matrix,0,0);
        //每次取出根节点  并保证树平衡
        for (int i = 0; i < k; i++) {

        }
        return k;
    }

    public static void main(String[] args) {
        new KthSmallest().kthSmallest(new int[][]{{1,3,5}
                                                , {6,7,12},
                                                  {11,14,14}},3);
    }
    public Entry buildEntry(int[][] arr, int x, int y){
        Entry curr = new Entry(arr[x][y]);
        if(x+1<arr.length){
            curr.left = buildEntry(arr, x+1, y);
        }
        if(y+1<arr[0].length){
            curr.right = buildEntry(arr, x, y+1);
        }
        return curr;
    }

    public class Entry{
        int value;

        Entry left;

        Entry right;

        public Entry(int v){
            this.value = v;
        }
    }
}