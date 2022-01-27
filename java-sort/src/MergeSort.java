import java.util.Arrays;

/**
 * 归并排序
 *
 *
 * 和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代
 * 价是需要额外的内存空间。
 *
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归
 * 并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将
 * 两个有序表合并成一个有序表，称为2-路归并。
 *
 * 1. 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 2. 对这两个子序列分别采用归并排序；
 * 3. 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * 时间复杂度：Ο(nlogn)
 * 空间复杂度：Ο(n)+Ο(logn)
 */
public class MergeSort {
    public static int[] sort(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums;
        }
        int mid = len / 2;
        int[] nums1 = Arrays.copyOfRange(nums, 0, mid);
        int[] nums2 = Arrays.copyOfRange(nums, mid, len);
        int[] sortedNums1 = sort(nums1);
        int[] sortedNums2 = sort(nums2);
        return merge(sortedNums1, sortedNums2);
    }

    /**
     * 将两个有序数组合并成一个数组
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 合并后的有序数组
     */
    public static int[] merge(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int idx = 0, idx1 = 0, idx2 = 0; idx < nums.length; idx++) {
            if (idx1 >= nums1.length) {
                nums[idx] = nums2[idx2++];
            } else if (idx2 >= nums2.length) {
                nums[idx] = nums1[idx1++];
            } else if (nums1[idx1] < nums2[idx2]) {
                nums[idx] = nums1[idx1++];
            } else {
                nums[idx] = nums2[idx2++];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 3, 0, 5, 1, 9, 4, 6, 8};
        int[] sorted = sort(nums);
        System.out.println(Arrays.toString(sorted));
    }
}
