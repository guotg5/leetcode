package Array;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Array {

    /**
     * 直接计算相邻的白格即可
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int result = 0;
//        int x,y = 0;
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1){
//                    x=i;
//                    y=j;
//                    break;
//                }else{
//                    if()
//                }
//            }
//        }
        return result;
    }

    /**
     * 是否山峰
     *
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        if(A==null||A.length<3)return false;
        int i=0;
        int j=A.length-1;
        while (i<A.length-1&&j>0&&(A[i]<A[i+1]||A[j]<A[j-1])){
            if(A[i]<A[i+1])i++;
            if(A[j]<A[j-1])j--;
        }
        return i==j&&i!=0&&i!=A.length-1;
    }

    public int maxArea(int [] height) {
        int max = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int result = Math.min(height[i],height[j]) * (j-i);
                max = max>result?max:result;
            }
        }
        return max;
    }

    public int trap(int[] height) {
        int result = 0;
        int c = 1;
        while(true){
            int left = -1;
            for (int i = 0; i < height.length; i++) {
                if(height[i]>c){
                    if(left == -1){
                        left = i;
                    }else{
                        result += (i-left);
                        left = -1;
                    }
                }
            }
        }
    }

    /**
     * 插入区间
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean isin = false;
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][1]<newInterval[0]){
                list.add(intervals[i]);
            }else if(intervals[i][0]>newInterval[1]){
                isin = true;
                list.add(newInterval);
                list.add(intervals[i]);
                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }
                break;
            }else{
                int left = Math.min(intervals[i][0],newInterval[0]);
                int right = Math.max(intervals[i][1],newInterval[1]);
                newInterval[0] = left;
                newInterval[1] = right;
            }
        }
        if(!isin)list.add(newInterval);
        return list.toArray(new int[0][]);
    }

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if(!wordList.contains(endWord))return 0;
//        if(like(beginWord,endWord))return 2;
//        if(wordList.size()==0)return 0;
//        List<String> copy = new ArrayList<>();
//        copy.addAll(wordList);
//        int result = 0;
//        for (int i = 0; i < wordList.size(); i++) {
//            String temp = wordList.get(i);
//            if(like(beginWord, temp)){
//                copy.remove(temp);
//                int result1 = ladderLength(temp,endWord,copy)+1;
//                if(result1>1&&(result == 0 || result1 < result)){
//                    result = result1;
//                }
//            }
//        }
//        return result;
//    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        Set<String> set = new HashSet<>();
        set.addAll(wordList);
        Queue<String> stack = new ArrayDeque<>();
        stack.offer(beginWord);
        set.remove(beginWord);
        while(!stack.isEmpty()){
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                String temp = stack.poll();
                if(temp == endWord)return result;
                Iterator<String> iter = set.iterator();
                while(iter.hasNext()){
                    String next = iter.next();
                    if(like(temp, next)){
                        stack.offer(next);
                        iter.remove();
                    }
                }
            }
            result++;
        }
        return 0;
    }

    boolean like(String begin, String end){
        int r = 1;
        for (int i = 0; i < begin.length()&&r>-1; i++) {
            if(begin.charAt(i)!=end.charAt(i))r--;
        }
        return r==0;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int begin = 0;
        int end = nums.length-1;

        while(begin <= end){
            int mid = (begin + end)/2;
            if(nums[mid] == target && (mid == 0 || nums[mid]>nums[mid-1])){
                result[0] = mid;
                break;
            }else if(nums[mid] <target){
                begin = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        begin = 0;
        end = nums.length-1;

        while(begin < end){
            int mid = (begin + end)/2;
            if(nums[mid] == target && (mid == nums.length - 1 || nums[mid]<nums[mid+1])){
                result[1] = mid;
                break;
            }else if(nums[mid] >target){
                end = mid - 1;
            }else {
                begin = mid + 1;
            }
        }
        return result;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        new Array().searchRange(new int[]{5,7,7,8,8,10},8);
    }
}
