package hash;

import java.util.*;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(list1.contains(nums2[i])){
                list1.remove((Integer)nums2[i]);
                list.add(nums2[i]);
            }
        }
        return list.stream().mapToInt(i -> (int)i).toArray();
    }
}
