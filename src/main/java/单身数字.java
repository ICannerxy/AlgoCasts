import java.util.HashSet;
import java.util.Set;

/**
 * @author icanner
 * @date 2020/4/1910:34 下午
 */
public class 单身数字 {

    public static void main(String[] args) {
        单身数字 num = new 单身数字();
        System.out.println(num.singleNumberWithSet(new int[]{1,1,2,2,3,5,6,5,6}));
    }

    // Time: O(n) Space: O(n)
    public int singleNumberWithSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, uniqueSum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                uniqueSum += num;
                set.add(num);
            }
            sum += num;
        }
        return 2 * uniqueSum - sum;
    }

    /**
     * 思路：
     * 异或，相同为0，不同为1，两个相同的数异或结果为0
     *
     * @param nums
     * @return
     */
    public int singleNumberWithXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }


}
