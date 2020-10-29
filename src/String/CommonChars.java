package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1002. 查找字符串中并集
 */
class CommonChars {
    public List<String> commonChars(String[] A) {
        Map<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int[] count = new int[26];
        count[0] = -1;
        for (String str : A){
            if(count[0] == -1){
                count[0] = 0;
                for (char c : str.toCharArray()){
                    count[c-97] += 1;
                }
            }else{
                int[] temp = new int[26];
                for (char c : str.toCharArray()){
                    temp[c-97] += 1;
                }
                for (int i = 0; i < 26; i++) {
                    if(temp[i]<count[i]){
                        count[i] = temp[i];
                    }
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            int num = count[i];
            if (count[i]>0){
                for (int j = 0; j < count[i]; j++) {
                    result.add(Character.valueOf((char) (i+97)).toString());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //97
        System.out.println('a'+0);
    }
}