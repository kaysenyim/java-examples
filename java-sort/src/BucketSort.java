import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序 (Bucket sort)的
 * 工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归
 * 方式继续使用桶排序进行排）。
 *
 * 1. 设置一个定量的数组当作空桶；
 * 2. 遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 3. 对每个不是空的桶进行排序；
 * 4. 从不是空的桶里把排好序的数据拼接起来。
 */
public class BucketSort {
    public static int[] sort(int[] nums) {
        int max = 0, min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int bucketSize = 5;
        int bucketCount = (max - min) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            List<Integer> bucket = new ArrayList<>();
            buckets.add(bucket);
        }
        for (int i = 0; i < nums.length; i++) {
            int bucketIdx = (nums[i] - min) / bucketSize;
            List<Integer> bucket = buckets.get(bucketIdx);
            bucket.add(nums[i]);
        }
        List<Integer> sorted = new ArrayList<>(nums.length);
        for (List<Integer> bucket : buckets) {
            int[] arr = bucket.stream().mapToInt(Integer::intValue).toArray();
            BubbleSort.sort(arr);
            List<Integer> l = Arrays.stream(arr).boxed().collect(Collectors.toList());
            sorted.addAll(l);
        }
        return sorted.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 7, 3, 0, 5, 1, 9, 4, 6, 8,
                2, 7, 3, 0, 5, 1, 9, 4, 6,
                2, 7, 3, 0, 5, 1, 9, 4,
                2, 7, 3, 0, 5, 1, 9,
                2, 7, 3, 0, 5, 1,
        };
        int[] sorted = sort(nums);
        System.out.println(Arrays.toString(sorted));
    }
}
