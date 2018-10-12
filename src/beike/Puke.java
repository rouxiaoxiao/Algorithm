package beike;//package beike;
//
///**
// * @Author: liangxiao
// * @Date: Created in 20:56 2018/8/18
// */
//public class Puke {
//    public static void main(String[] args) {
//        int n=count(); //发牌次数
//        System.out.println(n);
//    }
//    private static int count(){
//
//    }
//
//
//    public static boolean isDan(List<Card> myCards) {
//        // 默认不是单
//        boolean flag = false;
//        if (myCards != null && myCards.size() == 1) {
//            flag = true;
//        }
//        return flag;
//    }
//
//    public static boolean isDuiZi(List<Card> myCards) {
//        // 默认不是对子
//        boolean flag = false;
//
//        if (myCards != null && myCards.size() == 2) {
//
//            int grade1 = myCards.get(0).grade;
//            int grade2 = myCards.get(1).grade;
//            if (grade1 == grade2) {
//                flag = true;
//            }
//        }
//
//        return flag;
//
//    }
//    public static int isSanDaiYi(List<Card> myCards) {
//        int flag = -1;
//        // 默认不是3带1
//        if (myCards != null && myCards.size() == 4) {
//            // 对牌进行排序
//            CardUtil.sortCards(myCards);
//
//            int[] grades = new int[4];
//            grades[0] = myCards.get(0).grade;
//            grades[1] = myCards.get(1).grade;
//            grades[2] = myCards.get(2).grade;
//            grades[3] = myCards.get(3).grade;
//
//            // 暂时认为炸弹不为3带1
//            if ((grades[1] == grades[0]) && (grades[2] == grades[0])
//                    && (grades[3] == grades[0])) {
//                return -1;
//            }
//            // 3带1，被带的牌在牌头
//            else if ((grades[1] == grades[0] && grades[2] == grades[0])) {
//                return 0;
//            }
//            // 3带1，被带的牌在牌尾
//            else if (grades[1] == grades[3] && grades[2] == grades[3]) {
//                return 3;
//            }
//        }
//        return flag;
//    }
//
//    public static boolean isShunZi(List<Card> myCards) {
//        // 默认是顺子
//        boolean flag =
//}
