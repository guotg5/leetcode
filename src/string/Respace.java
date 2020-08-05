package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//面试题 17.13. 恢复空格
//怎么快速的查字典
class Respace {
    static Set<String> unknown = new HashSet<>();
    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary.length);
        set.addAll(Arrays.asList(dictionary));
        List<String> list = new ArrayList<>();
        list.add(sentence);

        return find(set, sentence);
    }

    int find(Set<String> set, String str){
        int result = 1;

        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){

            }
        }

        return result;
    }
}