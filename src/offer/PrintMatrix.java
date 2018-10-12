package offer;

import java.util.ArrayList;

/**
 * @author liangxiao
 * @date 2017/12/4 11:40
 * 顺时针打印矩阵
 */
public class PrintMatrix {
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int start = 0;
        while (start * 2 < row && start * 2 < column) {
            printCircle(matrix, start, list);
            start++;
        }
        return list;
    }

    private static ArrayList<Integer> printCircle(int[][] matrix, int start, ArrayList<Integer> list) {
        int row = matrix.length;
        int column = matrix[0].length;
        for (int i = start; i < column - start; i++) {
            list.add(matrix[start][i]);
        }
        if (row - 1 - start > start) {
            for (int i = start + 1; i < row - start; i++) {
                list.add(matrix[i][column - 1 - start]);
            }
        }
        if (column - start - 1 > start && row - start - 1 > start) {
            for (int i = column - start - 2; i > start; i--) {
                list.add(matrix[row - start - 1][i]);
            }
        }
        if (row - 1 - start > start && column - 1 - start > start) {
            for (int i = row - start - 1; i > start; i--) {
                list.add(matrix[i][start]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] b = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] c = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] d = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] e = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        int[][] f = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
        System.out.println(b.length);
        System.out.println(printMatrix(a));
        System.out.println(printMatrix(b));
        System.out.println(printMatrix(c));
        System.out.println(printMatrix(d));
        System.out.println(printMatrix(e));
        System.out.println(printMatrix(f));
    }
}
