package offer.Chapter2;

/**
 * @Author liangxiao
 * @Date 2017/10/24 11:00
 * <p>
 * 面试题5：替换空格
 */
public class ReplaceSpace {

    //输入类型为StringBuffer，可以直接替换
    static String replaceSpace1(StringBuffer words) {
        if (words == null) {
            return null;
        }
        for (int i = 0; i < words.length(); i++) {
            //双引号是字符串String，单引号是字符char
            if (words.charAt(i) == ' ') {
                words.replace(i, i + 1, "%20");
            }
        }
        return words.toString();
    }

    //输入类型为String，需创建新的StringBuilder
    static String replaceSpace2(String words) {
        StringBuilder newStr = new StringBuilder();//一定要创建一个新的StringBuilder，因为String是不可变的
        if (words == null) {
            return null;
        }
        for (int i = 0; i < words.length(); i++) {
            //双引号是字符串String，单引号是字符char
            if (words.charAt(i) == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(words.charAt(i));
            }
        }
        return newStr.toString();
    }

    static String replaceSpace3(String words) {
        StringBuffer newStr = new StringBuffer();//一定要创建一个新的StringBuilder，因为String是不可变的
        if (words == null) {
            return null;
        }
        for (int i = 0; i < words.length(); i++) {
            //双引号是字符串String，单引号是字符char
            if (words.charAt(i) == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(words.charAt(i));
            }
        }
        return newStr.toString();
    }


    //c中所用方法，因为类似数组,接近考点
    private static String replaceSpace4(StringBuffer s) {
        if (s == null || s.length() == 0) {
            return s.toString();
        }
        int length = s.length();
        int sumOfSpace = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                sumOfSpace++;
            }
        }
        int newLength = length + sumOfSpace * 2;
        int newIndex = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                s.setCharAt(newIndex--, '0');
                s.setCharAt(newIndex--, '2');
                s.setCharAt(newIndex--, '%');
            } else {
                s.setCharAt(newIndex--, s.charAt(i));
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String words = "Hello World! ahaha";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello World! ahaha");
        System.out.println(stringBuffer);
        System.out.println(replaceSpace1(stringBuffer));
        System.out.println(replaceSpace2(words));
        System.out.println(replaceSpace4(stringBuffer));
    }
}
