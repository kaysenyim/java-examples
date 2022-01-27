import java.util.Arrays;

/**
 * 计数排序(Counting sort)是一种稳定的排序算法。计数排序使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的
 * 元素的个数。然后根据数组C来将A中的元素排到正确的位置。它只能对整数进行排序。
 *
 * 1. 找出待排序的数组中最大和最小的元素；
 * 2. 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 3. 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 4. 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 */
public class CountingSort {
    public static void sort(int[] nums) {
        int max = 0, min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] - min]++;
        }
        int idx = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                nums[idx++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 7, 3, 0, 5, 1, 9, 4, 6, 8,
                2, 7, 3, 0, 5, 1, 9, 4, 6,
                2, 7, 3, 0, 5, 1, 9, 4,
                2, 7, 3, 0, 5, 1, 9,
                2, 7, 3, 0, 5, 1,
        };
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
