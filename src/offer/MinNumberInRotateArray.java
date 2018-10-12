package offer;

/**
 * @Author liangxiao
 * @Date 2017/10/27 15:54
 *
 * 旋转数组的最小数字
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        MinNumberInRotateArray minNumberInRotateArray= new MinNumberInRotateArray();
        int[] a={4,5,6,7,1,2,3};
        System.out.println(minNumberInRotateArray.minNumberInRotateArray(a));
    }
}
