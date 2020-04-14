import java.util.HashMap;
import java.util.Map;

/**
 * @author icanner
 * @date 2020/4/148:02 下午
 * @description:
 */
public class 求和为给定值的两个数 {


    public static void main(String[] args) {
        int[] twoSum = 求和为给定值的两个数.getTwoSum(new int[]{1, 2, 4, 5, 7, 8, 10}, 10);
        for (int index : twoSum) {
            System.out.println(index);
        }
    }

    /**
     * 思路: 利用hashMap来存储值和下标，每次循环的时候先判断hashMap中是否存在 目标值-当前值 的key
     * 如果存在， 那么就找到了这两个数字，直接返回该数字的下标
     * Time: O(N) Space: O(N)
     *
     * @param arr
     * @param target
     * @return
     */
    public static int[] getTwoSum(int[] arr, int target) {
        if (null == arr) {
            return new int[]{-1, -1};
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int anotherNum = target - arr[i];
            if (map.containsKey(anotherNum)) {
                return new int[]{map.get(anotherNum), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}
