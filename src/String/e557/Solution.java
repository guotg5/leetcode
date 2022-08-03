package String.e557;

class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs){
            char[] chars = str.toCharArray();
            reverseString(chars);
            if(sb.length() > 0){
                sb.append(" ");
            }
            sb.append(String.valueOf(chars));
        }
        return sb.toString();
    }

    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}