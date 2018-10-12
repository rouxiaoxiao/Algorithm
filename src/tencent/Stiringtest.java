package tencent;

import java.util.HashSet;
import java.util.Set;

public class Stiringtest {

    public static void main(String[] args) {

    }

    private static String remove(String s1, String s2) {

        if (s2 == null || s2.length() == 0) {
            return s1;
        }
        Set<Character> cs = new HashSet<Character>();
        for (int i = 0; i < s2.length(); i++) {
            cs.add(s2.charAt(i));
        }
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<s1.length();i++){
            if(cs.contains(s1.charAt(i))){
                continue;
            }else {
                builder.append(s1.charAt(i));
            }
        }
        return builder.toString();
    }
}
