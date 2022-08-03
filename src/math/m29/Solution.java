package math.m29;

class Solution {
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if(Math.abs(divisor) == 1)return divisor > 0 ? dividend : -dividend;
        boolean isNegative = (dividend ^ divisor) <0;
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int result = 0;
        int resultTemp = -1;
        int temp = divisor;
        while(dividend <= temp){
            resultTemp++;
            if(dividend > (temp<<1) || (temp<<1) >= 0){
                dividend -= temp;
                temp = divisor;
                result += Math.pow(2, resultTemp);
                resultTemp = -1;
            }else{
                temp = temp<<1;
            }
        }
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        divide(-4, 2);
    }
}