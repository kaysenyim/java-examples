import java.util.Arrays;

/**
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访
 * 数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢
 * 慢“浮”到数列的顶端。<br>
 *
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；<br>
 * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；<br>
 * 3. 针对所有的元素重复以上的步骤，除了最后一个；<br>
 * 4. 重复步骤1~3，直到排序完成。<br>
 *
 * 时间复杂度：Ο(n²)<br>
 * 空间复杂度：Ο(1)<br>
 */
public class BubbleSort {
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 3, 0, 5, 1, 9, 4, 6, 8};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        // [2, 7, 3, 0, 5, 1, 9, 4, 6, 8]
        //  ↑  ↑
        // [2, 7, 3, 0, 5, 1, 9, 4, 6, 8]
        //     ↑  ↑
        // [2, 3, 7, 0, 5, 1, 9, 4, 6, 8]
        //     ↑←→↑
        // ......
        // [2, 3, 0, 5, 1, 7, 4, 6, 9, 8]
        //                          ↑←→↑
        // [2, 3, 0, 5, 1, 7, 4, 6, 8, 9]
        // ......
    }
}
