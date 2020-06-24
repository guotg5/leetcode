import java.util.PriorityQueue;
import java.util.Queue;

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>();
        int diff = 0;
        for (int n : nums) {
            if (n > target) {
                max.offer(n);
            } else {
                min.offer(n);
            }
        }
        min.stream().forEach(System.out::println);

        return 1;
    }

    public static void main(String[] args) {
        new ThreeSumClosest().threeSumClosest(new int[]{1, 3, -1, 0}, 1);
    }
}