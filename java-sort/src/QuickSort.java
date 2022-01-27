import java.util.Arrays;

/**
 * 快速排序
 *
 * https://segmentfault.com/a/1190000040022056
 *
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进
 * 行排序，以达到整个序列有序。
 *
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 *
 * 1. 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在
 *    这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
public class QuickSort {

    public static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int smallIdx = partition(nums, start, end);
        sort(nums, start, smallIdx - 1);
        sort(nums, smallIdx + 1, end);
    }

    /**
     * 对nums[start:end]分区
     * 在数组中选出一个基准元素，小于基准元素的数移动到基准元素前，大于基准元素的数移动到基准元素后。
     * @param nums 数组对象
     * @param start 需要分区的开始下标
     * @param end 需要分区的结束下标
     * @return 基准元素的下标
     */
    public static int partition(int[] nums, int start, int end) {
        // 选最后一个元素为基准
        int pivot = nums[end];
        // 用来记录小于基准元素的下标
        int smallIdx = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, smallIdx++);
            }
        }
        // 将基准元素放在小元素区后
        swap(nums, end, smallIdx);
        return smallIdx;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 3, 0, 5, 1, 9, 4, 6, 8};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
