package bitwiseOpertation;

/**
 * 异或：用于在重复数字中找不重复数字，如果有多个这样的数字，可以找到最后一位不同的进行分组处理。
 *
 * @Author guotiangang
 * @Date 2022/8/3 15:39
 */
public class Solution {

    public static int numberOf1(int num) {
        int count = 0;
        while(num > 0) {
            count++;
            num = num & (num-1);// 1100 & 1011 = 1000 正好去掉最后的1
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(5));
    }
}
