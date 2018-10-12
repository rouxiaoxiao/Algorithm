package offer.Chapter2;

/**
 * @Author liangxiao
 * @Date 2017/10/24 10:14
 *
 * 面试题4：二维数组中的查找
 */
public class Find {
    public static boolean find(int [][] array,int target) {
        int row=0;
        if (array.length!=0) {
            int col = array[0].length-1;

            while (row <= array.length - 1 && col >= 0) {
                if (target < array[row][col]) {
                    col--;
                } else if (target > array[row][col]) {
                    row++;
                } else {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] nums={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        int[][] nums={};
        System.out.println(find(nums,0));
    }
}
