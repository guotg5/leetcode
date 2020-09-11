package 回溯算法;

import java.util.HashSet;
import java.util.Set;

public class 数独 {

	int min(int[][] arr, int x, int y, int index) {
		Set<Integer> set = new HashSet<>();
		//当前行已出现的值
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[x][i]);
		}
		//当前列已出现的值
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i][y]);
		}
		//当前框已出现的值
		int init_x = x/3*3;
		int init_y = y/3*3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				set.add(arr[init_x+i][init_y+j]);
			}
		}
		//从set中找最小值
		for (int i = 1; i <= arr.length; i++) {
			if(!set.contains(i)&&index--==0) {
				return i;
			}
		}
		return 0;
	}

	boolean fill(int arr[][]) {
		int x = -1;
		int y = -1;
		int index = 0;
		//查找需要填充的位置
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]==0) {
					x = i;
					y = j;
					break;
				}
			}
		}
		//获取当前位置可能值 向下递归 成功则返回true 失败则获取其他可能值
		do {
			arr[x][y] = min(arr, x, y, index++);
			if(arr[x][y] == 0) {
				//当所有可能值都不可行  返回false
				return false;
			}
		}while(!fill(arr));

		return true;

	}

}
