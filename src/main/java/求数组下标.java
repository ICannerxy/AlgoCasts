
/**
 * @author icanner
 * @date 2020/4/410:27 下午
 * @descrption: 给定一个整数数组，数组中的值递增排序，要找到两个整数，他们的和等于目标值，求出这两个整数在数组中的下标,下标以1开始
 */
public class 求数组下标 {

    public static void main(String[] args) {
        int[] indexArr = 求数组下标.getTwoNumSumToGivenValue(new int[]{1, 2, 3, 5, 6, 8, 10}, 10);
        for (int index : indexArr) {
            System.out.println(index);
        }
    }

    /**
     * 思路：头尾双指针
     * 由于是有序的数组，左边指针加上右边指针大于目标值，则右边指针左移
     * 左边指针加上右边指针小于目标值，则左边指针右移，直到相等
     * Time: O(N) Space: O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] getTwoNumSumToGivenValue(int[] numbers, Integer target) {
        if (null == numbers) {
            return new int[]{-1, -1};
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if ((numbers[i] + numbers[j]) > target) {
                --j;
            } else if ((numbers[i] + numbers[j]) < target) {
                ++i;
            } else {
                return new int[]{i + 1, j +1};
            }
        }
        return new int[]{-1, -1};
    }
}
