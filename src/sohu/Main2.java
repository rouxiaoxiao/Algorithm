package sohu;


import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        System.out.print(nums[0]);
        for (int i = 1; i < k; i++) {
            System.out.print("," + nums[i]);
        }
    }
}
