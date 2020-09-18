package 回溯算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** 
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 
 * @ClassName CombinationSum3 
 * @Description TODO 
 * @author guotg
 * @date 2020-9-11 16:17:07 
 *  
 */
class CombinationSum3 {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> combinationSum3(int k, int n) {
		return result;

    }
    
    void dfs(int target, int count, int begin, Set s) {
    	count--;
    	for (int i = begin; i < 10; i++) {
    		if(count == 0) {
    			if(target == i) {
    				
    			}
    		}
//			if(target = i && count == 0) {
//
//			}
		}
    }
}