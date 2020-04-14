/**
 * @author icanner
 * @date 2020/4/49:50 下午
 * @descrption: 只考虑字母和数字在内的回文字符串，忽略大小写
 */
public class 回文字符串 {

    public static void main(String[] args) {
        String s = "Abcs1e 1sCba";
        回文字符串 palindrome = new 回文字符串();
        boolean isPalindrome = palindrome.isPalindrome(s);
        System.out.println(isPalindrome);

    }

    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private boolean isEqualIgnoreCase(char a, char b) {
        if (a >= 'A' && a <= 'Z') {
            a += 32;
        }
        if (b >= 'A' && b <= 'Z') {
            b += 32;
        }
        return a == b;
    }


    /**
     * 思路， 采用双指针
     *
     * @param s
     * @return
     */
    private boolean isPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        for(; i < j; ++i, --j) {
            while (i < j && !isAlphanumeric(s.charAt(i))) ++i;
            while (i < j && !isAlphanumeric(s.charAt(j))) --j;
            if (i < j && !isEqualIgnoreCase(s.charAt(i), s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
