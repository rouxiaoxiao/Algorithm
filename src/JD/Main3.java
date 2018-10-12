package JD;

import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            String s=in.next();
            helper(s);
        }
    }
    private static void helper(String s){
        Stack<Character> stack=new Stack<Character>();
        int book = 0;
        for (int i=0;i<s.length();i++){
            if(book==-1){
                int j=i;
            }
            if (s.charAt(i)=='('){
                book++;
            }else if (s.charAt(i)==')'){
                book--;
            }else {
                System.out.println("错误输入");
                return;
            }
        }
    }
}
