import java.util.Arrays;

public class HeapSort {
    private static int len;
    public static void sort(int[] nums) {
        len = nums.length;
        buildMaxHeap(nums);
        while (len > 0) {
            // 最大值处于root节点
            swap(nums, 0, --len);// 将最大值存储到堆外
            adjustHeap(nums, 0);
        }
    }

    public static void buildMaxHeap(int[] nums) {
        len = nums.length;
        // 从最后一个非子树开始调整
        for (int i = (len / 2) - 1; i >= 0; i--) {
            adjustHeap(nums, i);
        }
    }

    /**
     * 调整到最大堆
     * @param nums
     * @param i
     */
    public static void adjustHeap(int[] nums, int i) {
        System.out.println(Arrays.toString(nums));
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 左节点存在，且左节点最大
        if (left < len && nums[left] > nums[max]) {
            max = left;
        }
        if (right < len && nums[right] > nums[max]) {
            max = right;
        }
        if (max != i) {
            swap(nums, i, max);
            adjustHeap(nums, max);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 3, 0, 5, 1, 9, 4, 6, 8};
        // System.out.println(Arrays.toString(nums));
        // sort(nums);
        buildMaxHeap(nums);
        // System.out.println(Arrays.toString(nums));
    }
}
