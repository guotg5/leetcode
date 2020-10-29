package String;

class ReverseWords {
    public String reverseWords(String s) {
        if(s.length()==0||s.length()==1){
            return s;
        }
        StringBuilder result = new StringBuilder();
        String[] strs = s.split(" ");
        int j=0;
        for(String str : strs){
            strs[j++] = new StringBuilder(str).reverse().toString();
        }
        for(String str : strs){
            if(result.length()>0){
                result.append(" ");
            }
            result.append(str);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        new ReverseWords().reverseWords("abc abc def");
    }
}