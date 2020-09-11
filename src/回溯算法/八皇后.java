package 回溯算法;

/** 
 * 回溯法   其实就是所有路都走一遍 通过递归或者栈  走失败就退回
 * 
 * @ClassName 八皇后 
 * @Description TODO 
 * @author guotg
 * @date 2020-9-10 15:58:30 
 *  
 */
public class 八皇后 {
	
	private boolean isOk(int x,int y, int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i][y] == 1 || (y-(x-i)>=0&&y-(x-i)<arr.length&&arr[i][y-(x-i)] == 1)) {
				return false;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[x][i] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean search(int n, int[][] arr) {
		
		if(n == 0) return true;
		
		n--;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(isOk(i, j, arr)) {
					arr[i][j] = 1;
					if(search(n, arr)) {
						return true;
					}else {
						arr[i][j] = 0;
					}
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int huanghou = 8;
		int[][] arr = new int[huanghou][huanghou];
		
		new 八皇后().search(huanghou, arr);
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
