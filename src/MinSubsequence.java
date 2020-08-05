import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinSubsequence {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int sum = Arrays.stream(nums).sum();
        List<Integer> params = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int currsum = 0;
        for (int i = 0; i < nums.length; i++) {
            list.add(params.get(i));
            currsum += params.get(i);
            if (currsum > sum - currsum) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new MinSubsequence().minSubsequence(new int[]{7, 4, 2, 8, 1, 7, 7, 10});
    }
}