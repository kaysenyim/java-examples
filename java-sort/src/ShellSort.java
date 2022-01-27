import java.util.Arrays;

/**
 * 插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 *
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 *
 * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 2. 按增量序列个数k，对序列进行k 趟排序；
 * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1
 *    时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * 平均时间复杂度：Ο(nlog²n)
 * 最坏时间复杂度：Ο(n²)
 * 空间复杂度：Ο(1)
 */
public class ShellSort {
    public static void sort(int[] nums) {
        int gap = nums.length / 2;
        int tmp;
        while (gap > 0) {
            for (int i = gap; i < nums.length; i++) {
                tmp = nums[i];
                int preIdx = i - gap;
                while (preIdx >= 0 && tmp < nums[preIdx]) {
                    nums[preIdx + gap] = nums[preIdx];
                    preIdx -= gap;
                }
                nums[preIdx + gap] = tmp;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 3, 0, 5, 1, 9, 4, 6, 8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
