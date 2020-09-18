package BinaryTree;
/** 
 * 最小高度树
 * 
 * @ClassName Solution 
 * @Description 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。 
 * @author guotg
 * @date 2020-9-16 15:47:58 
 *  
 */
class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
    	TreeNode node = dfs(0, nums.length-1, nums);
    	
		return node;
    }
    
    TreeNode dfs(int begin, int end,int[] nums) {
    	
    	if(begin>end)return null;
    	
    	int mid = begin+(end-begin)/2;
    			
    	TreeNode node = new TreeNode(nums[mid]);
    	
    	node.left = dfs(begin, mid-1, nums);
    	node.right = dfs(mid+1, end, nums);
    	
		return node;
    }
    
    public static void main(String[] args) {
		new SortedArrayToBST().sortedArrayToBST(new int[] {-10,-3,0,5,9});
	}
}