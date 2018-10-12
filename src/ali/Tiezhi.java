package ali;

import java.util.*;

/**
 * @Author: liangxiao
 * @Date: Created in 23:53 2018/8/3
 */
public class Tiezhi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kidsStr = sc.next();
        String[] kidStr = kidsStr.split(",");
        int count = kidStr.length;
        int[] kids = new int[count];
        for (int i = 0; i < count; i++) {
            kids[i] = Integer.parseInt(kidStr[i]);
        }
        int[] result = new int[count];
        //标记峰值 极大值为1，极小值为-1
        int[] book = findToPAndBottom(kids);
        //将book中的标记的峰值索引放入set中
        List<Integer> bookList = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            if (book[i] != 0) {
                bookList.add(i);
            }
        }
        //将极小值都改为1
        for (int i = 0; i < count; i++) {
            if (book[i] == -1) {
                result[i] = 1;
            }
        }
        //更改单调函数都为所能达到的最小值
        for (int i = 0; i < bookList.size() -1 ; i++) {
            handleSection(book, result, bookList.get(i), bookList.get(i + 1));
        }
        //解决极大值
        if (book[0] == 1) {
            result[0] = result[1] + 1;
        }
        if (book[count - 1] == 1) {
            result[count - 1] = result[count - 2] + 1;
        }
        for (int i = 1; i < count - 1; i++) {

            if (book[i] == 1) {
                result[i] = result[i - 1] > result[i + 1] ? result[i - 1] + 1 : result[i + 1] + 1;

            }
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum = sum + result[i];
        }
        System.out.println(Arrays.toString(book));
        System.out.println(Arrays.toString(result));
        System.out.println(bookList);
        System.out.println(sum);
    }

    //标记峰值
    private static int[] findToPAndBottom(int[] kids) {
        int length = kids.length;
        int[] book = new int[length];
        if (length < 2) {
            return book;
        }
        if (kids[0] > kids[1]) {
            book[0] = 1;
        } else {
            book[0] = -1;
        }
        if (kids[length - 1] < kids[length - 2]) {
            book[length - 1] = -1;
        } else {
            book[length - 1] = 1;
        }
        for (int i = 1; i < length - 1; i++) {
            if (kids[i] < kids[i + 1] && kids[i] < kids[i - 1]) {
                book[i] = -1;
            } else if (kids[i] > kids[i + 1] && kids[i] > kids[i - 1]) {
                book[i] = 1;
            }
        }
        return book;
    }

    private static void handleSection(int[] book, int[] result, int start, int end) {
        if (book[start] == 1 && book[end] == -1) {
            for (int i = end - 1; i > start; i--) {
                result[i] = result[i + 1] + 1;
            }
        } else {
            for (int i = start + 1; i < end; i++) {
                result[i] = result[i - 1] + 1;
            }
        }
    }

}
