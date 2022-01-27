import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序也是非比较的排序算法，对每一位进行排序，从最低位开始排序，复杂度为O(kn),为数组长度，k为数组中的数的最大的
 * 位数；
 *
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序
 * 的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。基数排序基于
 * 分别排序，分别收集，所以是稳定的。
 *
 * 1. 取得数组中的最大数，并取得位数；
 * 2. arr为原始数组，从最低位开始取每个位组成radix数组；
 * 3. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 */
public class RadixSort {
    public static void sort(int[] nums) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        // 10进制下最大的位数
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0, mod = 10, div = 1; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int num : nums) {
                int bucketIdx = (num % mod) / div;
                buckets.get(bucketIdx).add(num);
            }
            int index = 0;
            for (List<Integer> bucket : buckets) {
                for (Integer num : bucket) {
                    nums[index++] = num;
                }
                bucket.clear();
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
                101,
        };
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
