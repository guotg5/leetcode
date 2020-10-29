package String;

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int result = 0;
        for(int j=s.length()-1;j>-1;j--){
            if(s.charAt(j) == ' '&& result == 0){
                continue;
            }
            if(s.charAt(j) == ' '){
                break;
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("hello world "));
    }
}