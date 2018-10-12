package groceries;

import java.util.*;

public class Test1 {


    private static int intHelper(int i, int j) {
        int result = 0;
        while (i / 10 != 0) {
            result = result + i % 10;
            i = i / 10;
        }
        result = result + i;
        while (j / 10 != 0) {
            result = result + j % 10;
            j = j / 10;
        }
        result = result + j;
        return result;
    }

    public static int movingCount(int threshold, int rows, int cols) {
        int count = 0;
        helper(threshold, rows, 0, cols, 0, count);
        return count;
    }

    private static void helper(int threshold, int rows, int i, int cols, int j, int count) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || intHelper(i, j) > threshold) {
            return;
        }
        count++;
//        helper(threshold,rows,i-1,cols,j,count);
        helper(threshold, rows, i + 1, cols, j, count);
//        helper(threshold,rows,i,cols,j-1,count);
        helper(threshold, rows, i, cols, j + 1, count);
    }

    private static boolean isUniqueChars(String str) {
        if (str.length() > 256) {
            return false;
        }
        int checker=0;
        for (int i=0;i<str.length();i++){
            int val=str.charAt(i)-'a';
            if((checker&(1<<val))>0){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int i = 35;
        int j = 38;
        System.out.println(intHelper(i, j));
        movingCount(18, 50, 50);


    }
}
