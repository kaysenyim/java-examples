import java.util.Arrays;

/**
 * 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序
 * 序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均
 * 排序完毕。 <br>
 *
 * n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：<br>
 *
 * 1. 初始状态：无序区为R[1..n]，有序区为空；<br>
 * 2. 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键
 *    字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录
 *    个数减少1个的新无序区；<br>
 * 3. n-1趟结束，数组有序化了。<br>
 *
 * 时间复杂度：Ο(n²)<br>
 * 空间复杂度：Ο(1)<br>
 */
public class SelectionSort {
    public static void sort(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int tmp, minIdx;
        for (int i = 0; i < nums.length - 1; i++) {
            minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 3, 0, 5, 1, 9, 4, 6, 8};
        sort(nums);
        //  ┌───────────无序区──────────┐
        // [2, 7, 3, 0, 5, 1, 9, 4, 6, 8]
        //           ↑

        //     ┌─────────无序区─────────┐
        // [0, 7, 3, 2, 5, 1, 9, 4, 6, 8]
        //                 ↑

        //  ┌──┐  ┌────────无序区───────┐
        // [0, 1, 3, 2, 5, 7, 9, 4, 6, 8]
        //           ↑

        //  ┌─────┐  ┌──────无序区──────┐
        // [0, 1, 2, 3, 5, 7, 9, 4, 6, 8]
        //           ↑

        //  ┌─有序区──┐  ┌─────无序区────┐
        // [0, 1, 2, 3, 5, 7, 9, 4, 6, 8]
        //                       ↑
    }
}
