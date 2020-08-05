import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i]);
            if(q.size() > k)q.poll();
        }
        return q.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        return Arrays.stream(nums).sorted().limit(nums.length-k+1).max().getAsInt();
    }
}
