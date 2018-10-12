package didi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: liangxiao
 * @Date: Created in 20:03 2018/9/18
 */
public class Pinxiejiucuo {

    private static char[] chars1 = {'q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v'};
    private static char[] chars2 = {'y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm'};

    private static Set<Character> set1 = new HashSet<>();
    private static Set<Character> set2 = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] words = line.split(" ");
        int[] book = new int[words.length];
        for (int i = 0; i < chars1.length; i++) {
            set1.add(chars1[i]);
        }
        for (int i = 0; i < chars2.length; i++) {
            set2.add(chars2[i]);
        }
        for (int i = 1; i < words.length; i++) {
            book[i] = fen(words[0], words[i]);
        }
        int count = 0;
        int[] index = new int[3];
        while (count < 3) {
            for1:
            for (int j = 0; ; j++) {
                for (int i = 1; i < words.length; i++) {
                    if (book[i] <= j) {
                        index[count] = i;
                        count++;
                        book[i] = Integer.MAX_VALUE;
                        if (count == 3) {
                            break for1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < index.length; i++) {
            System.out.print(words[index[i]] + " ");
        }


    }

    private static int fen(String trueWord, String dictWord) {
        int fen = 0;
        if (trueWord != null && trueWord.equals(dictWord)) {
            return fen;
        }
        if (trueWord.length() == dictWord.length()) {
            for (int i = 0; i < trueWord.length(); i++) {
                if (trueWord.charAt(i) == dictWord.charAt(i)) {
                    continue;
                } else {
                    if (set1.contains(trueWord.charAt(i)) && set2.contains(dictWord.charAt(i))) {
                        fen = fen + 2;
                    } else {
                        fen = fen + 1;
                    }
                }
            }
        }

        return Integer.MAX_VALUE;

    }


}
