package String;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())return false;
        //如果字符串相同 那么出现两次相同字符的  即为符合题意
        if(A.length()>1&&A.equals(B)){
            Set<Character> set = new HashSet<>();
            for(char c : A.toCharArray()){
                if(set.contains(c)){
                    return true;
                }else {
                    set.add(c);
                }
            }
            return false;
        }
        int x = -1;
        int y = -1;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i = 0; i < A.length(); i++) {
            if(a[i] != b[i]){
                if(x==-1){
                    x = i;
                }else if(y==-1){
                    y = i;
                }else{
                    return false;
                }
            }
        }
        if(x!=-1&&y!=-1&&a[x]==b[y]&&a[y]==b[x]){
            return true;
        }
        return false;
    }
}
