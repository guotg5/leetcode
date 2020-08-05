package string;

import java.util.*;

//面试题 17.13. 恢复空格
//怎么快速的查字典
class Respace {
    static Set<String> unknown = new HashSet<>();
    public int respace(String[] dictionary, String sentence) {
        int result = 0;
//        Map<String, Set> map = new HashMap<>();
//        for(String s : dictionary){
//            String key = String.valueOf(s.charAt(0));
//            if(map.containsKey(key)){
//                map.get(key).add(s);
//            }else{
//                Set<String> set = new TreeSet<>();
//                set.add(s);
//                map.put(key, set);
//            }
//        }
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