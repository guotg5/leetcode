package string;

class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb =  new StringBuilder(A);
        int result = 1;
        while (sb.length()<B.length()){
            sb.append(A);
            result ++;
        }
        if(match(sb.toString(), B)){
            return result;
        }else if(match(sb.append(A).toString(), B)){
            return result+1;
        }
        return -1;
    }

    boolean match(String a, String b){
        return a.indexOf(b)!=-1;
    }

    public static void main(String[] args) {
        new RepeatedStringMatch().repeatedStringMatch("abcd","cdabcdab");
    }
}