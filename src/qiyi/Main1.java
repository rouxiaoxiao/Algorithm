package qiyi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dataIn = sc.next();
        System.out.println(helper(dataIn));
    }
    private static String helper(String dataIn){
        if (dataIn==null||dataIn.length()==0){
            return dataIn;
        }
        char[] chars=dataIn.toCharArray();
        char c='A';
        int index = -1;
        StringBuilder stringBuilder=new StringBuilder();
        helper2(chars,0,chars.length,c,index,stringBuilder);
        return stringBuilder.toString();
    }

    private static void helper2(char[] chars,int start,int end,char c,int index,StringBuilder stringBuilder){
        for (int i=end-1;i>=start;i--){
            if (chars[i]>=c){
                c=chars[i];
                index =i;
            }
        }
        if (index==-1){return;}
        stringBuilder.append(c);

        helper2(chars,index+1,end,'A',-1,stringBuilder);
    }


}
