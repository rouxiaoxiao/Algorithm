package nineChapter.chapter1;
/**
 * 在一个字符串中查找一个子字符串，并返回第一次出现的索引位置
 * @Author: liangxiao
 * @Date: Created in 23:25 2018/5/2
 */
public class strStr {
    public static void main(String[] args) {
        String source = "abcdabcdefg";
        String target = "bcd";
        int result = strStr(source,target);
        System.out.println(result);
    }

    private static int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}
