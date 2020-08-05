package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PairSums {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        for(Integer i : nums){
            Integer j = target - i;
            if(map.containsKey(i)&&map.containsKey(j)&&map.get(i) != 0 && map.get(j) != 0){
                if(i==j&&map.get(i)<2){
                    continue;
                }
                List<Integer> temp = new ArrayList<>(2);
                temp.add(i);
                temp.add(j);
                map.put(i,map.get(i)-1);
                map.put(j,map.get(j)-1);
                result.add(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new PairSums().pairSums(new int[]{5,6,5,6},11);
    }
}