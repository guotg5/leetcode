package 动态规划;
/** 
 * @ClassName LongestPalindrome 
 * @Description TODO 5 最长回文子串
 * @author guotg
 * @date 2020-8-17 16:14:19 
 *  
 */
class LongestPalindrome {
    public String longestPalindrome(String s) {
    	int len = s.length();
    	int[][] dp = new int[len][len];
    	//单个字符 默认为1
    	for (int i = 0; i < dp.length; i++) {
			dp[i][i] = 1;
		}
    	//从右下角开始遍历
    	for (int i = len-1; i >= 0; i--) {
			for (int j = i-1; j >= 0; j--) {
				
			}
		}
    	
    	return "";
    }
}