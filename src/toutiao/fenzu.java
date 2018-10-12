package toutiao;

import java.util.*;

/**
 * @Author: liangxiao
 * @Date: Created in 10:32 2018/8/25
 * <p>
 * 10
 * 0
 * 5 3 0
 * 8 4 0
 * 9 0
 * 9 0
 * 3 0
 * 0
 * 7 9 0
 * 0
 * 9 7 0
 */
public class fenzu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<TreeSet<Integer>> setList = new ArrayList<>();
        //list中索引为0的对应编号为1的组
        for (int i = 0; i < n; i++) {
            System.out.println("i=" + i);
            TreeSet<Integer> set = new TreeSet<>();
            set.add(i + 1);
            int temp = in.nextInt();
            System.out.println("temp=" + temp);
            while (temp != 0) {
                if (i == 9) {
                    System.out.println("test");
                }
                set.add(temp);
                System.out.println("settemp:" + set);
                temp = in.nextInt();
            }
            System.out.println("set" + set);
            setList.add(set);
        }
//        scanner:
//        for (int i = 0; i < n; i++) {
//            String line = in.nextLine();
//            System.out.println("line=" + line);
//            String[] subLine = line.split(" ");
//            TreeSet<Integer> set = new TreeSet<>();
//            set.add(i + 1);
//            for (String sub : subLine) {
//                if (!"".equals(sub) && Integer.parseInt(sub) == 0) {
//                    break scanner;
//                }
//                if (!"".equals(sub)) {
//                    set.add(Integer.parseInt(sub));
//                }
//            }
//            setList.add(set);
//        }
        int[] book = helper(setList, n);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n + 1; i++) {
            set.add(book[i]);
        }
        //抛去0
        System.out.println(set.size() - 1);
        System.out.println(n);
        System.out.println(setList);
    }

    //返回标记数据
    private static int[] helper(List<TreeSet<Integer>> setList, int n) {
        int[] book = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            book[i] = i;
        }
        //遍历book
        for (int i = 1; i < n + 1; i++) {
            TreeSet<Integer> set = setList.get(i - 1);
            int min = Integer.MAX_VALUE;
            for (int j : set) {
                if (book[j] < min) {
                    min = book[j];
                }
                if (set.first() < min) {
                    min = set.first();
                }
            }
            for (int j : set) {
                book[j] = min;
            }
        }
        return book;
    }
}
