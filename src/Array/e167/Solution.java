package Array.e167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length == 2)return new int[] {
            1,2
        };
        int[] result = new int[]{1, numbers.length};
        while(numbers[result[0]-1] + numbers[result[1]-1] != target){
            if(numbers[result[0]-1] + numbers[result[1]-1] > target){
                result[1] -= 1;
            }else {
                result[0] += 1;
            }
        }
        return result;
    }
}