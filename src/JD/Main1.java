package JD;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(s);
        System.out.println(isHuiWen(s));
        StringBuilder sb =new StringBuilder();
        for (int i=0;i<s.length()-1;i++){
            sb.append(s.charAt(i));
            if (isHuiWen(sb.toString())){

            }
        }
    }

    private static boolean isHuiWen(String s){
        for (int i=0,j=s.length()-1;i<=j;i++,j--){
            if(s.charAt(i)==s.charAt(j)){
                continue;
            }else {
                return false;
            }

        }
        return true;
    }
}
