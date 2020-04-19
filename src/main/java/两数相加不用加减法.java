/**
 * @author icanner
 * @date 2020/4/1811:07 下午
 * @descrption 求两个数之和，不能用算术运算符
 */
public class 两数相加不用加减法 {

    public static void main(String[] args) {
        两数相加不用加减法 item = new 两数相加不用加减法();
        System.out.println(item.getSumRecursive(9, 11));
    }

    public int getSumRecursive(int a, int b) {
        return b == 0 ? a : getSumRecursive(a ^ b, (a & b) << 1);
    }

    // Time O(m) Space: O(1)
    public int getSumIterative(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
