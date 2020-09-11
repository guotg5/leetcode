package 回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * @ClassName CombinationSum 
 * @Description TODO 
 * @author guotg
 * @date 2020-9-10 16:05:35 
 *  
 */
class CombinationSum {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	
    	Arrays.sort(candidates);
    	
    	List<Integer> list = new ArrayList<Integer>();
    	dfs(list, candidates, target);
    	
		return result;
    }
    
    void dfs(List<Integer> list, int[] arr, int target) {
    	for (int i = 0; i < arr.length; i++) {
    		int rest = target-arr[i];
    		if(rest == 0) {
    			list.add(arr[i]);
    			List<Integer> c = new ArrayList<Integer>(list.size());
    			c.addAll(list);
    			result.add(c);
    		}else if(rest < 0) {
    			return;
    		}else {
    			list.add(arr[i]);
    			int[] copy = new int[arr.length-i];
        		System.arraycopy(arr, i, copy, 0, copy.length);
    			dfs(list, copy, rest);
    		}
    		list.remove(list.size()-1);
		}
    }
    
    public static void main(String[] args) {
		int[] a = {2,3,5};
		new CombinationSum().combinationSum(a, 8);
	}
}