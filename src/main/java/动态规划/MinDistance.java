package 动态规划;

class MinDistance {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0||word2.length()==0)return word2.length();

        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i)==word2.charAt(0)){

            }else{
                dp[i][0] = min()+1;
            }
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if(word1.charAt(i)==word2.charAt(j)){

                }else{
                    dp[i][j] = min()+1;
                }
            }
        }
        return dp[word1.length()-1][word2.length()-1];
    }
}