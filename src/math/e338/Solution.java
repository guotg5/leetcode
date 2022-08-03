package math.e338;

class Solution {
    //x&(x-1) 可以循环计算1的个数
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            result[0] = Integer.bitCount(i);
        }
        return result;
    }
}