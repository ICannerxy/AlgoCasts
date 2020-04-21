/**
 * @author icanner
 * @date 2020/4/2110:22 下午
 * @description: 行递增和列递增的二维数组
 */
public class 七_行列递增的二维数组搜索 {

    // Time: O(m + n) Space: O(1)
    public int[] searchIn2DArray(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }
        // 行数m 列数n
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] > target) --j;
            else if (matrix[i][j] < target) ++i;
            else return new int[]{i, j};
        }
        return new int[]{-1, -1};
    }
}
